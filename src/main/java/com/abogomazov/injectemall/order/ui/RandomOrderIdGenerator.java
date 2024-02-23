package com.abogomazov.injectemall.order.ui;

import java.util.UUID;

import com.abogomazov.injectemall.order.core.domain.OrderId;
import com.abogomazov.injectemall.order.core.scenarios.OrderIdGenerator;

public class RandomOrderIdGenerator implements OrderIdGenerator {
    @Override
    public OrderId next() {
        return new OrderId(UUID.randomUUID());
    }

    public static int counter = 0;
    public RandomOrderIdGenerator() {
        counter++;
    }
    public static void resetCounter() {
        counter = 0;
    }
}
