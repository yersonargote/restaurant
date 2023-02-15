package com.yersonargote.restaurant.dining_room.repository;

import com.yersonargote.restaurant.dining_room.domain.Dish;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DishRepo extends IGenericRepository<Dish, UUID> {
}
