package com.example.demo.dao;

public interface Electronic {
    String LED="LED";//常量
    int getElectronicUse();//抽象方法
    static boolean isEnergyEfficient(String electronicType){
        return electronicType.equals(LED);//静态方法
    }
    default void printDescription(){
        System.out.println("电子");//默认方法
    }
}