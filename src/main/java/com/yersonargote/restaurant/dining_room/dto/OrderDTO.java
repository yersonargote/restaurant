package com.yersonargote.restaurant.dining_room.dto;

import com.yersonargote.restaurant.dining_room.domain.OrderStatus;
import lombok.Builder;

import java.util.Date;
import java.util.UUID;

@Builder
public record OrderDTO(
        Date datetime,
        OrderStatus status,
        UUID employeeId,
        UUID clientId
) {
}
