package com.example.demo.entity;

public class SingletonDemo {
    private static SingletonDemo singletonDemo=null;
    private SingletonDemo(){

    }
    public static SingletonDemo getInstance(){
        if (singletonDemo==null){
            synchronized (SingletonDemo.class){
                if (singletonDemo==null){
                    singletonDemo=new SingletonDemo();
                }
            }
        }
        return singletonDemo;
    }
    static class A{
        private static A a=new A();
        private A(){};
        public A getA(){
            return a;
        }
    }
}
