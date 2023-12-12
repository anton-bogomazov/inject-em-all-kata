package com.abogomazov.injectemall.order.core.domain;

import java.util.List;

import com.abogomazov.injectemall.buyer.domain.Buyer;
import com.abogomazov.injectemall.common.DomainEntity;
import com.abogomazov.injectemall.product.domain.Product;

public record Order(OrderId id, Buyer buyer, List<Product> products) implements DomainEntity {
}
