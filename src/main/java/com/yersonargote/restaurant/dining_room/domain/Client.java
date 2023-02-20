package com.yersonargote.restaurant.dining_room.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Column(nullable = false, unique = true)
    String identification;
    @Column(nullable = false)
    String name;
    @Column(name = "last_name", nullable = false)
    String lastName;
    @Column(nullable = false, unique = true)
    String phone;
    @OneToMany(mappedBy = "client")
    List<Order> orders;
}