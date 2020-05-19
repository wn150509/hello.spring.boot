package com.example.demo.entity;

import java.io.*;

public class SerializableTest {
    public static void main(String[] args) {
        //初始化
        SerializableDemo serializableDemo=new SerializableDemo();
        serializableDemo.setName("王宁");
        serializableDemo.setAge(18);
        System.out.println(serializableDemo);

        //将对象写入文件中
        try {
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("chenmo"));
            oos.writeObject(serializableDemo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //改变static字段的值
        SerializableDemo.pre="不沉默";
        //从文件中读出对象
        try {
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream("chenmo"));
            SerializableDemo serializableDemo1=(SerializableDemo) ois.readObject();
            System.out.println(serializableDemo1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
