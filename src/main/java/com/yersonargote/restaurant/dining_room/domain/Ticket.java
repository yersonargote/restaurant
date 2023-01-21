package com.yersonargote.restaurant.dining_room.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tickets")
public record Ticket(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        UUID id,
        List<Boolean> days
) {
}
