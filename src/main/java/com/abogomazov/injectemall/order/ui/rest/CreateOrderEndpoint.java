package com.abogomazov.injectemall.order.ui.rest;

import com.abogomazov.injectemall.order.core.scenarios.CreateOrder;
import com.abogomazov.injectemall.order.ui.CreateOrderCommand;
import com.abogomazov.injectemall.order.ui.RandomOrderIdGenerator;

public class CreateOrderEndpoint{

    private CreateOrder usecase;

    public void handle(
            CreateOrderCommand dto
    ) {
        usecase.execute(
                new RandomOrderIdGenerator(),
                dto.products(),
                dto.buyer()
        );
    }

    public static int counter = 0;
    public CreateOrderEndpoint(
            CreateOrder usecase
    ) {
        this.usecase = usecase;
        counter++;
    }
    public static void resetCounter() {
        counter = 0;
    }
}
