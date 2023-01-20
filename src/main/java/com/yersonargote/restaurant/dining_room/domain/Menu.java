package com.yersonargote.restaurant.dining_room.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "menus")
public record Menu(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        UUID id,
        String name,
        Date date
) {
}
