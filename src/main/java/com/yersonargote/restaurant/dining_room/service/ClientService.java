package com.yersonargote.restaurant.dining_room.service;

import com.yersonargote.restaurant.dining_room.domain.Client;
import com.yersonargote.restaurant.dining_room.repository.ClientRepo;
import com.yersonargote.restaurant.dining_room.repository.IGenericRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientService extends CrudGenericService<Client, UUID> {
    private final ClientRepo clientRepository;

    @Override
    protected IGenericRepository<Client, UUID> getRepository() {
        return clientRepository;
    }
}
