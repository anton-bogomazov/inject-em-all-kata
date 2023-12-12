package com.abogomazov.injectemall.common;

// Common type for domain events
public interface DomainEvent<T extends DomainEntity> {
    T getData();
}
