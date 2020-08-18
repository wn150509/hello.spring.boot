package com.example.demo.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by wangn on 2020/5/13.
 */
public class SynchronizedMethod {
    private int sum;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void calculate(){
        setSum(getSum()+1);
    }

    public synchronized void synchronizedCaculate(){
        setSum(getSum()+1);
    }

    public void synchronizedThis(){
        synchronized (this){
            setSum(getSum()+1);
        }
    }
}
