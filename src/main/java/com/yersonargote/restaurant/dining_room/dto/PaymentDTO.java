package com.yersonargote.restaurant.dining_room.dto;

import com.yersonargote.restaurant.dining_room.domain.PaymentType;
import lombok.Builder;

import java.util.UUID;

@Builder
public record PaymentDTO(
        PaymentType paymentType,
        Double amount,
        UUID orderId
) {
}
