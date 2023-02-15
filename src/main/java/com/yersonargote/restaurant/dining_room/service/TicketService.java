package com.yersonargote.restaurant.dining_room.service;

import com.yersonargote.restaurant.dining_room.domain.Ticket;
import com.yersonargote.restaurant.dining_room.repository.IGenericRepository;
import com.yersonargote.restaurant.dining_room.repository.TicketRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class TicketService extends CrudGenericService<Ticket, UUID>{
    private final TicketRepo ticketRepository;

    @Override
    protected IGenericRepository<Ticket, UUID> getRepository() {
        return ticketRepository;
    }
}
