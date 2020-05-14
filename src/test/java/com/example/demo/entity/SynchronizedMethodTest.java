package com.example.demo.entity;


import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by wangn on 2020/5/13.
 */
public class SynchronizedMethodTest {
    @Test
    public void calculate() throws InterruptedException {
        ExecutorService service= Executors.newFixedThreadPool(3);
        SynchronizedMethod summation=new SynchronizedMethod();
        IntStream.range(0,1000).forEach(count -> service.submit(summation::calculate));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);
        assertEquals(1000,summation.getSum());
    }

    @Test
    void synchronizedCaculate() throws InterruptedException {
        ExecutorService service=Executors.newFixedThreadPool(3);
        SynchronizedMethod summation=new SynchronizedMethod();
        IntStream.range(0,1000).forEach(count->service.submit(summation::synchronizedCaculate));
        service.awaitTermination(1000,TimeUnit.MILLISECONDS);
        assertEquals(1000,summation.getSum());
    }

    @Test
    void synchronizedThis() throws InterruptedException {
        ExecutorService service=Executors.newFixedThreadPool(3);
        SynchronizedMethod summation=new SynchronizedMethod();
        IntStream.range(0,1000).forEach(count->service.submit(summation::synchronizedThis));
        service.awaitTermination(1000,TimeUnit.MILLISECONDS);
        assertEquals(1000,summation.getSum());
    }
}