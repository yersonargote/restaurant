package com.yersonargote.restaurant.dining_room.repository;

import com.yersonargote.restaurant.dining_room.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, UUID> {
}
