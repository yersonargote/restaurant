package com.yersonargote.restaurant.dining_room.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public abstract class CrudGenericService<T, ID> implements ICrudGenericService<T, ID> {
    protected abstract JpaRepository<T, ID> getRepository();
    @Override
    public <S extends T> S save(S entity) {
        return getRepository().save(entity);
    }

    @Override
    public Optional<T> update(ID id, T entity) {
        Optional<T> t = getRepository().findById(id);
        if (t.isPresent()) {
            return Optional.of(getRepository().save(entity));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    @Override
    public Optional<T> delete(ID id) {
        Optional<T> t = getRepository().findById(id);
        if (t.isPresent()) {
            getRepository().deleteById(id);
            return t;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Iterable<T> findAll() {
        return getRepository().findAll();
    }
}
