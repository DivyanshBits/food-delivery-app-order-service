package com.fooddelivery.service;

import com.fooddelivery.exception.OrderNotFoundException;
import com.fooddelivery.model.Order;
import com.fooddelivery.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        log.info("Saving order: {}", order);
        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        log.info("Fetching order by ID: {}", id);
        return orderRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Order not found with ID: {}", id);
                    return new OrderNotFoundException("Order not found with ID: " + id);
                });
    }

    public List<Order> getAllOrders() {
        log.info("Fetching all orders");
        return orderRepository.findAll();
    }

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            log.error("Order not found with ID: {}", id);
            throw new OrderNotFoundException("Order not found with ID: " + id);
        }
        log.info("Deleting order with ID: {}", id);
        orderRepository.deleteById(id);
    }

    public Page<Order> getAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }
}