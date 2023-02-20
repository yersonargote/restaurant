package com.yersonargote.restaurant.dining_room.dto;

import lombok.Builder;

@Builder
public record ClientDTO(
        String identification,
        String name,
        String lastName,
        String phone
) {
}
