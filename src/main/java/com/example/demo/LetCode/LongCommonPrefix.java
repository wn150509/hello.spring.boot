package com.example.demo.LetCode;
//输入一组字符串数组，输出数组中最长公共头部
/*
* 输入：["flow","flower","flight","fight"]
* 输出：“f”
* */
public class LongCommonPrefix {
    public static String longCommonPrefix(String[] strs){
        int idx = 0;
        StringBuilder string = new StringBuilder();
        if (strs.length!=0){
            while (idx<strs[0].length()){
                StringBuilder tmp = new StringBuilder();
                tmp.append(strs[0].charAt(idx));
                for (int i=1; i<strs.length; i++){
                    if (strs[i].length()<idx+1){
                        return string.toString().substring(0,idx);
                    }
                    if (!tmp.toString().contains(String.valueOf(strs[i].charAt(idx)))){
                        return string.toString().substring(0,idx);
                    }else {
                        continue;
                    }
                }
                string.append(tmp);
                idx++;
            }
        }
        return string.toString();
    }

    public static void main(String[] args) {
        String[] strings={"abca","aba","aaab"};
        System.out.println(longCommonPrefix(strings));
    }
}
