package com.example.demo.excel;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String name;
    private String nickName;
    private String sexy;
    private String age;
    private String address;
    private String phone;

    public User() {
    }

    public User(Integer id, String name, String nickName, String sexy, String age, String address, String phone) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.sexy = sexy;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }
}
