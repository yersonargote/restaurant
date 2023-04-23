package com.yersonargote.restaurant.dining_room.controller;

import com.yersonargote.restaurant.dining_room.domain.Payment;
import com.yersonargote.restaurant.dining_room.dto.PaymentDTO;
import com.yersonargote.restaurant.dining_room.mapper.PaymentMapper;
import com.yersonargote.restaurant.dining_room.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    private final PaymentMapper paymentMapper;

    @GetMapping(path = "/payment", produces = "application/json")
    public ResponseEntity<Iterable<PaymentDTO>> getAllPayments(
            @RequestParam(defaultValue = "0", required = false) Integer page,
            @RequestParam(defaultValue = "10", required = false) Integer size,
            @RequestParam(defaultValue = "name", required = false) String sortBy
    ) {
        Pageable paging = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Payment> payments = paymentService.findAll(paging);
        List<PaymentDTO> paymentsDTO = payments.map(paymentMapper::toDTO).getContent();
        return ResponseEntity.ok(paymentsDTO);
    }

    @GetMapping(path = "/payment/{id}", produces = "application/json")
    public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable UUID id) {
        Optional<Payment> payment = paymentService.findById(id);
        return payment
                .map(value -> ResponseEntity.ok(paymentMapper.toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/payment", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UUID> createPayment(@RequestBody PaymentDTO paymentDTO) {
        Payment payment = paymentMapper.toDomain(paymentDTO);
        payment = paymentService.save(payment);
        if (payment.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(payment.getId());
    }

    @PutMapping(path = "/payment/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PaymentDTO> updatePayment(@PathVariable UUID id, @RequestBody PaymentDTO paymentDTO) {
        Payment payment = paymentMapper.toDomain(paymentDTO);
        payment.setId(id);
        Optional<Payment> updated = paymentService.update(id, payment);
        return updated
                .map(value -> ResponseEntity.ok(paymentMapper.toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/payment/{id}", produces = "application/json")
    public ResponseEntity<UUID> deletePayment(@PathVariable UUID id) {
        Optional<Payment> deleted = paymentService.delete(id);
        return deleted
                .map(value -> ResponseEntity.ok(value.getId()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
