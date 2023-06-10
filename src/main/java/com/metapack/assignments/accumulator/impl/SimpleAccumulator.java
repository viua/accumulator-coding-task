package com.metapack.assignments.accumulator.impl;

import com.metapack.assignments.accumulator.api.Accumulator;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

public class SimpleAccumulator implements Accumulator {

    private int total;

    @Override
    public int accumulate(int... values) {
        return Optional.ofNullable(values)
                .map(Arrays::stream)
                .map(IntStream::sum)
                .map(this::accumulateTotal)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public int getTotal() {
        return this.total;
    }

    @Override
    public void reset() {
        this.total = 0;
    }

    private int accumulateTotal(int value) {
        this.total = Math.addExact(this.total, value);
        return value;
    }

}
