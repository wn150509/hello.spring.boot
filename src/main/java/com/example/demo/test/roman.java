package com.example.demo.test;

import com.example.demo.excel.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.xml.ws.WebServiceFeature;
import java.security.cert.CollectionCertStoreParameters;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

import static javafx.scene.input.KeyCode.T;

public class roman {

    public static int returnInt(String s){
        int n=-1;
        switch (s){
            case "I":n=1;break;
            case "V":n=5;break;
            case "X":n=10;break;
            case "L":n=50;break;
            case "C":n=100;break;
            case "D":n=500;break;
            case "M":n=1000;break;
            case "IV":n=4;break;
            case "IX":n=9;break;
            case "XL":n=40;break;
            case "XC":n=90;break;
            case "CD":n=400;break;
            case "CM":n=900;break;
        }
        return n;
    }

    public static int romanToInt(String s){
        int count=0;
        char[] arr=s.toCharArray();
        int preNum=returnInt(String.valueOf(arr[0]));
        for (int i=1;i<arr.length;i++){
            int num=returnInt(String.valueOf(arr[i]));
            if (preNum<num){
                count-=preNum;
            }else {
                count+=preNum;
            }
            preNum=num;
        }
//        for (int i=0;i<arr.length;i++){
//            if (i==arr.length-1){
//                count+=returnInt(String.valueOf(arr[i]));
//            }else {
//                String first= String.valueOf(arr[i]);
//                String end=String.valueOf(arr[i+1]);
//                if (("I".equals(first)&&"V".equals(end))||("I".equals(first)&&"X".equals(end))
//                        ||("X".equals(first)&&"L".equals(end))||("X".equals(first)&&"C".equals(end))
//                        ||("C".equals(first)&&"D".equals(end))||("C".equals(first)&&"M".equals(end))){
//                    count+=returnInt(String.valueOf(arr[i]).concat(String.valueOf(arr[i+1])));
//                    i=i+1;
//                } else {
//                    count+=returnInt(first);
//                }
//            }
//        }
        count+=preNum;
        return count;
    }

    private static String statusIntToString(int status){
        String result = null;
        switch (status){
            case 0: result= "待设计"; break;
            case 1: result= "设计中"; break;
            case 2: result= "研发中"; break;
            case 3: result= "验收中"; break;
            case 4: result= "已交付"; break;
            default: result= null;
        }
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<String> lines = Arrays.asList("11", "22", "33");

        List<User> users = new ArrayList<>();
        for (int i=0; i<5; i++){
            User user = new User();
            user.setAddress("1");
            user.setName("wang");
            users.add(user);
        }
        for (int i=0; i<1; i++){
            User user = new User();
            user.setAddress("1");
            user.setName("zhang");
            users.add(user);
        }
        users.stream().collect(Collectors.groupingBy(User::getName)).forEach((k, userList) ->{
            System.out.println(userList.get(0));
            System.out.println(userList.get(1));
            System.out.println(k);
        });

//        lines.stream().filter(line -> !"11".equals(line)).forEach(line -> System.out.println(line));


//        ExecutorService exe = Executors.newCachedThreadPool();
//
//        Semaphore semaphore = new Semaphore(5);
//
//        for (int i=0; i<50; i++){
//            final int no = i;
//            Runnable run = new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        semaphore.acquire();
//                        System.out.println("访问:"+ no);
//                        Thread.sleep((long) (Math.random()*60000));
//                        semaphore.release();
//                        System.out.println("还有多少信号量："+ semaphore.availablePermits());
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            };
//            exe.execute(run);
//        }
//        exe.shutdown();
    }
}

