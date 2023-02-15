package com.yersonargote.restaurant.dining_room.mapper;

import com.yersonargote.restaurant.dining_room.domain.Order;
import com.yersonargote.restaurant.dining_room.domain.Ticket;
import com.yersonargote.restaurant.dining_room.dto.TickeDTO;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {
    public TickeDTO toDTO(Ticket ticket) {
        return TickeDTO.builder()
                .paidDays(ticket.getPaidDays())
                .consumedDays(ticket.getConsumedDays())
                .active(ticket.getActive())
                .orderId(ticket.getOrder().getId())
                .build();
    }

    public Ticket toDomain(TickeDTO tickeDTO) {
        return Ticket.builder()
                .paidDays(tickeDTO.paidDays())
                .consumedDays(tickeDTO.consumedDays())
                .active(tickeDTO.active())
                .order(Order.builder().id(tickeDTO.orderId()).build())
                .build();
    }
}
