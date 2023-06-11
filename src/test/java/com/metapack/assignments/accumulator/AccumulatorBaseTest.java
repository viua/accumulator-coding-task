package com.metapack.assignments.accumulator;

import com.metapack.assignments.accumulator.api.Accumulator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;

public abstract class AccumulatorBaseTest {

    private final Accumulator accumulator = createAccumulator();

    protected abstract Accumulator createAccumulator();

    @Test
    void shouldThrowExceptionOnAccumulatingNull() {
        assertThrows(IllegalArgumentException.class, () -> accumulator.accumulate(null));
    }

    @Test
    void shouldAccumulate() {
        assertAll(
                () -> assertEquals(6, accumulator.accumulate(1, 2, 3)),
                () -> assertEquals(4, accumulator.accumulate(4)),
                () -> assertEquals(10, accumulator.getTotal())
        );
    }

    @Test
    void shouldAccumulateZero() {
        assertAll(
                () -> assertEquals(0, accumulator.accumulate()),
                () -> assertEquals(0, accumulator.getTotal())
        );
    }

    @Test
    void shouldAccumulatePositiveAndNegative() {
        assertAll(
                () -> assertEquals(0, accumulator.accumulate(0, 0)),
                () -> assertEquals(0, accumulator.getTotal()),
                () -> assertEquals(-2, accumulator.accumulate(-3, 1)),
                () -> assertEquals(-6, accumulator.accumulate(-1, -2, -3)),
                () -> assertEquals(-8, accumulator.getTotal())
        );
    }

    @Test
    void shouldAccumulateAndReset() {
        assertAll(
                () -> assertEquals(0, accumulator.getTotal()),
                () -> assertEquals(2, accumulator.accumulate(1, 3, -2)),
                () -> assertEquals(3, accumulator.accumulate(3)),
                () -> assertEquals(5, accumulator.getTotal()),
                () -> accumulator.reset(),
                () -> assertEquals(0, accumulator.getTotal()),
                () -> assertEquals(4, accumulator.accumulate(1, 1, 2)),
                () -> assertEquals(4, accumulator.getTotal()));
    }
}
