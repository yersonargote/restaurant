package com.yersonargote.restaurant.dining_room.service;

import com.yersonargote.restaurant.dining_room.domain.Payment;
import com.yersonargote.restaurant.dining_room.repository.IGenericRepository;
import com.yersonargote.restaurant.dining_room.repository.PaymentRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentService extends CrudGenericService<Payment, UUID> {
    private final PaymentRepo paymentRepository;

    @Override
    protected IGenericRepository<Payment, UUID> getRepository() {
        return paymentRepository;
    }
}
