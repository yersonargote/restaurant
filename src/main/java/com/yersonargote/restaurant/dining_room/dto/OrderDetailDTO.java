package com.yersonargote.restaurant.dining_room.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record OrderDetailDTO(
        Long quantity,
        Double unitPrice,
        Double discount,
        UUID dishId,
        UUID orderId
) {
}
