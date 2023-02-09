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
        int number,
        int capacity,
        boolean available,
        @ManyToMany(mappedBy = "tables", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        List<Order> orders
) {
}
