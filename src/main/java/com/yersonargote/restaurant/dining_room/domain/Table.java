package com.yersonargote.restaurant.dining_room.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@jakarta.persistence.Table(name = "tables")
public class Table {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Column(nullable = false)
    int number;
    @Column(nullable = false)
    int capacity;
    @Column(nullable = false)
    Boolean available;
}
