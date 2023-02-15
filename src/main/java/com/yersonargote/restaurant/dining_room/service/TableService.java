package com.yersonargote.restaurant.dining_room.service;

import com.yersonargote.restaurant.dining_room.domain.Table;
import com.yersonargote.restaurant.dining_room.repository.IGenericRepository;
import com.yersonargote.restaurant.dining_room.repository.TableRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class TableService extends CrudGenericService<Table, UUID> {
    private final TableRepo tableRepository;

    @Override
    protected IGenericRepository<Table, UUID> getRepository() {
        return tableRepository;
    }
}
