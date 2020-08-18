package com.example.demo.entity;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue q){
        this.queue=q;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                queue.put(get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public int get(){
        int n=new Random().nextInt(1000);
        System.out.println("Thread"+Thread.currentThread().getId()+"produce"+n);
        return n;
    }
}
