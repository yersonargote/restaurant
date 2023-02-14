package com.yersonargote.restaurant.dining_room.mapper;

import com.yersonargote.restaurant.dining_room.domain.Dish;
import com.yersonargote.restaurant.dining_room.domain.Order;
import com.yersonargote.restaurant.dining_room.domain.OrderDetail;
import com.yersonargote.restaurant.dining_room.dto.OrderDetailDTO;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailMapper {
    public OrderDetailDTO toDTO(OrderDetail orderDetail) {
        return OrderDetailDTO.builder()
                .quantity(orderDetail.quantity())
                .unitPrice(orderDetail.unitPrice())
                .discount(orderDetail.discount())
                .orderId(orderDetail.order().id())
                .dishId(orderDetail.dish().id())
                .build();
    }

    public OrderDetail toDomain(OrderDetailDTO orderDetailDTO) {
        return OrderDetail.builder()
                .quantity(orderDetailDTO.quantity())
                .unitPrice(orderDetailDTO.unitPrice())
                .discount(orderDetailDTO.discount())
                .order(Order.builder().id(orderDetailDTO.orderId()).build())
                .dish(Dish.builder().id(orderDetailDTO.dishId()).build())
                .build();
    }
}
