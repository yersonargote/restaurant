package com.yersonargote.restaurant.dining_room.controller;

import com.yersonargote.restaurant.dining_room.domain.Client;
import com.yersonargote.restaurant.dining_room.dto.ClientDTO;
import com.yersonargote.restaurant.dining_room.mapper.ClientMapper;
import com.yersonargote.restaurant.dining_room.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @GetMapping(path = "/client", produces = "application/json")
    public ResponseEntity<Iterable<ClientDTO>> getAllClients(
            @RequestParam(defaultValue = "0", required = false) Integer page,
            @RequestParam(defaultValue = "10", required = false) Integer size,
            @RequestParam(defaultValue = "identification", required = false) String sortBy
    ) {
        Pageable paging = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Client> clients = clientService.findAll(paging);
        List<ClientDTO> clientDTOS = new ArrayList<>();
        clients.forEach(client -> clientDTOS.add(clientMapper.toDTO(client)));
        return ResponseEntity.ok(clientDTOS);
    }

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
        if (client.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(client.getId());
    }

    @PutMapping(path = "/client/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable UUID id, @RequestBody ClientDTO clientDTO) {
        Client client = clientMapper.toDomain(clientDTO);
        client.setId(id);
        Optional<Client> updated = clientService.update(id, client);
        return updated
                .map(value -> ResponseEntity.ok(clientMapper.toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/client/{id}", produces = "application/json")
    public ResponseEntity<UUID> deleteClient(@PathVariable UUID id) {
        Optional<Client> deleted = clientService.delete(id);
        return deleted
                .map(value -> ResponseEntity.ok(value.getId()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
