package com.yersonargote.restaurant.dining_room.controller;

import com.yersonargote.restaurant.dining_room.domain.Employee;
import com.yersonargote.restaurant.dining_room.dto.EmployeeDTO;
import com.yersonargote.restaurant.dining_room.mapper.EmployeeMapper;
import com.yersonargote.restaurant.dining_room.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<Iterable<EmployeeDTO>> getAllEmployees() {
        Iterable<Employee> employees = employeeService.findAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        employees.forEach(employee -> employeeDTOS.add(employeeMapper.toDTO(employee)));
        return ResponseEntity.ok(employeeDTOS);
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
