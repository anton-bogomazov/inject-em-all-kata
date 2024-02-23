package com.abogomazov.injectemall.order.core.scenarios.errors;

public class BuyerBlackListed extends RuntimeException {
    public BuyerBlackListed() {
        super("Buyer is blacklisted");
    }
}
