package com.example.demo.entity;

import java.io.*;

public class ExternalizableTest {
    public static void main(String[] args) {
        // 初始化
        ExternalizableDemo externalizableDemo = new ExternalizableDemo();
        externalizableDemo.setName("王二");
        externalizableDemo.setAge(18);
        System.out.println(externalizableDemo);

// 把对象写到文件中
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("chenmo"));) {
            oos.writeObject(externalizableDemo);
        } catch (IOException e) {
            e.printStackTrace();
        }

// 从文件中读出对象
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("chenmo")));) {
            ExternalizableDemo externalizableDemo1 = (ExternalizableDemo) ois.readObject();
            System.out.println(externalizableDemo1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
