package com.abogomazov.injectemall.order.core.scenarios.errors;

import java.util.List;

import com.abogomazov.injectemall.product.domain.Product;

public class ProductNotAvailable extends RuntimeException {
    public ProductNotAvailable(List<Product> unavailableProducts) {
        super("Product is not available: " + unavailableProducts.toString());
    }
}
