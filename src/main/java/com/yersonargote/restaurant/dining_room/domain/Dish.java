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
        String name,
        String description,
        Double price,
        @OneToMany(mappedBy = "dishes", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        List<OrderDetail> ordersDetail,
        @ManyToMany(mappedBy = "dishes")
        List<Menu> menus
) {
}
