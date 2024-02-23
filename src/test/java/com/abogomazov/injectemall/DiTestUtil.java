package com.abogomazov.injectemall;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.abogomazov.injectemall.blacklist.PretentiousFilmmakersList;
import com.abogomazov.injectemall.infrastructure.MessageBroker;
import com.abogomazov.injectemall.infrastructure.ReadOrderDatabase;
import com.abogomazov.injectemall.infrastructure.WriteOrderDatabase;
import com.abogomazov.injectemall.order.ui.cli.OrderCli;
import com.abogomazov.injectemall.order.core.scenarios.usecase.CreateOrderUsecase;
import com.abogomazov.injectemall.order.persistence.OrderRepository;
import com.abogomazov.injectemall.order.ui.rest.CreateOrderEndpoint;
import com.abogomazov.injectemall.order.ui.rest.OrderRest;
import com.abogomazov.injectemall.order.ui.RandomOrderIdGenerator;
import com.abogomazov.injectemall.product.ProductCatalog;

public class DiTestUtil {
    static void checkGlobalInstances() {
        assertEquals(1, WriteOrderDatabase.counter);
        assertEquals(5, ReadOrderDatabase.counter);
    }

    static void checkPerGraphSingletons(int nGraphs) {
        assertEquals(nGraphs, MessageBroker.counter);
        assertEquals(nGraphs, ProductCatalog.counter);
        assertEquals(nGraphs, PretentiousFilmmakersList.counter);
    }

    static void checkPerRequestInstances(int requestNumber) {
        assertEquals(requestNumber, OrderRepository.counter);
        assertEquals(requestNumber, CreateOrderUsecase.counter);
    }

    static void checkTransientInstances(int requestNumber) {
        assertTrue(RandomOrderIdGenerator.counter >= requestNumber);
    }

    static void resetInstanceCounters() {
        OrderCli.resetCounter();
        OrderRest.resetCounter();
        OrderRepository.resetCounter();
        WriteOrderDatabase.resetCounter();
        ReadOrderDatabase.resetCounter();
        MessageBroker.resetCounter();
        ProductCatalog.resetCounter();
        PretentiousFilmmakersList.resetCounter();
        CreateOrderUsecase.resetCounter();
        RandomOrderIdGenerator.resetCounter();
        CreateOrderEndpoint.resetCounter();
    }
}
