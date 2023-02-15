package com.yersonargote.restaurant.dining_room.service;

import java.util.Optional;

public interface IGenericService<T, ID> {
    <S extends T>S save(S entity);

    Optional<T> update(ID id, T entity);

    Optional<T> findById(ID id);

    Optional<T> delete(ID id);

    Iterable<T> findAll();
}
