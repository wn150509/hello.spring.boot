package com.example.demo.entity;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class testProduce {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue=new ArrayBlockingQueue<Integer>(100);

        Producer p=new Producer(queue);
        Customer c1=new Customer(queue);
        Customer c2=new Customer(queue);

        new Thread(p).start();
        new Thread(c1).start();
        new Thread(c2).start();
    }
}
