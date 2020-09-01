package com.example.demo.test;

import org.hibernate.annotations.Synchronize;

public class test {
    private synchronized void testMethod(){
        try{
            Thread.sleep(2000l);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000l);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000l);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"b");

        a.start();
        a.join(1000);
        b.start();

        System.out.println(a.getName()+":"+a.getState());
        System.out.println(b.getName()+":"+b.getState());
    }
}
