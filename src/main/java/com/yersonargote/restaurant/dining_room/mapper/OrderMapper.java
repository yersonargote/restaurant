package com.yersonargote.restaurant.dining_room.mapper;

import com.yersonargote.restaurant.dining_room.domain.Client;
import com.yersonargote.restaurant.dining_room.domain.Employee;
import com.yersonargote.restaurant.dining_room.domain.Order;
import com.yersonargote.restaurant.dining_room.dto.OrderDTO;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderDTO toDTO(Order order) {
        return OrderDTO.builder()
                .datetime(order.datetime())
                .status(order.status())
                .employeeId(order.employee().id())
                .clientId(order.client().id())
                .build();
    }

    public Order toDomain(OrderDTO orderDTO) {
        return Order.builder()
                .datetime(orderDTO.datetime())
                .status(orderDTO.status())
                .client(Client.builder().id(orderDTO.clientId()).build())
                .employee(Employee.builder().id(orderDTO.employeeId()).build())
                .build();
    }
}
