package com.yersonargote.restaurant.dining_room.controller;

import com.yersonargote.restaurant.dining_room.domain.Table;
import com.yersonargote.restaurant.dining_room.dto.TableDTO;
import com.yersonargote.restaurant.dining_room.mapper.TableMapper;
import com.yersonargote.restaurant.dining_room.service.TableService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TableController {
    private final TableService tableService;
    private final TableMapper tableMapper;

    @GetMapping(path = "/table", produces = "application/json")
    public ResponseEntity<Iterable<TableDTO>> getAllTables(
            @RequestParam(defaultValue = "0", required = false) Integer page,
            @RequestParam(defaultValue = "10", required = false) Integer size,
            @RequestParam(defaultValue = "name", required = false) String sortBy
    ) {
        Pageable paging = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Table> tables = tableService.findAll(paging);
        List<TableDTO> tablesDTO = tables.map(tableMapper::toDTO).getContent();
        return ResponseEntity.ok(tablesDTO);
    }

    @GetMapping(path = "/table/{id}", produces = "application/json")
    public ResponseEntity<TableDTO> getTableById(@PathVariable UUID id) {
        Optional<Table> table = tableService.findById(id);
        return table
                .map(value -> ResponseEntity.ok(tableMapper.toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/table", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UUID> createTable(@RequestBody TableDTO tableDTO) {
        Table table = tableMapper.toDomain(tableDTO);
        table = tableService.save(table);
        if (table.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(table.getId());
    }

    @PutMapping(path = "/table/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<TableDTO> updateTable(@PathVariable UUID id, @RequestBody TableDTO tableDTO) {
        Table table = tableMapper.toDomain(tableDTO);
        table.setId(id);
        Optional<Table> updated = tableService.update(id, table);
        return updated
                .map(value -> ResponseEntity.ok(tableMapper.toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/table/{id}", produces = "application/json")
    public ResponseEntity<UUID> deleteTable(@PathVariable UUID id) {
        Optional<Table> table = tableService.delete(id);
        return table
                .map(value -> ResponseEntity.ok(value.getId()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
