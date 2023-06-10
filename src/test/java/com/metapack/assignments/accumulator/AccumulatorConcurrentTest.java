package com.metapack.assignments.accumulator;

import com.metapack.assignments.accumulator.impl.AccumulatorFactory;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AccumulatorConcurrentTest {

    private final ExecutorService pool = Executors.newFixedThreadPool(4);

    @RepeatedTest(50)
    void shouldAccumulateConcurrent() throws InterruptedException {
        var accumulator = AccumulatorFactory.newIntAccumulator();
        for (int n = 0; n < 1000; n++) {
            pool.execute(() -> accumulator.accumulate(0, 1, 2, 3, 4));
        }
        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.SECONDS);

        assertEquals(10000, accumulator.getTotal());
    }

    @Test
    void shouldFailAccumulateConcurrent() throws InterruptedException {
        var accumulator = AccumulatorFactory.newSimpleAccumulator();
        for (int n = 0; n < 100; n++) {
            pool.execute(() -> accumulator.accumulate(0, 1, 2, 3, 4));
        }
        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.SECONDS);

        assertNotEquals(1000, accumulator.getTotal());
    }

}
