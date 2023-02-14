package com.yersonargote.restaurant.dining_room.dto;

import com.yersonargote.restaurant.dining_room.domain.Category;
import lombok.Builder;

@Builder
public record DishDTO(
        String name,
        String description,
        Double price,
        Boolean available,
        Category category
) {
}
