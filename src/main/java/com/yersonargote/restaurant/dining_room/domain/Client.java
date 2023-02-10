package com.yersonargote.restaurant.dining_room.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "clients")
public record Client(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        UUID id,
        @Column(nullable = false)
        String name,
        @Column(nullable = false)
        String phone,
        @OneToMany(mappedBy = "client")
        List<Order> orders
) {
}
