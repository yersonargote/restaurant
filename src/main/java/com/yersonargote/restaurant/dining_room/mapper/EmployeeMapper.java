package com.yersonargote.restaurant.dining_room.mapper;

import com.yersonargote.restaurant.dining_room.domain.Employee;
import com.yersonargote.restaurant.dining_room.dto.EmployeeDTO;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public EmployeeDTO toDTO(Employee employee) {
        return EmployeeDTO.builder()
                .name(employee.getName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .employeeType(employee.getEmployeeType())
                .build();
    }

    public Employee toDomain(EmployeeDTO employeeDTO) {
        return Employee.builder()
                .name(employeeDTO.name())
                .lastName(employeeDTO.lastName())
                .email(employeeDTO.email())
                .phone(employeeDTO.phone())
                .employeeType(employeeDTO.employeeType())
                .build();
    }
}
