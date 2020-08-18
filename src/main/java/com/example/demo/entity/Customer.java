package com.example.demo.entity;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
public class Customer implements Runnable{
    private final BlockingQueue<Integer> queue;

    public Customer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(2000);
                get(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void get(int n){
        System.out.println("Thread"+Thread.currentThread().getId()+"consume"+n);
    }
}
