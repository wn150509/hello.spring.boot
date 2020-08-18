package com.example.demo.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tryCatch {
    static int aa=0;
    public int test(){
        int[] ar=new int[10];
        bubbleSort(ar);
        int a=0;
        try {
            a++;
            throw new Exception("hh");
        }catch (Exception e){
//            System.out.println(a);
            a++;
//            return a;
        }finally {
            a++;
            return a;
//            System.out.println("a1:"+a);
        }
    }

    public static void bubbleSort(int arr[]) {
        aa=0;
        List<Integer> list=new ArrayList<>();
        for(int i =0 ; i<arr.length-1 ; i++) {
            for(int j=0 ; j<arr.length-1-i ; j++) {

                if(arr[j]<arr[j+1]) {
                    int temp = arr[j];

                    arr[j]=arr[j+1];

                    arr[j+1]=temp;
                }
            }
        }
        for (Integer i:arr) {
            System.out.println(i);
        }
    }

    public static String string(String[] strings){
        if (strings.length!=0){
            char[] arr=strings[0].toCharArray();
            for (int i=1;i<strings.length;i++){
                if (strings[i].length()<arr.length){
                    arr=strings[i].toCharArray();
                }
            }
            StringBuilder builder=new StringBuilder();
            for (int i=0;i<arr.length;i++){
                for (int j=0;j<strings.length;j++){
                    if (strings[j].charAt(i)!=arr[i]){
                        return String.valueOf(builder);
                    }
                }
                builder.append(arr[i]);
            }
            return String.valueOf(builder);
        }
        return "";
    }

    public static void pp(StringBuffer x,StringBuffer y){
        x.append(y);
//        y=x;
        y.append(x);
        System.out.println(y);
    }
    public static void main(String[] args) {
//        List<String> list = new ArrayList<String>();
//        list.add("张三1");
//        list.add("张三2");
//        list.add("张三3");
////        list.add("张三4");
//
//        //使用迭代器遍历ArrayList集合
//        Iterator<String> listIt = list.iterator();
//        while(listIt.hasNext()){
//            String obj = listIt.next();
//            if(obj.equals("张三3")){
//                listIt.remove();
//            }
//        }

//        System.out.println("list".substring(0,1).equals("l"));

        int i=5;int j=10;
        System.out.println(i+ ~j);
    }
}
