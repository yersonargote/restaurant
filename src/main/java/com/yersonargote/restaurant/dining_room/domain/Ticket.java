package com.yersonargote.restaurant.dining_room.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tickets")
public record Ticket(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        UUID id,
        @Column(name = "paid_days", nullable = false)
        Long paidDays,
        @Column(name = "consumed_days", nullable = false)
        Long consumedDays,
        @Column(nullable = false)
        Boolean active,
        @OneToOne
        @JoinColumn(name = "order_id")
        Order order
) {
}
