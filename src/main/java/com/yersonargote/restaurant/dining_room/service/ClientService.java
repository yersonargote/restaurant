package com.yersonargote.restaurant.dining_room.service;

import com.yersonargote.restaurant.dining_room.domain.Client;
import com.yersonargote.restaurant.dining_room.repository.ClientRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientService extends CrudGenericService<Client, UUID> {
    private final ClientRepo clientRepository;

    @Override
    protected JpaRepository<Client, UUID> getRepository() {
        return clientRepository;
    }
}
