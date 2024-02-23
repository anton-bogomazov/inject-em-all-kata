package com.abogomazov.injectemall.order.persistence;

import java.util.List;

import com.abogomazov.injectemall.buyer.domain.BuyerId;
import com.abogomazov.injectemall.infrastructure.ReadOrderDatabase;
import com.abogomazov.injectemall.infrastructure.WriteOrderDatabase;
import com.abogomazov.injectemall.order.core.access.OrderPersister;
import com.abogomazov.injectemall.order.core.access.OrderProvider;
import com.abogomazov.injectemall.order.core.domain.Order;
import com.abogomazov.injectemall.order.core.domain.OrderId;

public class OrderRepository implements OrderPersister, OrderProvider {
    private ReadOrderDatabase provider;
    private WriteOrderDatabase persister;

    @Override
    public void save(Order order) {
        persister.save(order);
    }

    @Override
    public Order get(OrderId id) {
        return provider.getOrder(id.value().toString());
    }

    @Override
    public List<Order> getAll(BuyerId buyerId) {
        return provider.getAll().stream()
                .filter(order -> order.buyer().id().equals(buyerId)).toList();
    }

    public static int counter = 0;
    public OrderRepository(ReadOrderDatabase readDb, WriteOrderDatabase writeDb) {
        this.provider = readDb;
        this.persister = writeDb;
        counter++;
    }
    public static void resetCounter() {
        counter = 0;
    }
}
