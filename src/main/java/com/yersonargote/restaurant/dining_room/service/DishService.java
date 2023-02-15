package com.yersonargote.restaurant.dining_room.service;

import com.yersonargote.restaurant.dining_room.domain.Dish;
import com.yersonargote.restaurant.dining_room.repository.DishRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class DishService extends CrudGenericService<Dish, UUID> {
    private final DishRepo dishRepository;

    @Override
    protected JpaRepository<Dish, UUID> getRepository() {
        return dishRepository;
    }
}
