package com.yersonargote.restaurant.dining_room.controller;

import com.yersonargote.restaurant.dining_room.domain.Client;
import com.yersonargote.restaurant.dining_room.dto.ClientDTO;
import com.yersonargote.restaurant.dining_room.mapper.ClientMapper;
import com.yersonargote.restaurant.dining_room.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @PostMapping(path = "/client", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UUID> createClient(@RequestBody ClientDTO clientDTO) {
        Client client = clientMapper.toDomain(clientDTO);
        client = clientService.save(client);
        if (client != null) {
            return ResponseEntity.ok(client.id());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
