package com.example.demo.LetCode;
/*
二进制相加
例子：输入：11  ，  1   输出：100
    输入：1010，  1011 输出：10101
*/
public class AddBinary {
    public static String addBinary(String a,String b){
        StringBuilder sb = new StringBuilder();
        int i=a.length()-1, j=b.length()-1;
        int carry = 0;      //进位
        while (i>=0 && j>=0){
            int sum = carry;
            sum += a.charAt(i--)-'0';
            sum += b.charAt(j--)-'0';
            sb.append(sum%2);
            carry = sum/2;
        }
        while (i>=0){
            int sum =carry;
            sum += a.charAt(i--)-'0';
            sb.append(sum%2);
            carry = sum/2;
        }
        while (j>=0){
            int sum = carry;
            sum += b.charAt(j--)-'0';
            sb.append(sum%2);
            carry = sum/2;
        }
        if (carry==1){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static String two(String a,String b){
        StringBuilder sb = new StringBuilder();
        int ca =0;      //进位
        for (int i=a.length()-1, j=b.length()-1; i>=0||j>=0; i--,j--){
            int sum = ca;
            sum += i>=0 ? a.charAt(i)-'0' : 0 ;
            sum += j>=0 ? b.charAt(j)-'0' : 0 ;
            sb.append(sum%2);
            ca = sum /2;

        }
        sb.append(ca==1 ? ca : "");
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(two("1010","1011"));
    }
}
