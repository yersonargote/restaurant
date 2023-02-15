package com.yersonargote.restaurant.dining_room.service;

import com.yersonargote.restaurant.dining_room.domain.OrderDetail;
import com.yersonargote.restaurant.dining_room.repository.OrderDetailRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderDetailService extends CrudGenericService<OrderDetail, UUID> {
    private final OrderDetailRepo orderDetailRepository;

    @Override
    protected JpaRepository<OrderDetail, UUID> getRepository() {
        return orderDetailRepository;
    }
}
