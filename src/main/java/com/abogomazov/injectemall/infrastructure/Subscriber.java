package com.abogomazov.injectemall.infrastructure;

import com.abogomazov.injectemall.common.DomainEntity;

interface Subscriber<T extends DomainEntity> {
    void handle(T data);
}
