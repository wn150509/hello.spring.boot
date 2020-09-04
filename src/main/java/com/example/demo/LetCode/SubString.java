package com.example.demo.LetCode;
//最长不重复串
public class SubString {
    public static int lengthOfSubString(String b){
        int max =0;
        for (int i=0; i<b.length(); i++){
            StringBuilder sb = new StringBuilder();
            sb.append(b.charAt(i));
            for (int j=i+1; j<b.length(); j++){
                if (!sb.toString().contains(String.valueOf(b.charAt(j)))){
                    sb.append(b.charAt(j));
                }else {
                    break;
                }
            }
            max=Math.max(max,sb.toString().length());
        }
        return max;
    }

    public static void main(String[] args) {
        String s = " ";
        System.out.println(lengthOfSubString(s));
    }
}
