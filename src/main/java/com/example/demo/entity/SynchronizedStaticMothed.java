package com.example.demo.entity;

import org.hibernate.annotations.Synchronize;

public class SynchronizedStaticMothed {
    public static int sum;
    public synchronized static void synchronizedCaculate(){
        sum=sum+1;
    }
}
