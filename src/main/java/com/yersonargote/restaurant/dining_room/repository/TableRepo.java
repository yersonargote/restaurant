package com.yersonargote.restaurant.dining_room.repository;

import com.yersonargote.restaurant.dining_room.domain.Table;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TableRepo extends IGenericRepository<Table, UUID> {
}
