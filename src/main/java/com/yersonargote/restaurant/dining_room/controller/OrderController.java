package com.yersonargote.restaurant.dining_room.controller;

import com.yersonargote.restaurant.dining_room.domain.Order;
import com.yersonargote.restaurant.dining_room.dto.OrderDTO;
import com.yersonargote.restaurant.dining_room.mapper.OrderMapper;
import com.yersonargote.restaurant.dining_room.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Iterable<OrderDTO>> getAllOrders(
            @RequestParam(defaultValue = "0", required = false) Integer page,
            @RequestParam(defaultValue = "10", required = false) Integer size,
            @RequestParam(defaultValue = "name", required = false) String sortBy
    ) {
        Pageable paging = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Order> orders = orderService.findAll(paging);
        List<OrderDTO> ordersDTO = orders.map(orderMapper::toDTO).getContent();
        return ResponseEntity.ok(ordersDTO);
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
