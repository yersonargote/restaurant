package com.yersonargote.restaurant.dining_room.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "payments")
public class Payment {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Column(name = "payment_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    PaymentType paymentType;
    @Column(nullable = false)
    Double amount;
    @OneToOne
    @JoinColumn(name = "order_id")
    Order order;
}
