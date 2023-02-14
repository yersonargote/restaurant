package com.yersonargote.restaurant.dining_room.dto;

import lombok.Builder;

@Builder
public record TableDTO(
        int number,
        int capacity,
        boolean available
) {
}
