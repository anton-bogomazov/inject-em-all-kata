package com.abogomazov.injectemall.product;

import java.util.List;

import com.abogomazov.injectemall.order.core.services.ProductAvailabilityService;
import com.abogomazov.injectemall.product.domain.Product;

public class ProductCatalog implements ProductAvailabilityService {

    private final List<Product> products;

    @Override
    public boolean isAvailable(Product product) {
        return products.contains(product);
    }

    public static int counter = 0;
    public ProductCatalog(CatalogLoader loader) {
        this.products = loader.load();
        counter++;
    }
    public static void resetCounter() {
        counter = 0;
    }
}
