package com.abogomazov.injectemall.order.core.services;

import com.abogomazov.injectemall.buyer.domain.Buyer;

public interface BuyersBlackList {
    boolean contains(Buyer buyer);
}
