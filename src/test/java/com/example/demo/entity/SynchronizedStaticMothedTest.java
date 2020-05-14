package com.example.demo.entity;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class SynchronizedStaticMothedTest {

    @Test
    void synchronizedCaculate() throws InterruptedException {
        ExecutorService service= Executors.newFixedThreadPool(3);
        IntStream.range(0,1000)
                .forEach(count->service.submit(SynchronizedStaticMothed::synchronizedCaculate));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);
        assertEquals(1000,SynchronizedStaticMothed.sum);
    }
}