package com.yersonargote.restaurant.dining_room.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record TickeDTO(
        Long paidDays,
        Long consumedDays,
        Boolean active,
        UUID orderId
) {
}
