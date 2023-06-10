package com.metapack.assignments.accumulator.impl.state;

import com.metapack.assignments.accumulator.api.AccumulatorState;

import java.util.concurrent.atomic.AtomicInteger;

public class IntAccumulatorState implements AccumulatorState {

    private final AtomicInteger total;

    public IntAccumulatorState(int initialValue) {
        this.total = new AtomicInteger(initialValue);
    }

    @Override
    public int get() {
        return this.total.get();
    }

    @Override
    public void update(int value) {
        this.total.addAndGet(value);
    }

    @Override
    public void reset() {
        this.total.set(0);
    }
}
