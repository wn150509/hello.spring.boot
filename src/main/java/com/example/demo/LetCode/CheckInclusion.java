package com.example.demo.LetCode;

import java.beans.IntrospectionException;
import java.util.HashMap;
import java.util.Map;

/*
* 字符串的排列：给定两个字符串S1,S2，如果S1的排序之一是S2的子串，则返回true；否则为false
* 输入：S1=“ab”,S2="eibaoo"; 输出：true
* 输入：S1="ab",S2="eiboaoo"; 输出：false
* */
public class CheckInclusion {
    public static boolean checkInclusion(String source,String target){
        boolean flag = true;
        int idx = 0;
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> mapLog = new HashMap<>();
        for (int i=0; i<source.length(); i++){
            if (map.containsKey(source.charAt(i))){
                map.put(source.charAt(i),map.get(source.charAt(i))+1);
            }else {
                map.put(source.charAt(i),0);        //将源串中有的字符put到map数组中
            }
        }
        mapLog = map;
        int count = 0;
        for (int i=0; i<target.length(); i++){
            if (mapLog.containsKey(target.charAt(i))&&mapLog.get(target.charAt(i))>0){
                mapLog.put(target.charAt(i),mapLog.get(target.charAt(i))-1);
            }else {

            }
        }
        for (int i=0; i<source.length(); i++){
            if (map.get(source.charAt(i))==0){
                return false;
            }
        }
        return flag;
    }

    public static void main(String[] args) {

    }
}
