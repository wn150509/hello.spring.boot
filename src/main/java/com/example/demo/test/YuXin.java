package com.example.demo.test;

public class YuXin{

    static class Person{
        private String name="father";
        public String getName(){
            return name;
        }
    }

    static class Child extends Person{
        private String name="test";

        public static void main(String[] args) {
//           Child p = new Child();
//           System.out.println(p.getName());
           double x = 2.0;
           int y = 4;
//            x/=++y;
            x/=5;
            System.out.println(x);
        }
    }

    abstract class Per implements hhh{
        public void print(){}
    }

    StringBuffer sb = new StringBuffer();
    StringBuilder sbb = new StringBuilder();


}
