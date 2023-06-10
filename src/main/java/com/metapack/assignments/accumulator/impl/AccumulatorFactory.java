package com.metapack.assignments.accumulator.impl;

import com.metapack.assignments.accumulator.api.Accumulator;
import com.metapack.assignments.accumulator.impl.state.IntAccumulatorState;

public class AccumulatorFactory {

    public static Accumulator newSimpleAccumulator() {
        return new SimpleAccumulator();
    }

    public static Accumulator newIntAccumulator() {
        return new IntAccumulator(new IntAccumulatorState(0));
    }

}
