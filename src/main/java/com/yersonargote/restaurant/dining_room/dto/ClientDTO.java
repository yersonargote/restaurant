package com.yersonargote.restaurant.dining_room.dto;

import lombok.Builder;

@Builder
public record ClientDTO(
        String name,
        String lastName,
        String phone
) {
}
