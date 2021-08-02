package com.hillel.crm.config.controller.rest;

import com.hillel.crm.config.dto.OrderDto;
import com.hillel.crm.config.entity.Order;
import com.hillel.crm.config.service.impl.OrderServiceRestImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/rest/order")
@RequiredArgsConstructor
public class OrderControllerRest {
    private final OrderServiceRestImpl orderServiceRest;

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<OrderDto> findById(@PathVariable Long id) {
        final Order order = orderServiceRest.getById(id);
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(order, orderDto);
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @GetMapping(value = "/find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderDto>> findAll() {
        List<Order> orderList = orderServiceRest.findAll();
        List<OrderDto> clientDtoList = orderList.stream()
                .map(order -> {
                    OrderDto clientDto = new OrderDto();
                    BeanUtils.copyProperties(order, clientDto);
                    return clientDto;
                }).collect(Collectors.toList());
        return new ResponseEntity<>(clientDtoList, HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> create(@RequestBody OrderDto orderDto) {
        final Order order = orderServiceRest.create(orderDto);
        orderDto.setOrderID(order.getOrderID());
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        orderServiceRest.delete(id);
    }

    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody OrderDto orderDto) {
        orderServiceRest.update(id, orderDto);
    }
}
