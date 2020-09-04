package com.example.demo.RedSpider;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Base5 {
    static class ObjectLock{
        /*
         * 多线程同步操作
         * */
        static Object lock = new Object();      //初始化对象锁
        static class ThreadA implements Runnable{
            @Override
            public void run() {
                synchronized (lock){        //同步锁
                    for (int i=0; i<100; i++){
                        System.out.println("ThreadA："+i);
                    }
                }
            }
        }

        static class ThreadB implements Runnable{
            @Override
            public void run() {
                synchronized (lock){
                    for (int i=0; i<100; i++){
                        System.out.println("ThreadB："+i);
                    }
                }
            }
        }

        public static void main(String[] args) throws InterruptedException {
            new Thread(new ThreadA()).start();
            Thread.sleep(1000);     //防止操作系统可能先执行ThreadB
            new Thread(new ThreadB()).start();
        }
    }
    static class WaitAndNotify{
        /*
        * 等待与通知
        * */
        private static Object lock = new Object();
        static class ThreadA implements Runnable{
            @Override
            public void run() {
                synchronized (lock){
                    for (int i=0; i<5; i++){
                        try {
                            System.out.println("ThreadA："+i);
                            lock.notify();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notify();
                }
            }
        }

        static class ThreadB implements Runnable{
            @Override
            public void run() {
                synchronized (lock){
                    for (int i=0; i<5; i++){
                        try {
                            System.out.println("ThreadB："+i);
                            lock.notify();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notify();
                }
            }
        }

        public static void main(String[] args) throws InterruptedException {
            new Thread(new ThreadA()).start();
            Thread.sleep(10);
            new Thread(new ThreadB()).start();
        }
    }
    static class Signal{
        /*
        * 信号量   volatile
        * */
        private static volatile int signal = 0;
        static class ThreadA implements Runnable{
            @Override
            public void run() {
                while (signal<5000){
                    if (signal%2==0){
                        System.out.println("ThreadA："+signal);
                        synchronized (this){
                            signal++;
                        }
                    }
                }
            }
        }

        static class ThreadB implements Runnable{
            @Override
            public void run() {
                while (signal<5000){
                    if (signal%2==1){
                        System.out.println("ThreadB："+signal);
                        synchronized (this){        //加锁保证原子性
                            signal++;       //复合操作不具有原子性
                        }
                    }
                }
            }
        }

        public static void main(String[] args) throws InterruptedException {
            new Thread(new ThreadA()).start();
            Thread.sleep(10);
            new Thread(new ThreadB()).start();
        }
    }
    static class  Pipe{
        /*
        * 管道：ReaderThread先开始，打印；
        *       pipedReader 阻塞
        *       WriterThread开始执行，打印；
        *       将test写入
        *       pipedWriter 关闭
        *       ReaderThread开始读出，输出test
        *       线程结束
        * 应用场景：I/O流
        * */
        static class ReaderThread implements Runnable{
            private PipedReader pipedReader;
            public ReaderThread(PipedReader pipedReader) {
                this.pipedReader = pipedReader;
            }
            @Override
            public void run() {
                System.out.println("this is pipedReader...");
                int receiver = 0;
                try {
                    while ((receiver = pipedReader.read()) != -1){
                        System.out.print((char) receiver);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        static class WriterThread implements Runnable{
            private PipedWriter pipedWriter;

            public WriterThread(PipedWriter pipedWriter) {
                this.pipedWriter = pipedWriter;
            }
            @Override
            public void run() {
                System.out.println("this is pipedWriter...");
                try {
                    pipedWriter.write("test");
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        pipedWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public static void main(String[] args) throws IOException, InterruptedException {
            PipedWriter pipedWriter = new PipedWriter();
            PipedReader pipedReader = new PipedReader();
            pipedWriter.connect(pipedReader);       //一定要连接，才能通信

            new Thread(new ReaderThread(pipedReader)).start();
            Thread.sleep(1000);
            new Thread(new WriterThread(pipedWriter)).start();
        }
    }
    static class SignalTest{
        /*
        * 交替打印两个数组元素（多线程）
        * */
        static volatile boolean vol = true;
        static volatile boolean over= false;

        static void process(int[]a1,int[]a2){
            Thread t1 = new Thread(() -> {
                for (int i=0; i<a1.length; i++){
                    while (vol!=true&&over==false){
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (vol==true){
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(a1[i]);
                        vol=false;
                    }else {

                    }
                }
                over=true;
            });
            Thread t2 = new Thread(() -> {
                for (int i=0; i<a2.length; i++){
                    while (vol!=false&&over==false){
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (vol==false){
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(a2[i]);
                        vol=true;
                    }else {

                    }
                }
                over=true;
            });
            t1.start();
            t2.start();
        }

        public static void main(String[] args) {
            int[] a1 = {1,3,5,8};
            int[] a2 = {2,4,6,9,10,12};
            process(a1,a2);
        }
    }
    static class Join{
        /*
        * 适用于主线程等待子线程返回的结果，并打印；
        * */
        static class ThreadA implements Runnable{

            @Override
            public void run() {
                try {
                    System.out.println("我是子线程我先睡一秒");
                    Thread.sleep(1000);
                    System.out.println("我是子线程我睡完一秒了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            public static void main(String[] args) throws InterruptedException {
                Thread thread = new Thread(new ThreadA());
                thread.start();
                thread.join();
                System.out.println("加了join之后最后执行，不加join我会先执行");
            }
        }
    }
    static class ThreadLocalDemo{
        /*
        * 本地变量或本地存储，它给每个线程创建一个副本，各个线程之间独立，每个线程可以访问自己副本变量
        * 适用于：数据库连接+session管理（某个类的静态变量与线程状态相关联的情况）
        * 相似的inheritableThreadLocal:不同点在于主线程可以创建副本，子线程也可以；inheritable：继承
        * */
        static class ThreadA implements Runnable{
            ThreadLocal<String> threadLocal = new ThreadLocal<>();
            public ThreadA(ThreadLocal<String> threadLocal){
                this.threadLocal=threadLocal;
            }
            @Override
            public void run() {
                threadLocal.set("A");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("threadA打印结果"+threadLocal.get());
            }
        }

        static class ThreadB implements Runnable{
            ThreadLocal<String> threadLocal = new ThreadLocal<>();
            public ThreadB(ThreadLocal<String> threadLocal){
                this.threadLocal=threadLocal;
            }
            @Override
            public void run() {
                threadLocal.set("B");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("threadB打印结果"+threadLocal.get());
            }
        }

        public static void main(String[] args) {
            ThreadLocal<String> threadLocal = new ThreadLocal<>();
            new Thread(new ThreadA(threadLocal)).start();
            new Thread(new ThreadB(threadLocal)).start();
        }
    }
}
