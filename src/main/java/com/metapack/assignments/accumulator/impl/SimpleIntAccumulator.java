package com.metapack.assignments.accumulator.impl;

import com.metapack.assignments.accumulator.api.Accumulator;
import net.jcip.annotations.NotThreadSafe;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

@NotThreadSafe
public class SimpleIntAccumulator implements Accumulator {

    private int total;

    @Override
    public int accumulate(int... values) {
        // There is no 'int' overflow check while it sums up and accumulates values,
        // the 'Math.addExact' could possibly be used to take it into account
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
        this.total = this.total + value;
        return value;
    }

}
