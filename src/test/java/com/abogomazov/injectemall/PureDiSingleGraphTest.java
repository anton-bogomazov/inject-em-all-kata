package com.abogomazov.injectemall;

import static com.abogomazov.injectemall.DiTestUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.abogomazov.DummyApplicationFactory;
import com.abogomazov.injectemall.common.ApplicationFactory;
import com.abogomazov.injectemall.order.ui.cli.OrderCli;
import com.abogomazov.injectemall.order.ui.rest.CreateOrderEndpoint;
import com.abogomazov.injectemall.order.ui.rest.OrderRest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PureDiSingleGraphTest {

    private ApplicationFactory factory() {
        // TODO Put your ApplicationFactory implementation here
        return new DummyApplicationFactory();
    }

    @BeforeEach
    void cleanup() {
        resetInstanceCounters();
    }

    @Test
    void cli_countInstances() {
        var app = factory().cli();

        // number of global instances is constant after construction
        checkGlobalInstances();
        assertEquals(1, OrderCli.counter);
        checkPerGraphSingletons(1);
        // number of transients and per-request instances grow after each request
        checkPerRequestInstances(0);
        checkTransientInstances(0);

        app.test();

        checkGlobalInstances();
        assertEquals(1, OrderCli.counter);
        checkPerGraphSingletons(1);
        checkPerRequestInstances(1);
        checkTransientInstances(1);

        app.test();

        checkGlobalInstances();
        assertEquals(1, OrderCli.counter);
        checkPerGraphSingletons(1);
        checkPerRequestInstances(2);
        checkTransientInstances(2);
    }

    @Test
    void rest_countInstances() {
        var app = factory().rest();

        // number of global instances is constant after construction
        checkGlobalInstances();
        assertEquals(1, OrderRest.counter);
        checkPerGraphSingletons(1);
        // number of transients and per-request instances grow after each request
        checkPerRequestInstances(0);
        checkTransientInstances(0);
        assertEquals(0, CreateOrderEndpoint.counter);

        app.test();

        checkGlobalInstances();
        assertEquals(1, OrderRest.counter);
        checkPerGraphSingletons(1);
        checkPerRequestInstances(1);
        checkTransientInstances(1);
        assertEquals(1, CreateOrderEndpoint.counter);

        app.test();

        checkGlobalInstances();
        assertEquals(1, OrderRest.counter);
        checkPerGraphSingletons(1);
        checkPerRequestInstances(2);
        checkTransientInstances(2);
        assertEquals(2, CreateOrderEndpoint.counter);

    }
}
