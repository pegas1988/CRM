package com.hillel.crm.config.service.rest;

import com.hillel.crm.config.dto.OrderDto;
import com.hillel.crm.config.entity.Order;

import java.util.List;

public interface OrderServiceRest {
    public Order getById(Long id);

    List<Order> findAll();

    Order create(OrderDto orderDto);

    public void delete(Long id);

    public void update(Long id, OrderDto orderDto);
}
