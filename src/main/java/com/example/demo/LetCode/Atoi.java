package com.example.demo.LetCode;

/*
*       字符串转换整数
*       1、去除字符符号前的无用符号（空格）
*       2、匹配正号（+）、负号（-）有效字符
*       3、识别数字，越界处理  ans > (Integer.MAX_VALUE-当前数字)/10
*       3、将无用符号剔除（0-9之外的字符）
* */
public class Atoi {
    public static int myAtoi(String s){
        int dex = 0;
        char[] arr = s.toCharArray();
        int n = arr.length;
        while (dex<n && arr[dex]==' '){ //去除字符前的所有空格
            dex++;
        }
        if (dex==n){        //全部是空格
            return 0;
        }

        int count = 0;
        Boolean flag=false;
        if (arr[dex]=='-'){
            flag =true;
            dex++;
        }else if (arr[dex]=='+'){
            dex++;
        }else if (!Character.isDigit(arr[dex])){
            return 0;
        }

        while (dex<n && Character.isDigit(arr[dex])){
            int dig = arr[dex] - '0';
            if (count>(Integer.MAX_VALUE-dig)/10){
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            count = count*10+dig;
            dex++;
        }
        return flag ? -count : count;
    }

    public static void main(String[] args) {
        String s = " ";
//        System.out.println(s.matches("(-|\\+|[0-9])"));
        System.out.println(myAtoi("  "));
    }
}
