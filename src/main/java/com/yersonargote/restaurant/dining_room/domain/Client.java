package com.yersonargote.restaurant.dining_room.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "clients")
@Builder
public record Client(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        UUID id,
        @Column(nullable = false)
        String name,
        @Column(name = "last_name", nullable = false)
        String lastName,
        @Column(nullable = false)
        String phone,
        @OneToMany(mappedBy = "client")
        List<Order> orders
) {
}
