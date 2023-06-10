package com.metapack.assignments.accumulator.impl;

import com.metapack.assignments.accumulator.api.Accumulator;
import com.metapack.assignments.accumulator.api.AccumulatorState;

import java.util.Arrays;
import java.util.Objects;

public final class IntAccumulator implements Accumulator {

    private final AccumulatorState state;

    public IntAccumulator(AccumulatorState state) {
        this.state = state;
    }

    @Override
    public int accumulate(int... values) {
        if (Objects.isNull(values)) {
            throw new IllegalArgumentException("Required at least one value.");
        }
        final int sum = Arrays.stream(values).sum();
        this.state.update(sum);
        return sum;
    }

    @Override
    public int getTotal() {
        return this.state.get();
    }

    @Override
    public void reset() {
        this.state.reset();
    }

}
