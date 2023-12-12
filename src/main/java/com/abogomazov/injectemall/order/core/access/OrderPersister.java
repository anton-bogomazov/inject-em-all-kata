package com.abogomazov.injectemall.order.core.access;

import com.abogomazov.injectemall.order.core.domain.Order;

public interface OrderPersister {
    void save(Order order);
}
