package com.hillel.crm.config.service.impl;

import com.hillel.crm.config.dao.OrderDao;
import com.hillel.crm.config.dto.OrderDto;
import com.hillel.crm.config.entity.Order;
import com.hillel.crm.config.service.rest.OrderServiceRest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrderServiceRestImpl implements OrderServiceRest {

    private final OrderDao orderDao;

    @Override
    public Order getById(Long id) {
        Order order = orderDao.findById(id)
                .orElseThrow(() -> new RuntimeException("не удалось найти Order с id " + id));
        return order;
    }

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    @Transactional
    public Order create(OrderDto orderDto) {
        if (!Objects.isNull(orderDto.getOrderID())) {
            throw new IllegalArgumentException("Failed to create Order. Order with such ID already exist.");
        }
        Order order = new Order();
        BeanUtils.copyProperties(orderDto, order);
        return orderDao.save(order);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!orderDao.existsById(id)) {
            throw new IllegalArgumentException("Failed to create Order. Order with such ID already exist.");
        }
        orderDao.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Long id, OrderDto orderDto) {
        if (!Objects.isNull(orderDto.getOrderID())) {
            throw new IllegalArgumentException("Failed to create Order. Order with such ID already exist.");
        }
        Order order = new Order();
        BeanUtils.copyProperties(orderDto, order);
        order.setOrderID(id);
        orderDao.save(order);
    }
}
