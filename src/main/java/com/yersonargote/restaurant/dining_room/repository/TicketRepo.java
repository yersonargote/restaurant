package com.yersonargote.restaurant.dining_room.repository;

import com.yersonargote.restaurant.dining_room.domain.Ticket;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TicketRepo extends IGenericRepository<Ticket, UUID> {
}
