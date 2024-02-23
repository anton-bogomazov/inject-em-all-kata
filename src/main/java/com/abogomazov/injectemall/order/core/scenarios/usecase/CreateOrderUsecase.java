package com.abogomazov.injectemall.order.core.scenarios.usecase;

import java.util.List;

import com.abogomazov.injectemall.buyer.domain.Buyer;
import com.abogomazov.injectemall.common.MessageBus;
import com.abogomazov.injectemall.order.core.access.OrderPersister;
import com.abogomazov.injectemall.order.core.domain.Order;
import com.abogomazov.injectemall.order.core.domain.OrderCreatedEvent;
import com.abogomazov.injectemall.order.core.domain.OrderId;
import com.abogomazov.injectemall.order.core.scenarios.CreateOrder;
import com.abogomazov.injectemall.order.core.scenarios.OrderIdGenerator;
import com.abogomazov.injectemall.order.core.scenarios.errors.ProductNotAvailable;
import com.abogomazov.injectemall.order.core.services.ProductAvailabilityService;
import com.abogomazov.injectemall.product.domain.Product;

public class CreateOrderUsecase implements CreateOrder {

    protected MessageBus bus;
    protected OrderPersister persister;
    protected ProductAvailabilityService productAvailabilityService;

    @Override
    public OrderId execute(
            OrderIdGenerator idGenerator,
            List<Product> products,
            Buyer buyer
    ) {
        var unavailableProducts = products.stream()
                .filter(product -> !productAvailabilityService.isAvailable(product))
                .toList();
        if (!unavailableProducts.isEmpty()) {
            throw new ProductNotAvailable(unavailableProducts);
        }

        Order order = new Order(idGenerator.next(), buyer, products);
        persister.save(order);
        bus.send(new OrderCreatedEvent(order));
        return order.id();
    }

    public static int counter = 0;
    public CreateOrderUsecase(
            MessageBus messageBus,
            OrderPersister orderPersister,
            ProductAvailabilityService productAvailabilityService
    ) {
        this.bus = messageBus;
        this.productAvailabilityService = productAvailabilityService;
        this.persister = orderPersister;
        counter++;
    }
    public static void resetCounter() {
        counter = 0;
    }
}

