package com.metapack.assignments.accumulator.api;

import com.metapack.assignments.accumulator.impl.ConcurrentIntAccumulator;
import com.metapack.assignments.accumulator.impl.SimpleIntAccumulator;
import com.metapack.assignments.accumulator.impl.state.IntAccumulatorState;

/**
 * Accumulator Factory class, instantiates accumulators of different types.
 */
public class AccumulatorFactory {

    /**
     * Creates SimpleIntAccumulator instance.
     * @return SimpleIntAccumulator
     */
    public static Accumulator newSimpleIntAccumulator() {
        return new SimpleIntAccumulator();
    }

    /**
     * Creates ConcurrentIntAccumulator instance.
     * @return ConcurrentIntAccumulator
     */
    public static Accumulator newConcurrentIntAccumulator() {
        return new ConcurrentIntAccumulator(new IntAccumulatorState(0));
    }

}
