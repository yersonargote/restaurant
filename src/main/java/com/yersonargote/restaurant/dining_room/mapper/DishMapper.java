package com.yersonargote.restaurant.dining_room.mapper;

import com.yersonargote.restaurant.dining_room.domain.Dish;
import com.yersonargote.restaurant.dining_room.dto.DishDTO;
import org.springframework.stereotype.Component;

@Component
public class DishMapper {
    public DishDTO toDTO(Dish dish) {
        return DishDTO.builder()
                .name(dish.name())
                .description(dish.description())
                .price(dish.price())
                .available(dish.available())
                .category(dish.category())
                .build();
    }

    public Dish toDomain(DishDTO dishDTO) {
        return Dish.builder()
                .name(dishDTO.name())
                .description(dishDTO.description())
                .price(dishDTO.price())
                .available(dishDTO.available())
                .category(dishDTO.category())
                .build();

    }
}
