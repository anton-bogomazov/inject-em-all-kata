package com.abogomazov.injectemall.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.abogomazov.injectemall.order.core.domain.Order;
import com.abogomazov.injectemall.order.core.domain.OrderId;

// Eventually consistent read-only database
public class ReadOrderDatabase implements Subscriber<Order> {
    private final List<Order> orders = new ArrayList<>();

    public Order getOrder(String orderId) {
        return orders.stream()
                .filter(order -> order.id().equals(new OrderId(UUID.fromString(orderId))))
                .findFirst()
                .orElse(null);
    }

    public List<Order> getAll() {
        return orders;
    }

    @Override
    public void handle(Order data) {
        orders.add(data);
    }

    public static int counter = 0;
    public ReadOrderDatabase() { counter++; }
    public static void resetCounter() {
        counter = 0;
    }
}
