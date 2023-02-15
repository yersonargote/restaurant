package com.yersonargote.restaurant.dining_room.service;

import com.yersonargote.restaurant.dining_room.domain.Order;
import com.yersonargote.restaurant.dining_room.repository.OrderRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService extends CrudGenericService<Order, UUID>{
    private final OrderRepo orderRepository;

    @Override
    protected JpaRepository<Order, UUID> getRepository() {
        return orderRepository;
    }

}
