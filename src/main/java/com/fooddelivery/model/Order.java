package com.fooddelivery.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "orders")  // This will map the class to the "orders" collection in MongoDB
public class Order {

    @Id
    private String  orderId;  // Unique identifier for each order
    private String restaurantId;  // The ID of the restaurant making the order
    private String menuItemId;  // The ID of the menu item being ordered
    private String orderStatus;  // The current status of the order (ORDER_ACCEPTED, ORDER_REJECTED, etc.)
    private String customerId;  // The ID of the customer who placed the order

    // Constructors, getters, and setters

    public Order() {
    }

    public Order(String orderId, String restaurantId, String menuItemId, String orderStatus, String customerId) {
        this.orderId = orderId;
        this.restaurantId = restaurantId;
        this.menuItemId = menuItemId;
        this.orderStatus = orderStatus;
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(String menuItemId) {
        this.menuItemId = menuItemId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
