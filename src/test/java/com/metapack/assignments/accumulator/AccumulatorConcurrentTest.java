package com.metapack.assignments.accumulator;

import com.metapack.assignments.accumulator.impl.AccumulatorFactory;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AccumulatorConcurrentTest {

    private final int THREADS_NUMBER = 5;

    @RepeatedTest(50)
    void shouldAccumulateConcurrent() throws InterruptedException {
        // given
        var accumulator = AccumulatorFactory.newIntAccumulator();
        var pool = Executors.newFixedThreadPool(THREADS_NUMBER);

        // when
        try {
            for (int n = 0; n < 1000; n++) {
                pool.execute(() -> accumulator.accumulate(0, 1, 2, 3, 4));
            }
        } finally {
            pool.shutdown();
            boolean isCompleted = pool.awaitTermination(10L, TimeUnit.SECONDS);
            assertTrue(isCompleted);
        }

        // then
        assertEquals(10000, accumulator.getTotal());
    }

    @Test
    void shouldFailAccumulateConcurrent() throws InterruptedException {
        // given
        var accumulator = AccumulatorFactory.newSimpleAccumulator();
        var pool = Executors.newFixedThreadPool(THREADS_NUMBER);

        // when
        try {
            for (int n = 0; n < 1000; n++) {
                pool.execute(() -> accumulator.accumulate(0, 1, 2, 3, 4));
            }
        } finally {
            pool.shutdown();
            boolean isCompleted = pool.awaitTermination(10L, TimeUnit.SECONDS);
            assertTrue(isCompleted);
        }

        // then
        assertNotEquals(10000, accumulator.getTotal());
    }

}
