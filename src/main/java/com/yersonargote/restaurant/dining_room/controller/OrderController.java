package com.yersonargote.restaurant.dining_room.controller;

import com.yersonargote.restaurant.dining_room.domain.Order;
import com.yersonargote.restaurant.dining_room.dto.OrderDTO;
import com.yersonargote.restaurant.dining_room.mapper.OrderMapper;
import com.yersonargote.restaurant.dining_room.service.OrderService;
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
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping(path = "/order", produces = "application/json")
    public ResponseEntity<Iterable<OrderDTO>> getAllOrders() {
        Iterable<Order> orders = orderService.findAll();
        List<OrderDTO> orderDTOS = new ArrayList<>();
        orders.forEach(order -> orderDTOS.add(orderMapper.toDTO(order)));
        return ResponseEntity.ok(orderDTOS);
    }

    @GetMapping(path = "/order/{id}", produces = "application/json")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable UUID id) {
        Optional<Order> order = orderService.findById(id);
        return order
                .map(value -> ResponseEntity.ok(orderMapper.toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/order", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UUID> createOrder(@RequestBody OrderDTO orderDTO) {
        Order order = orderMapper.toDomain(orderDTO);
        order = orderService.save(order);
        if (order.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(order.getId());
    }

    @PutMapping(path = "/order/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable UUID id, @RequestBody OrderDTO orderDTO) {
        Order order = orderMapper.toDomain(orderDTO);
        order.setId(id);
        Optional<Order> updated = orderService.update(id, order);
        return updated
                .map(value -> ResponseEntity.ok(orderMapper.toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/order/{id}", produces = "application/json")
    public ResponseEntity<UUID> deleteOrder(@PathVariable UUID id) {
        Optional<Order> deleted = orderService.delete(id);
        return deleted
                .map(value -> ResponseEntity.ok(value.getId()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
