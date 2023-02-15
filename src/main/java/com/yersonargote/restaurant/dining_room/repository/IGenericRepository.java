package com.yersonargote.restaurant.dining_room.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IGenericRepository<T, ID> extends PagingAndSortingRepository<T, ID>, CrudRepository<T, ID> {
}
