package com.metapack.assignments.accumulator.api;

/**
 * Holds total accumulated value
 */
public interface AccumulatorState {

    /**
     * Returns total accumulated value
     * @return total accumulated value
     */
    int get();

    /**
     * Accumulates total
     * @param value to add to total accumulated sum
     */
    void accumulate(int value);

    /**
     *  Set total accumulated value to 0
     */
    void reset();
}
