package com.yersonargote.restaurant.dining_room.mapper;

import com.yersonargote.restaurant.dining_room.domain.Table;
import com.yersonargote.restaurant.dining_room.dto.TableDTO;
import org.springframework.stereotype.Component;

@Component
public class TableMapper {
    public TableDTO toDTO(Table table) {
        return TableDTO.builder()
                .number(table.getNumber())
                .capacity(table.getCapacity())
                .available(table.getAvailable())
                .build();
    }

    public Table toDomain(TableDTO tableDTO) {
        return Table.builder()
                .number(tableDTO.number())
                .capacity(tableDTO.capacity())
                .available(tableDTO.available())
                .build();
    }
}
