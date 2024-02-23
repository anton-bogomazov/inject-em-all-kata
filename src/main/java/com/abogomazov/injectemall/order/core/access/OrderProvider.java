package com.abogomazov.injectemall.order.core.access;

import java.util.List;

import com.abogomazov.injectemall.buyer.domain.BuyerId;
import com.abogomazov.injectemall.order.core.domain.Order;
import com.abogomazov.injectemall.order.core.domain.OrderId;

public interface OrderProvider {
    Order get(OrderId id);
    List<Order> getAll(BuyerId buyerId);
}
