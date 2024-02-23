package com.abogomazov.injectemall.buyer.domain;

import com.abogomazov.injectemall.common.DomainEntity;

public record Buyer(BuyerId id, String name) implements DomainEntity {}
