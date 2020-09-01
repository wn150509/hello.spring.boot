package com.example.demo.LetCode;
/*
* 给定一字符串，该字符串仅由大小写字母和空格组成；
* 求出该字符串的最后一个单词个数
* 例：输入：""              输出：0
*   输入：“    ”           输出：0
*   输入：“hello world   ” 输出：5
*   输入：“hello world"    输出：5
* */

public class LengthOfLastWord {
    /*
    * 方法一：一次遍历去除尾部空格、二次遍历最后一个单词
    * */
    public static int lengthOfLastWord(String s){
        int count = 0;
        char[] arr = s.toCharArray();
        int length = s.length();
        int n = 0;

        if (length==0){
            return count;
        }else {
            while (n<length&&arr[length-n-1]==' '){
                n++;        //去除字符串最后一个单词后面的所有空格
            }
            if (length-n==0){
                return count;//全是空格
            }
            for (int i=length-n-1;i>=0;i--){
                if (arr[i]!=' '){
                    count++;
                }else {
                    return count;
                }
            }
        }
        return count;
    }

    /*
    * 方法二：从后往前遍历一遍
    * */
    public static int two(String s){
        int count = 0;
        int length = s.length();
        boolean flag = false;
        if (length==0){
            return count;
        }else {
            for (int i = length-1;i>=0;i--){
                if (s.charAt(i)==' '){
                    if (flag){
                        return count;
                    }else {
                        flag=false;
                        continue;
                    }
                }else {
                    count++;
                    flag=true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(lengthOfLastWord(""));
        char[] arr = "".toCharArray();
        System.out.println(two("hello world  "));
    }
}
