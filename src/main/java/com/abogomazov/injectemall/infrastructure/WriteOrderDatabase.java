package com.abogomazov.injectemall.infrastructure;

import java.util.ArrayList;
import java.util.List;

import com.abogomazov.injectemall.order.core.domain.Order;

// Implementation of non-concurrent in-memory database
public class WriteOrderDatabase {
    private final List<Order> orders = new ArrayList<>();

    public void save(Order order) {
        orders.add(order);
    }

    public static int counter = 0;
    public WriteOrderDatabase() {
        counter++;
    }
    public static void resetCounter() {
        counter = 0;
    }
}
