package com.yersonargote.restaurant.dining_room.service;

import com.yersonargote.restaurant.dining_room.domain.Table;
import com.yersonargote.restaurant.dining_room.repository.TableRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class TableService extends CrudGenericService<Table, UUID> {
    private final TableRepo tableRepository;

    @Override
    protected JpaRepository<Table, UUID> getRepository() {
        return tableRepository;
    }
}
