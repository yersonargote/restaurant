package com.yersonargote.restaurant.dining_room.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter
    UUID id;
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date datetime;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    OrderStatus status;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    List<OrderDetail> ordersDetail;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    Employee employee;
    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    Payment payment;
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    Ticket ticket;
}
