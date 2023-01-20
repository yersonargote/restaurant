package com.yersonargote.restaurant.dining_room.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "payments")
public record Payment(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        UUID id
        // Order
        // Client
        // Amount
) {
}
