package com.abogomazov.injectemall.order.ui.rest;

import java.util.List;
import java.util.UUID;

import com.abogomazov.injectemall.buyer.domain.Buyer;
import com.abogomazov.injectemall.buyer.domain.BuyerId;
import com.abogomazov.injectemall.common.Application;
import com.abogomazov.injectemall.order.core.scenarios.CreateOrder;
import com.abogomazov.injectemall.order.ui.CreateOrderCommand;
import com.abogomazov.injectemall.product.domain.Product;
import com.abogomazov.injectemall.product.domain.ProductId;
import io.javalin.Javalin;

public class OrderRest implements Application {

    private static final String API_PATH = "/api/v1";
    private static final String ORDER_PATH = "/orders";

    @Override
    public void start() {
        Javalin.create()
                .post(
                        API_PATH + ORDER_PATH + "/trusted",
                        ctx -> {}
//                                endpoint(/* CreateOrderUsecase */).handle(ctx.bodyAsClass(CreateOrderCommand.class))
                ).post(
                        API_PATH + ORDER_PATH + "/suspicious",
                        ctx -> {}
//                                endpoint(/* CreateOrderSuspiciousBuyerUsecase */).handle(ctx.bodyAsClass(CreateOrderCommand.class))
                ).start();
    }

    private CreateOrderEndpoint endpoint(CreateOrder usecase) {
        return new CreateOrderEndpoint(usecase);
    }

    @Override
    public void test() {
        var command = new CreateOrderCommand(
                new Buyer(new BuyerId(UUID.fromString("c6687d3a-158e-449f-a1f5-d70a0d91a9a1")), "John Doe"),
                List.of(
                        new Product(new ProductId(UUID.fromString("c883a6af-8016-4b46-8ac5-e12e2a9855ef")), "Honey")
                )
        );
//        endpoint(
//                /* CreateOrderSuspiciousBuyerUsecase */
//        ).handle(command);
    }

    public static int counter = 0;
    public OrderRest(
            /* dependencies */
    ) {
        counter++;
    }
    public static void resetCounter() {
        counter = 0;
    }
}
