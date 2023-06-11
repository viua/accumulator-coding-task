package com.metapack.assignments.accumulator.impl.state;

/**
 * Holds total accumulated value
 */
public interface AccumulatorState {

    /**
     * Returns total accumulated value
     * @return total
     */
    int get();

    /**
     * Updates state's total sum
     * @param value to add to total accumulated value
     */
    void update(int value);

    /**
     *  Sets total accumulated value to 0
     */
    void reset();
}
