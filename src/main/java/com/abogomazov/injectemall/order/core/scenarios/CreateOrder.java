package com.abogomazov.injectemall.order.core.scenarios;

import java.util.List;

import com.abogomazov.injectemall.buyer.domain.Buyer;
import com.abogomazov.injectemall.order.core.domain.OrderId;
import com.abogomazov.injectemall.product.domain.Product;

public interface CreateOrder {
    OrderId execute(
            OrderIdGenerator idGenerator,
            List<Product> products,
            Buyer buyer
    );
}
