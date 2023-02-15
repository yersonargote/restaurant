package com.yersonargote.restaurant.dining_room.controller;

import com.yersonargote.restaurant.dining_room.domain.Client;
import com.yersonargote.restaurant.dining_room.dto.ClientDTO;
import com.yersonargote.restaurant.dining_room.mapper.ClientMapper;
import com.yersonargote.restaurant.dining_room.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @GetMapping(path = "/client/{id}", produces = "application/json")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable UUID id) {
        Optional<Client> client = clientService.findById(id);
        return client
                .map(value -> ResponseEntity.ok(clientMapper.toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/client", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UUID> createClient(@RequestBody ClientDTO clientDTO) {
        Client client = clientMapper.toDomain(clientDTO);
        client = clientService.save(client);
        if (client.id() != null) {
            return ResponseEntity.ok(client.id());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
