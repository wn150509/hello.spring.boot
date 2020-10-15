package com.example.demo.test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
* Runnable接口与Callable接口区别
* Runnable接口    调用run方法，没有返回值
* Callable接口    调用call方法，有返回值
**/
public class Callable implements java.util.concurrent.Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i=0; i<10; i++){
            System.out.println("线程执行："+i);
        }
        return "线程执行完毕";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new Callable());
        new Thread(futureTask).start();
        System.out.println("线程返回数据："+futureTask.get());

        new Thread(new Mythread()).start();
    }

    static class Mythread implements Runnable{

        @Override
        public void run() {
            for (int i=0; i<10; i++){
                System.out.println("线程执行："+i);
            }
        }
    }
}
