package com.example.demo.LetCode;
/*
* 字符串位置求解
*   题意：有两个字符串，前者为模板串，后者为目标串；匹配目标串首字符在模板串中的位置；
*   例子1：
*   输入：str1:"hello world"  str2:"ll"
*   输出：2
*   例子2：
*   输入：str1:"hello world" str2:"oo"
*   输出：-1
*   例子3：
*   输入：str1:"hello world" str2:""
*   输出：0
* */
public class StrStr {
    public static int strStr(String str1,String str2){
        int i=0,j=0;
        if (str1.contains(str2)){
            if (str2==""){
                return 0;
            }
            while (i<str1.length()&&j<str2.length()){
                if (str1.charAt(i)==str2.charAt(j)){
                    i++;
                    j++;
                }else {
                    i=i-j+1;
                    j=0;
                }
            }
            return i-j;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi","issi"));
    }
}
