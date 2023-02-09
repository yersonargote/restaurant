package com.yersonargote.restaurant.dining_room.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public record Order(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        UUID id,
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        Date date,
        @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        List<OrderDetail> ordersDetail,
        @ManyToOne
        @JoinColumn(name = "employee_id")
        Employee employee,
        @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(
                name = "orders_tables",
                joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "table_id", referencedColumnName = "id")
        )
        List<com.yersonargote.restaurant.dining_room.domain.Table> tables,
        @ManyToOne
        @JoinColumn(name = "client_id")
        Client client,
        @OneToOne
        @JoinColumn(name = "payment_id")
        Payment payment
) {
}
