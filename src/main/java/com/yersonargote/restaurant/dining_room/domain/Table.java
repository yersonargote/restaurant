package com.yersonargote.restaurant.dining_room.domain;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.UUID;

@Entity
@jakarta.persistence.Table(name = "tables")
@Builder
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
    public Table() {
        this(null, 0, 0, false);
    }
}
