package com.yersonargote.restaurant.dining_room.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Builder;

import java.util.UUID;

@Entity
@Table(name = "order_details")
@Builder
public record OrderDetail(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        UUID id,
        @Column(nullable = false)
        Long quantity,
        @Column(name = "unit_price", nullable = false)
        Double unitPrice,
        @Column(nullable = false)
        Double discount,
        @ManyToOne
        @JoinColumn(name = "order_id")
        Order order,
        @ManyToOne
        @JoinColumn(name = "dish_id")
        Dish dish
) {
}
