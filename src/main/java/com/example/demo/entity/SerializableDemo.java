package com.example.demo.entity;

import java.io.Serializable;

public class SerializableDemo implements Serializable {
    private static final long serialVersionUID = -2095916884810199532L;

    public String name;
    public Integer age;

    public static String pre = "沉默";
    transient String meizi = "王三";

    @Override
    public String toString() {
        return "SerializableDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", pre="+pre+
                ", meizi='" + meizi + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
