package com.metapack.assignments.accumulator;

import com.metapack.assignments.accumulator.api.Accumulator;
import com.metapack.assignments.accumulator.impl.AccumulatorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleAccumulatorTest {

    private final Accumulator intAccumulator = AccumulatorFactory.newIntAccumulator();

    @Test
    void shouldAccumulate() {
        // given
        var simpleAccumulator = AccumulatorFactory.newSimpleAccumulator();

        // when & then
        assertEquals(6, simpleAccumulator.accumulate(1, 2, 3));
        assertEquals(4, simpleAccumulator.accumulate(4));
        assertEquals(10, simpleAccumulator.getTotal());
    }

    @Test
    void shouldThrowExceptionOnAccumulatingNullValue() {
        assertThrows(IllegalArgumentException.class,
                () -> intAccumulator.accumulate(null));
    }

    @Test
    void shouldAccumulateZero() {
        assertAll(
                () -> assertEquals(0, intAccumulator.accumulate()),
                () -> assertEquals(0, intAccumulator.getTotal())
        );
    }

    @Test
    void shouldAccumulatePositives() {
        assertAll(
                () -> assertEquals(6, intAccumulator.accumulate(1, 2, 3)),
                () -> assertEquals(4, intAccumulator.accumulate(4)),
                () -> assertEquals(10, intAccumulator.getTotal())
        );
    }

    @Test
    void shouldAccumulatePositiveAndNegative() {
        assertAll(
                () -> assertEquals(0, intAccumulator.accumulate(0, 0)),
                () -> assertEquals(0, intAccumulator.getTotal()),
                () -> assertEquals(-2, intAccumulator.accumulate(-3, 1)),
                () -> assertEquals(-6, intAccumulator.accumulate(-1, -2, -3)),
                () -> assertEquals(-8, intAccumulator.getTotal())
        );
    }

    @Test
    void shouldAccumulateAndReset() {
        assertEquals(0, intAccumulator.getTotal());
        assertEquals(2, intAccumulator.accumulate(1, 3, -2));
        assertEquals(3, intAccumulator.accumulate(3));
        assertEquals(5, intAccumulator.getTotal());
        intAccumulator.reset();
        assertEquals(0, intAccumulator.getTotal());
        assertEquals(4, intAccumulator.accumulate(1, 1, 2));
        assertEquals(4, intAccumulator.getTotal());
    }
}
