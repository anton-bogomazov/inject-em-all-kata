package com.abogomazov.injectemall.common;

// Domain event handler
public interface MessageBus {
    <T extends DomainEntity> void send(DomainEvent<T> event);
}
