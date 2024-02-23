package com.abogomazov.injectemall.order.core.services;

import com.abogomazov.injectemall.product.domain.Product;

public interface ProductAvailabilityService {
    boolean isAvailable(Product product);
}
