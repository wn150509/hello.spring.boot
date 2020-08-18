package com.example.demo.entity;

public class Polindrome {
    public static boolean is(int n){
        boolean flag=false;
        int res=0,m=n;
        if (n<0){
            return flag;
        }
        while (m!=0){
            int newM=res*10+m%10;
            if ((newM-m%10)/10 != res)
                return false;
            res=newM;
            m=m/10;
        }
        if (res==n){
            flag=true;
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(is(101));
    }
}
