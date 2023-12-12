package com.abogomazov.injectemall.common;

public interface ApplicationFactory {
    Application rest();
    Application cli();
}
