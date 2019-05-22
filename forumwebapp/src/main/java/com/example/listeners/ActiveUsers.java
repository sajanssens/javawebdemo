package com.example.listeners;

import java.util.concurrent.atomic.AtomicLong;

public enum ActiveUsers {
    INSTANCE;

    private AtomicLong activeUsers = new AtomicLong();

    public long count() { return activeUsers.get(); }

    public void increment() { activeUsers.incrementAndGet(); }

    public void decrement() {activeUsers.decrementAndGet(); }
}
