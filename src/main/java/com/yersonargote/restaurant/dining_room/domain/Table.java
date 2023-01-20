package com.yersonargote.restaurant.dining_room.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
@jakarta.persistence.Table(name = "tables")
public record Table(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        UUID id,
        int number
) {
}
