package com.example.demo.daoimpl;

import com.example.demo.dao.Electronic;

public class Computer implements Electronic {

    public static void main(String[] args) {
        new Computer();
    }
    @Override
    public int getElectronicUse() {
        return 0;
    }
}
