package com.metapack.assignments.accumulator.impl;

import com.metapack.assignments.accumulator.api.Accumulator;
import com.metapack.assignments.accumulator.impl.state.IntAccumulatorState;

import java.util.Arrays;
import java.util.Objects;

public final class IntAccumulator implements Accumulator {

    private final IntAccumulatorState state;

    public IntAccumulator(IntAccumulatorState state) {
        this.state = state;
    }

    @Override
    public int accumulate(int... values) {
        if (Objects.isNull(values)) {
            throw new IllegalArgumentException();
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
