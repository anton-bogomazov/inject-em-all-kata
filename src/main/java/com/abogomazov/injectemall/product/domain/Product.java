package com.abogomazov.injectemall.product.domain;

import com.abogomazov.injectemall.common.DomainEntity;

public record Product(ProductId id, String name) implements DomainEntity {}
