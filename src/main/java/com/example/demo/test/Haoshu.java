package com.example.demo.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Haoshu {
    public static int[] haoshu(int[] arr,int left,int right){
        if (left<right){
            int pi=p(arr,left,right);
            haoshu(arr,left,pi-1);
            haoshu(arr,pi+1,right);
        }
        return arr;
    }

    public static int p(int[] arr, int left ,int right){
        int p=arr[left];
        while (left<right){
            while (arr[right]>=p&&left<right){
                right--;
            }
            arr[left]=arr[right];
            while (arr[left]<=p&&left<right){
                left++;
            }
            arr[right]=arr[left];
        }
        arr[left]=p;
        return left;
    }

    public static int zichuang(String ss){
        long count=0;
        long num=0;
        for (int i=0;i<ss.length();i++){
            if (ss.charAt(i)=='1'){
                num++;
            }else {
                count+=((num+1)*num/2)%1000000007;
                num=0;
            }
        }
        count+=((num+1)*num/2)%1000000007;
        return (int)count;
    }

    public static void main(String[] args) {
//        int[]arr={8,5,4,5,7};
//        int a=10;
//        int b;
//        int c;
//        Object o=new Object();
////        System.out.println(zichuang("11100010"));
//        for (Integer i:haoshu(arr,0,arr.length-1)) {
//            System.out.println(i);
//        }
        String s1= new String("dahua");
        String s2= new String("dahua");

        Set set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        Iterator iterator= set.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
