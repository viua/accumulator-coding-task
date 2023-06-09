package com.metapack.assignments.accumulator;

import com.metapack.assignments.accumulator.impl.SimpleAccumulator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleAccumulatorTest {

    @Test
    void shouldAccumulate() {
        // given
        var accumulator = new SimpleAccumulator();
        // when & then
        assertEquals(6, accumulator.accumulate(1, 2, 3));
        assertEquals(4, accumulator.accumulate(4));
        assertEquals(10, accumulator.getTotal());
    }
}
