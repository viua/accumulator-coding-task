package com.metapack.assignments.accumulator;

import com.metapack.assignments.accumulator.api.Accumulator;
import com.metapack.assignments.accumulator.api.AccumulatorFactory;

public class SimpleIntAccumulatorTest extends AccumulatorBaseTest {

    @Override
    protected Accumulator createAccumulator() {
        return AccumulatorFactory.newSimpleIntAccumulator();
    }
}
