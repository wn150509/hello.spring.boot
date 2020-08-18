package com.example.demo.test;

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

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}

