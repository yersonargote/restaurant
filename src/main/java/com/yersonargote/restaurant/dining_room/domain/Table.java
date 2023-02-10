package com.yersonargote.restaurant.dining_room.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@jakarta.persistence.Table(name = "tables")
public record Table(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        UUID id,
        @Column(nullable = false)
        int number,
        @Column(nullable = false)
        int capacity,
        @Column(nullable = false)
        boolean available
) {
}
