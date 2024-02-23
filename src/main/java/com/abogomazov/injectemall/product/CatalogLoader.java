package com.abogomazov.injectemall.product;

import java.util.List;

import com.abogomazov.injectemall.product.domain.Product;

public interface CatalogLoader {
    List<Product> load();
}
