package com.example.demo.LetCode;

import java.util.Stack;
/*
* 翻转字符串里的单词
* 输入：“the sky is blue” 输出：“blue is sky the”
* 输入：“  hello  word  ” 输出：“word hello" 取出头部尾部多余的空格，两个单词之间只能有一个空格
* */
public class ReverseWords {

    public static String reverseWords(String s){
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = s.length()-1;
        if (s.length()==0){
            return "";
        }
        while (start<=end){      //去头部空格
            if (s.charAt(start)==' '){
                start++;
            }else {
                break;
            }
        }
        if(start>end){
            return "";
        }
        while (end>=0){      //去尾部空格
            if (s.charAt(end)==' '){
                end--;
            }else {
                break;
            }
        }
        Stack<Character> stack = new Stack<>();
        for (int i=start; i<=end; i++){     //将字符串处理完空格入栈
            if (s.charAt(i)!=' '||s.charAt(i-1)!=' '){
                stack.push(s.charAt(i));
            }
        }
        while (!stack.empty()) {        //将字符串出栈
            if (stack.peek()!=' '){
                sb.append(stack.peek());
            }else {
                sb.reverse();
                stringBuilder.append(sb).append(stack.peek());
                sb=new StringBuilder();
            }
            stack.pop();
        }
        sb.reverse();
        stringBuilder.append(sb);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("hello   word!"));
    }
}
