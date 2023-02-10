package com.yersonargote.restaurant.dining_room.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "order_details")
public record OrderDetail(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        UUID id,
        @Column(nullable = false)
        Long quantity,
        @Column(name = "unit_price", nullable = false)
        Long unitPrice,
        @Column(nullable = false)
        Long discount,
        @Id
        @ManyToOne
        @JoinColumn(name = "order_id")
        Order order,
        @Id
        @ManyToOne
        @JoinColumn(name = "dish_id")
        Dish dishes
) {
}
