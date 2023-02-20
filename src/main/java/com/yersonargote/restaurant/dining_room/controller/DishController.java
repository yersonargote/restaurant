package com.yersonargote.restaurant.dining_room.controller;

import com.yersonargote.restaurant.dining_room.domain.Dish;
import com.yersonargote.restaurant.dining_room.dto.DishDTO;
import com.yersonargote.restaurant.dining_room.mapper.DishMapper;
import com.yersonargote.restaurant.dining_room.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DishController {
    private final DishService dishService;
    private final DishMapper dishMapper;

    @GetMapping(path = "/dish", produces = "application/json")
    public ResponseEntity<Iterable<DishDTO>> getAllDishes() {
        Iterable<Dish> dishes = dishService.findAll();
        List<DishDTO> dishDTOS = new ArrayList<>();
        dishes.forEach(dish -> dishDTOS.add(dishMapper.toDTO(dish)));
        return ResponseEntity.ok(dishDTOS);
    }

    @GetMapping(path = "/dish/{id}", produces = "application/json")
    public ResponseEntity<DishDTO> getDishById(@PathVariable UUID id) {
        Optional<Dish> dish = dishService.findById(id);
        return dish
                .map(value -> ResponseEntity.ok(dishMapper.toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/dish", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UUID> createDish(@RequestBody DishDTO dishDTO) {
        Dish dish = dishMapper.toDomain(dishDTO);
        dish = dishService.save(dish);
        if (dish.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(dish.getId());
    }

    @PutMapping(path = "/dish/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DishDTO> updateDish(@PathVariable UUID id, @RequestBody DishDTO dishDTO) {
        Dish dish = dishMapper.toDomain(dishDTO);
        dish.setId(id);
        Optional<Dish> updated = dishService.update(id, dish);
        return updated
                .map(value -> ResponseEntity.ok(dishMapper.toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/dish/{id}", produces = "application/json")
    public ResponseEntity<UUID> deleteDish(@PathVariable UUID id) {
        Optional<Dish> deleted = dishService.delete(id);
        return deleted
                .map(value -> ResponseEntity.ok(value.getId()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
