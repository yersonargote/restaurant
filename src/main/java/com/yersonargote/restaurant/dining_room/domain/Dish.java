package com.yersonargote.restaurant.dining_room.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dishes")
public record Dish(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        Long id,
        String name,
        String description,
        Double price
) {
}
