package com.abogomazov;

import com.abogomazov.injectemall.common.Application;
import com.abogomazov.injectemall.common.ApplicationFactory;

public class DummyApplicationFactory implements ApplicationFactory {

    @Override
    public Application rest() {
        throw new RuntimeException("NotImplemented");
    }

    @Override
    public Application cli() {
        throw new RuntimeException("NotImplemented");
    }
}
