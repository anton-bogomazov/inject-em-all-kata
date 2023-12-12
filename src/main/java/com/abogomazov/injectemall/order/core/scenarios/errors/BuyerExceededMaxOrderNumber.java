package com.abogomazov.injectemall.order.core.scenarios.errors;

public class BuyerExceededMaxOrderNumber extends RuntimeException {
    public BuyerExceededMaxOrderNumber() {
        super("Buyer has exceeded the maximum number of orders");
    }
}
