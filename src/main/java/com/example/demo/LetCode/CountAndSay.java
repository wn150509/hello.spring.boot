package com.example.demo.LetCode;
/*
* 外观数列
* 给定定义：输入一个整数n，输出一个外观数列第n项
* 定义如下
*   1：1             基数
*   2：11            一个一
*   3：21            两个一
*   4：1211          一个二一个一
*   5：111221        一个一一个二两个1
*   ...
*
* */
public class CountAndSay {
    public static String countAndSay(int n){
        String str="1";     //初始字符串 1
        for (int i=2; i<=n; i++){   //遍历2之后的输入
            StringBuilder sb= new StringBuilder();      //定义当前序号的字符串
            char pre=str.charAt(0);     //前一位字符
            int count=1;            //初始化个数
            for (int j=1; j<str.length(); j++){     //遍历前一个序列对应的字符串
                char c=str.charAt(j);       //取出字符
                if (pre==c){            //判断当前字符与前一位字符是否相等
                    count++;            //相等数量加一
                }else {
                    sb.append(count).append(pre);   //不等则把数量与前一位字符加到流中
                    pre=c;          //当前字符赋值给前一位字符
                    count=1;        //初始化个数
                }
            }
            sb.append(count).append(pre);
            str=sb.toString();              //当前序号字符串
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(20));
    }
}
