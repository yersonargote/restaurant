package com.yersonargote.restaurant.dining_room.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "dishes")
public record Dish(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        UUID id,
        @Column(nullable = false)
        String name,
        @Column(nullable = false)
        String description,
        @Column(nullable = false)
        Double price,
        @OneToMany(mappedBy = "dishes", cascade = CascadeType.ALL)
        List<OrderDetail> ordersDetail,
        @ManyToMany(mappedBy = "dishes", cascade = CascadeType.ALL)
        List<Menu> menus
) {
}
