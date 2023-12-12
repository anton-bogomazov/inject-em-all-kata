package com.abogomazov.injectemall.product;

import java.util.List;
import java.util.UUID;

import com.abogomazov.injectemall.product.domain.Product;
import com.abogomazov.injectemall.product.domain.ProductId;

public class FakeCatalogLoader implements CatalogLoader {
    @Override
    public List<Product> load() {
        return List.of(
                new Product(
                        new ProductId(UUID.fromString("c883a6af-8016-4b46-8ac5-e12e2a9855ef")),
                        "Honey"
                ),
                new Product(
                        new ProductId(UUID.fromString("3b4cd116-a7c4-43e7-a990-cff62ba16161")),
                        "Bicycle"
                )
        );
    }
}
