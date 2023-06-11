package com.metapack.assignments.accumulator.api;

import com.metapack.assignments.accumulator.impl.ConcurrentIntAccumulator;
import com.metapack.assignments.accumulator.impl.SimpleIntAccumulator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccumulatorFactoryTest {

    @Test
    void shouldCreateSimpleIntAccumulator() {
        // given & when
        var accumulator = AccumulatorFactory.newSimpleIntAccumulator();

        // then
        assertNotNull(accumulator);
        assertTrue(accumulator instanceof SimpleIntAccumulator);
    }

    @Test
    void shouldCreateConcurrentIntAccumulator() {
        // given & when
        var accumulator = AccumulatorFactory.newConcurrentIntAccumulator();

        // then
        assertNotNull(accumulator);
        assertTrue(accumulator instanceof ConcurrentIntAccumulator);
    }
}