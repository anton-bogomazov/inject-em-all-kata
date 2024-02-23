package com.abogomazov.injectemall.order.ui.cli;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.abogomazov.injectemall.buyer.domain.Buyer;
import com.abogomazov.injectemall.buyer.domain.BuyerId;
import com.abogomazov.injectemall.common.Application;
import com.abogomazov.injectemall.order.core.scenarios.CreateOrder;
import com.abogomazov.injectemall.order.ui.CreateOrderCommand;
import com.abogomazov.injectemall.order.ui.RandomOrderIdGenerator;
import com.abogomazov.injectemall.product.domain.Product;
import com.abogomazov.injectemall.product.domain.ProductId;
import io.javalin.json.JavalinJackson;
import io.javalin.util.FileUtil;

public class OrderCli implements Application {

    public void start() {
        var scanner = new Scanner(System.in);
        do {
            var type = scanner.next();
            var content = FileUtil.readFile(scanner.next());
            var command = (CreateOrderCommand) new JavalinJackson()
                    .fromJsonString(content, CreateOrderCommand.class);
            CreateOrder usecase;
            if (type.equals("trusted")) {
                usecase = null; /* Use Case here */
            } else {
                usecase = null; /* Use Case here */
            }
            usecase.execute(new RandomOrderIdGenerator(), command.products(), command.buyer());
        } while (true);
    }

    @Override
    public void test() {
        var command = new CreateOrderCommand(
                new Buyer(new BuyerId(UUID.fromString("c6687d3a-158e-449f-a1f5-d70a0d91a9a1")), "John Doe"),
                List.of(
                        new Product(new ProductId(UUID.fromString("c883a6af-8016-4b46-8ac5-e12e2a9855ef")), "Honey")
                )
        );
//        /* Use Case here */.execute(new RandomOrderIdGenerator(), command.products(), command.buyer());
    }

    public static int counter = 0;
    public OrderCli(
            /* dependencies */
    ) {
        counter++;
    }
    public static void resetCounter() {
        counter = 0;
    }
}
