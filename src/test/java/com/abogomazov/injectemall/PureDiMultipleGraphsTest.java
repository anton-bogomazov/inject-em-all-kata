package com.abogomazov.injectemall;

import static com.abogomazov.injectemall.DiTestUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.abogomazov.DummyApplicationFactory;
import com.abogomazov.injectemall.common.ApplicationFactory;
import com.abogomazov.injectemall.order.ui.cli.OrderCli;
import com.abogomazov.injectemall.order.ui.rest.OrderRest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PureDiMultipleGraphsTest {

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
        var factory = factory();
        var cli = factory.cli();
        var rest1 = factory.rest();
        var rest2 = factory.rest();

        // number of global instances is constant after construction
        checkGlobalInstances();
        assertEquals(1, OrderCli.counter);
        assertEquals(2, OrderRest.counter);
        checkPerGraphSingletons(3);
        // number of transients and per-request instances grow after each request
        checkPerRequestInstances(0);
        checkTransientInstances(0);

        cli.test();

        checkGlobalInstances();
        assertEquals(1, OrderCli.counter);
        assertEquals(2, OrderRest.counter);
        checkPerGraphSingletons(3);
        checkPerRequestInstances(1);
        checkTransientInstances(1);

        cli.test();
        rest1.test();
        rest2.test();

        checkGlobalInstances();
        assertEquals(1, OrderCli.counter);
        assertEquals(2, OrderRest.counter);
        checkPerGraphSingletons(3);
        checkPerRequestInstances(4);
        checkTransientInstances(4);
    }
}
