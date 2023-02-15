package com.yersonargote.restaurant.dining_room.mapper;

import com.yersonargote.restaurant.dining_room.domain.Client;
import com.yersonargote.restaurant.dining_room.dto.ClientDTO;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public ClientDTO toDTO(Client client) {
        return ClientDTO.builder()
                .name(client.getName())
                .lastName(client.getLastName())
                .phone(client.getPhone())
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
