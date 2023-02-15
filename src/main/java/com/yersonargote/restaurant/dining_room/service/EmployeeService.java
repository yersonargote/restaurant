package com.yersonargote.restaurant.dining_room.service;

import com.yersonargote.restaurant.dining_room.domain.Employee;
import com.yersonargote.restaurant.dining_room.repository.EmployeeRepo;
import com.yersonargote.restaurant.dining_room.repository.IGenericRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService extends CrudGenericService<Employee, UUID> {
    private final EmployeeRepo employeeRepository;

    @Override
    protected IGenericRepository<Employee, UUID> getRepository() {
        return employeeRepository;
    }
}