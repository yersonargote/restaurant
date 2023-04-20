package com.yersonargote.restaurant.dining_room.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICrudGenericService<T, ID> {
    <S extends T>S save(S entity);

    Optional<T> update(ID id, T entity);

    Optional<T> findById(ID id);

    Optional<T> delete(ID id);

    Page<T> findAll(Pageable pageable);
}
