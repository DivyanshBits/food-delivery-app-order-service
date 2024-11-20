package com.fooddelivery.repository;

import com.fooddelivery.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    // Find orders by customer ID
    List<Order> findByCustomerId(String customerId);

    // Find orders by restaurant ID
    List<Order> findByRestaurantId(String restaurantId);
}
