package com.example.demo.entity;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Duplicate {
    public static int findNum(int a){
        int[] arr=new int[a+1];
        for (int i=0;i<arr.length;i++){
            arr[i]= ThreadLocalRandom.current().nextInt(1,a+1);
            System.out.println(arr[i]);
        }
        System.out.println("************************");
        int index;
        for (int i=0;i<arr.length;i++){
            while (arr[i]!=i+1){
                if(arr[i]==arr[arr[i]]){
                    index=arr[i];
                    System.out.println(index);
                    return index;
                }
                int temp=arr[i];
                arr[i]=arr[temp];
                arr[temp]=temp;
            }
        }
        return -1;
    }

    public static void ss(int[] arr){
        HashSet<Integer>set=new HashSet<>();
        HashSet<Integer>set1=new HashSet<>();
        for (Integer num:arr) {
            if (!set.add(num)){
                set1.add(num);
                System.out.println(num);
            }
        }
        System.out.println("---------------------");
        for (Integer i:set1) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
//        int n=10;
//        int[] arr=new int[n];
//        for (int i=0;i<n;i++){
//            arr[i]=new Random().nextInt(n);
//            System.out.println(arr[i]);
//        }
//        System.out.println("******************");
//        ss(arr);
//        findNum(5);
        String a=" hhh 1 ";
        System.out.println(a.replaceAll("\\s","%20"));
    }
}
