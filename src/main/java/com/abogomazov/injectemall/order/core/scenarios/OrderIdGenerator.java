package com.abogomazov.injectemall.order.core.scenarios;

import com.abogomazov.injectemall.order.core.domain.OrderId;

public interface OrderIdGenerator {
    OrderId next();
}
