package com.yersonargote.restaurant.dining_room.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "tickets")
public class Ticket {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Column(name = "paid_days", nullable = false)
    Long paidDays;
    @Column(name = "consumed_days", nullable = false)
    Long consumedDays;
    @Column(nullable = false)
    Boolean active;
    @OneToOne
    @JoinColumn(name = "order_id")
    Order order;
}
