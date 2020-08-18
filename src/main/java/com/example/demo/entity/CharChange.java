package com.example.demo.entity;

import sun.awt.image.ImageWatched;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class CharChange {
    public static String change(String s){
        char[] arr=new char[s.length()*3];
        int size=0;
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (c==' '){
                arr[size++]='%';
                arr[size++]='2';
                arr[size++]='0';
            }else {
                arr[size++]=c;
            }
        }
        String s1=new String(arr,0,size);
        return s1;
    }

    public static int rev(int n){
//        int res = 0;
//        while (x != 0) {
//            int t = x % 10;
//            int newRes = res * 10 + t;
//            //如果数字溢出，直接返回0
//            if ((newRes - t) / 10 != res)
//                return 0;
//            res = newRes;
//            x = x / 10;
//        }
//        return res;

        int m=0;
        while (n!=0){
            int newM=n%10+m*10;
            if ((newM-n%10)/10 != m)
                return 0;
            m=newM;
            n=n/10;
        }
        return m;
    }
    public static int reverse(int n){
        String s= String.valueOf(n);
        String fuhao=s.substring(0,1);
        int k=0;
        if(fuhao!="-"){
            k=rev(n);
        }else {
            int m= Integer.parseInt(s.substring(1));
            k=Integer.parseInt("-"+String.valueOf(rev(m)));
        }
        return k;
    }

    public static void main(String[] args){
        System.out.println(reverse(-120));
//        System.out.println(change(" h h "));

//        Scanner scanner=new Scanner(System.in);
//        String s=scanner.nextLine();
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        String s = br.readLine();
//        System.out.println(s);
//        Queue<Integer> queue=new LinkedList<Integer>();
//        queue.offer(1);
//        queue.offer(2);
//        int[] arr = new int[2];
//        Stack<Integer> s=new Stack<>();
//        s.pop().intValue();
//        for (int i=0;i<arr.length;i++){
//            arr[i]=queue.poll();
//        }
//        for (int i:arr) {
//            System.out.println(i);
//        }
    }
}
