package com.yersonargote.restaurant.dining_room.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "employees")
public record Employee(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        UUID id,
        String name,
        String lastName,
        String email,
        String phone,

        @Enumerated(value = EnumType.STRING) EmployeeType employeeType
) {
}
