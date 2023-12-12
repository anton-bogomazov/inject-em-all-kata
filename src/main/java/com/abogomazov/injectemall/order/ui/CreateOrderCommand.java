package com.abogomazov.injectemall.order.ui;

import java.util.List;

import com.abogomazov.injectemall.buyer.domain.Buyer;
import com.abogomazov.injectemall.product.domain.Product;

public record CreateOrderCommand(
    Buyer buyer,
    List<Product> products
) {}
