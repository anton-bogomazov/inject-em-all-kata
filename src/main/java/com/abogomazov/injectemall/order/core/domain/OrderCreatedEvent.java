package com.abogomazov.injectemall.order.core.domain;

import com.abogomazov.injectemall.common.DomainEvent;

public class OrderCreatedEvent implements DomainEvent<Order> {

    private final Order order;

    public OrderCreatedEvent(Order order) {
        this.order = order;
    }

    @Override
    public Order getData() {
        return order;
    }
}
