package com.yersonargote.restaurant.dining_room.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "dishes")
public class Dish {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Column(nullable = false, unique = true)
    String name;
    @Column(nullable = false)
    String description;
    @Column(nullable = false)
    Double price;
    @Column(nullable = false)
    Boolean available;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    Category category;
    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    List<OrderDetail> ordersDetail;
}
