package com.yersonargote.restaurant.dining_room.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "orders")
public record Order(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        UUID id
        // Dishes
        // Table
        // Waiter
        // Date
        // Total
) {
}
