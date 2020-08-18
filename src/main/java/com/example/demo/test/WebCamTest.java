package com.example.demo.test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WebCamTest {
    private static JFrame window;

    public static int getSub(String s){
//        List<Integer>counts=new ArrayList<>();
//        int first=0;
//        while (first<s.length()){
//            char c = s.charAt(first);
//            int sum=0;
//            while (first<s.length()&&s.charAt(first)==c){
//                first++;
//                sum++;
//            }
//            counts.add(sum);
//        }
//        int count = 0;
//        for (int i=1;i<counts.size();i++){
//            count+= Math.min(counts.get(i),counts.get(i-1));
//        }
//        return count;
        int last=0,cur=1,sum=0;
        for (int i=1;i<s.length();i++){
            if (s.charAt(i)==s.charAt(i-1)){
                cur++;
            }else {
                last=cur;
                cur=1;
            }
            if (last>=cur)sum++;
        }
        return sum;
    }

    public static int newArray(int[] nums,int val){
        int j=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=val){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
    public static void main(String[] args) {
        int[]nums={1,2,3,3,4,5};
        System.out.println(newArray(nums,3));
    }
}
