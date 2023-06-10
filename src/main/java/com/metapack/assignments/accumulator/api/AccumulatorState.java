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
     * Updates state total sum
     * @param value to add to total accumulated sum
     */
    void update(int value);

    /**
     *  Set total accumulated value to 0
     */
    void reset();
}
