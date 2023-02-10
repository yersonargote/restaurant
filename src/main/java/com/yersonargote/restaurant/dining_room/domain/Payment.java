package com.yersonargote.restaurant.dining_room.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "payments")
public record Payment(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        UUID id,
        @Column(name = "payment_type", nullable = false)
        @Enumerated(value = EnumType.STRING)
        PaymentType paymentType,
        @Column(nullable = false)
        Long amount,
        @OneToOne
        @JoinColumn(name = "order_id")
        Order order
) {
}
