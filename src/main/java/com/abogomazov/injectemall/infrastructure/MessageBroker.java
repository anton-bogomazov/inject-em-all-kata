package com.abogomazov.injectemall.infrastructure;

import java.util.ArrayList;
import java.util.List;

import com.abogomazov.injectemall.common.DomainEntity;
import com.abogomazov.injectemall.common.DomainEvent;
import com.abogomazov.injectemall.common.MessageBus;

public class MessageBroker implements MessageBus {
    private final List<Subscriber<DomainEntity>> subscribers = new ArrayList<>();

    // The only subscriber is ReadOrderDatabase
    void register(Subscriber<DomainEntity> subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public <T extends DomainEntity> void send(DomainEvent<T> event) {
        for (Subscriber<DomainEntity> subscriber : subscribers) {
            subscriber.handle(event.getData());
        }
    }

    public static int counter = 0;
    public MessageBroker() { counter++; }
    public static void resetCounter() {
        counter = 0;
    }
}
