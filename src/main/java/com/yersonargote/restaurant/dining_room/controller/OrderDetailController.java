package com.yersonargote.restaurant.dining_room.controller;

import com.yersonargote.restaurant.dining_room.domain.OrderDetail;
import com.yersonargote.restaurant.dining_room.dto.OrderDetailDTO;
import com.yersonargote.restaurant.dining_room.mapper.OrderDetailMapper;
import com.yersonargote.restaurant.dining_room.service.OrderDetailService;
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
public class OrderDetailController {
    private final OrderDetailService orderDetailService;
    private final OrderDetailMapper orderDetailMapper;

    @GetMapping(path = "/orderDetail", produces = "application/json")
    public ResponseEntity<Iterable<OrderDetailDTO>> getAllOrderDetails() {
        Iterable<OrderDetail> orderDetails = orderDetailService.findAll();
        List<OrderDetailDTO> orderDetailDTOS = new ArrayList<>();
        orderDetails.forEach(orderDetail -> orderDetailDTOS.add(orderDetailMapper.toDTO(orderDetail)));
        return ResponseEntity.ok(orderDetailDTOS);
    }

    @GetMapping(path = "/orderDetail/{id}", produces = "application/json")
    public ResponseEntity<OrderDetailDTO> getOrderDetailById(@PathVariable UUID id) {
        Optional<OrderDetail> orderDetail = orderDetailService.findById(id);
        return orderDetail
                .map(value -> ResponseEntity.ok(orderDetailMapper.toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/orderDetail", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UUID> createOrderDetail(@RequestBody OrderDetailDTO orderDetailDTO) {
        OrderDetail orderDetail = orderDetailMapper.toDomain(orderDetailDTO);
        orderDetail = orderDetailService.save(orderDetail);
        if (orderDetail.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(orderDetail.getId());
    }

    @PutMapping(path = "/orderDetail/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<OrderDetailDTO> updateOrderDetail(@PathVariable UUID id, @RequestBody OrderDetailDTO orderDetailDTO) {
        OrderDetail orderDetail = orderDetailMapper.toDomain(orderDetailDTO);
        orderDetail.setId(id);
        Optional<OrderDetail> updated = orderDetailService.update(id, orderDetail);
        return updated
                .map(value -> ResponseEntity.ok(orderDetailMapper.toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/orderDetail/{id}", produces = "application/json")
    public ResponseEntity<UUID> deleteOrderDetail(@PathVariable UUID id) {
        Optional<OrderDetail> deleted = orderDetailService.delete(id);
        return deleted
                .map(value -> ResponseEntity.ok(value.getId()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
