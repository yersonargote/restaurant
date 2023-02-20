package com.yersonargote.restaurant.dining_room.controller;

import com.yersonargote.restaurant.dining_room.domain.Ticket;
import com.yersonargote.restaurant.dining_room.dto.TickeDTO;
import com.yersonargote.restaurant.dining_room.mapper.TicketMapper;
import com.yersonargote.restaurant.dining_room.service.TicketService;
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
public class TicketController {
    private final TicketService ticketService;
    private final TicketMapper ticketMapper;

    @GetMapping(path = "/ticket", produces = "application/json")
    public ResponseEntity<Iterable<TickeDTO>> getAllTickets() {
        Iterable<Ticket> tickets = ticketService.findAll();
        List<TickeDTO> ticketDTOS = new ArrayList<>();
        tickets.forEach(ticket -> ticketDTOS.add(ticketMapper.toDTO(ticket)));
        return ResponseEntity.ok(ticketDTOS);
    }

    @GetMapping(path = "/ticket/{id}", produces = "application/json")
    public ResponseEntity<TickeDTO> getTicketById(@PathVariable UUID id) {
        Optional<Ticket> ticket = ticketService.findById(id);
        return ticket
                .map(value -> ResponseEntity.ok(ticketMapper.toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/ticket", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UUID> createTicket(@RequestBody TickeDTO ticketDTO) {
        Ticket ticket = ticketMapper.toDomain(ticketDTO);
        ticket = ticketService.save(ticket);
        if (ticket.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ticket.getId());
    }

    @PutMapping(path = "/ticket/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<TickeDTO> updateTicket(@PathVariable UUID id, @RequestBody TickeDTO ticketDTO) {
        Ticket ticket = ticketMapper.toDomain(ticketDTO);
        ticket.setId(id);
        Optional<Ticket> updated = ticketService.update(id, ticket);
        return updated
                .map(value -> ResponseEntity.ok(ticketMapper.toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/ticket/{id}", produces = "application/json")
    public ResponseEntity<UUID> deleteTicket(@PathVariable UUID id) {
        Optional<Ticket> ticket = ticketService.delete(id);
        return ticket
                .map(value -> ResponseEntity.ok(value.getId()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
