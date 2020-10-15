package com.example.demo.test;

public class A {
    public A(){
        System.out.println("父类构造方法");
    }
    static {
        System.out.println("父类静态代码块");
    }
    {
        System.out.println("父类代码块");
    }
}
class B extends A{
    public B(){
        System.out.println("子类构造方法");
    }
    static {
        System.out.println("子类静态代码块");
    }
    {
        System.out.println("子类代码块");
    }
}
class eee{
    public static void main(String[] args) {
        B b = new B();
    }
}
