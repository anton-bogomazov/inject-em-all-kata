package com.abogomazov.injectemall.order.core.scenarios.usecase;

import java.util.List;

import com.abogomazov.injectemall.order.core.access.OrderPersister;
import com.abogomazov.injectemall.order.core.access.OrderProvider;
import com.abogomazov.injectemall.common.MessageBus;
import com.abogomazov.injectemall.order.core.domain.OrderId;
import com.abogomazov.injectemall.order.core.scenarios.OrderIdGenerator;
import com.abogomazov.injectemall.order.core.scenarios.errors.BuyerExceededMaxOrderNumber;
import com.abogomazov.injectemall.order.core.scenarios.errors.BuyerBlackListed;
import com.abogomazov.injectemall.order.core.services.BuyersBlackList;
import com.abogomazov.injectemall.order.core.services.ProductAvailabilityService;
import com.abogomazov.injectemall.product.domain.Product;
import com.abogomazov.injectemall.buyer.domain.Buyer;

public class CreateOrderSuspiciousBuyerUsecase extends CreateOrderUsecase {

    private final OrderProvider provider;
    private final BuyersBlackList blackList;

    @Override
    public OrderId execute(
            OrderIdGenerator idGenerator,
            List<Product> products,
            Buyer buyer
    ) {
        if (blackList.contains(buyer)) {
            throw new BuyerBlackListed();
        }
        if (provider.getAll(buyer.id()).size() > 10) {
            throw new BuyerExceededMaxOrderNumber();
        }

        return super.execute(idGenerator, products, buyer);
    }

    public CreateOrderSuspiciousBuyerUsecase(
            MessageBus messageBus,
            OrderPersister orderPersister,
            OrderProvider orderProvider,
            ProductAvailabilityService productAvailabilityService,
            BuyersBlackList buyersBlackList
    ) {
        super(messageBus, orderPersister, productAvailabilityService);
        this.blackList = buyersBlackList;
        this.provider = orderProvider;
    }
}

