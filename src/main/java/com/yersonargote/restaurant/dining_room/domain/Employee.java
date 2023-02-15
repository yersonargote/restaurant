package com.yersonargote.restaurant.dining_room.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "employees")
public class Employee {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Column(nullable = false)
    String name;
    @Column(name = "last_name", nullable = false)
    String lastName;
    @Column(nullable = false)
    String email;
    @Column(nullable = false)
    String phone;
    @Column(name = "employee_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    EmployeeType employeeType;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    List<Order> orders;
}
