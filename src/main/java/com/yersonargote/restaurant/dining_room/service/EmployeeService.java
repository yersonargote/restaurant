package com.yersonargote.restaurant.dining_room.service;

import com.yersonargote.restaurant.dining_room.domain.Employee;
import com.yersonargote.restaurant.dining_room.repository.EmployeeRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService extends CrudGenericService<Employee, UUID> {
    private final EmployeeRepo employeeRepository;

    @Override
    protected JpaRepository<Employee, UUID> getRepository() {
        return employeeRepository;
    }
}