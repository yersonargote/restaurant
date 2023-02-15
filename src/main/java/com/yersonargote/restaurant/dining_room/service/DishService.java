package com.yersonargote.restaurant.dining_room.service;

import com.yersonargote.restaurant.dining_room.domain.Dish;
import com.yersonargote.restaurant.dining_room.repository.DishRepo;
import com.yersonargote.restaurant.dining_room.repository.IGenericRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class DishService extends CrudGenericService<Dish, UUID> {
    private final DishRepo dishRepository;

    @Override
    protected IGenericRepository<Dish, UUID> getRepository() {
        return dishRepository;
    }
}
