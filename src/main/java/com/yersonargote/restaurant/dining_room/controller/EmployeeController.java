package com.yersonargote.restaurant.dining_room.controller;

import com.yersonargote.restaurant.dining_room.domain.Employee;
import com.yersonargote.restaurant.dining_room.dto.EmployeeDTO;
import com.yersonargote.restaurant.dining_room.mapper.EmployeeMapper;
import com.yersonargote.restaurant.dining_room.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @GetMapping(path = "/employee", produces = "application/json")
    public ResponseEntity<Iterable<EmployeeDTO>> getAllEmployees(
            @RequestParam(defaultValue = "0", required = false) Integer page,
            @RequestParam(defaultValue = "10", required = false) Integer size,
            @RequestParam(defaultValue = "name", required = false) String sortBy
    ) {
        Pageable paging = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Employee> employees = employeeService.findAll(paging);
        List<EmployeeDTO> employeesDTO = employees.map(employeeMapper::toDTO).getContent();
        return ResponseEntity.ok(employeesDTO);
    }

    @GetMapping(path = "/employee/{id}", produces = "application/json")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable UUID id) {
        Optional<Employee> employee = employeeService.findById(id);
        return employee
                .map(value -> ResponseEntity.ok(employeeMapper.toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/employee", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UUID> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toDomain(employeeDTO);
        employee = employeeService.save(employee);
        if (employee.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(employee.getId());
    }

    @PutMapping(path = "/employee/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable UUID id, @RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toDomain(employeeDTO);
        employee.setId(id);
        Optional<Employee> updated = employeeService.update(id, employee);
        return updated
                .map(value -> ResponseEntity.ok(employeeMapper.toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/employee/{id}", produces = "application/json")
    public ResponseEntity<UUID> deleteEmployee(@PathVariable UUID id) {
        Optional<Employee> deleted = employeeService.delete(id);
        return deleted
                .map(value -> ResponseEntity.ok(value.getId()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
