package com.yersonargote.restaurant.dining_room.mapper;

import com.yersonargote.restaurant.dining_room.domain.Client;
import com.yersonargote.restaurant.dining_room.dto.ClientDTO;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public ClientDTO toDTO(Client client) {
        return ClientDTO.builder()
                .name(client.name())
                .lastName(client.lastName())
                .phone(client.phone())
                .build();
    }

    public Client toDomain(ClientDTO clientDTO) {
        return Client.builder()
                .name(clientDTO.name())
                .lastName(clientDTO.lastName())
                .phone(clientDTO.phone())
                .build();
    }
}
