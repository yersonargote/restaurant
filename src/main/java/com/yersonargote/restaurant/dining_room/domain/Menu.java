package com.yersonargote.restaurant.dining_room.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "menus")
public record Menu(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        UUID id,
        @Column(nullable = false)
        String name,
        @Column(nullable = false)
        Date date,
        @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(
                name = "menus_dishes",
                joinColumns = @JoinColumn(name = "menu_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "dish_id", referencedColumnName = "id")
        )
        List<Dish> dishes
) {
}
