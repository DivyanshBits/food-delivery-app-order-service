package com.fooddelivery.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Customer ID is required")
    private Long customerId;

    @NotNull(message = "Restaurant ID is required")
    private Long restaurantId;

    @DecimalMin(value = "0.0", inclusive = false, message = "Total amount must be greater than 0")
    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Order status is required")
    private OrderStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
