package com.yersonargote.restaurant.dining_room.mapper;

import com.yersonargote.restaurant.dining_room.domain.Order;
import com.yersonargote.restaurant.dining_room.domain.Payment;
import com.yersonargote.restaurant.dining_room.dto.PaymentDTO;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {
    public PaymentDTO toDTO(Payment payment) {
        return PaymentDTO.builder()
                .paymentType(payment.paymentType())
                .amount(payment.amount())
                .orderId(payment.order().id())
                .build();
    }

    public Payment toDomain(PaymentDTO paymentDTO) {
        return Payment.builder()
                .paymentType(paymentDTO.paymentType())
                .amount(paymentDTO.amount())
                .order(Order.builder().id(paymentDTO.orderId()).build())
                .build();
    }
}
