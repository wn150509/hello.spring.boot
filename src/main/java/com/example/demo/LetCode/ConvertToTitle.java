package com.example.demo.LetCode;
/*
* 输入某个正整数N（1~N），对应某个列
* 输入：1      输出：A
* 输入：27     输出：AA
* 输入：702    输出：ZZ
* */

public class ConvertToTitle {
    public static String convertToTitle(int n){
        StringBuilder sb = new StringBuilder();
        while (n!=0){
            n--;
            sb.append((char)('A'+ n%26));
            n/=26;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(convertToTitle(704));
    }
}
