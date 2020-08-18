package com.example.demo.test;
/*
* 线程组统一异常处理
* */
public class ThreadGroupDemo {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("group"){
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName()+e.getMessage());
//                super.uncaughtException(t, e);
            }
        };
        Thread thread=new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {
                throw new  RuntimeException("测试异常");
            }
        });
        thread.start();
    }
}
