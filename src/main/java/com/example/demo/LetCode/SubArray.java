package com.example.demo.LetCode;
/*
* 子序和
* */
public class SubArray {
    /*
     * 找出一组数中 最大连续子序和
     * */
    public static int maxSubArray(int[] arr){
        int max = arr[0];
        int sum = 0;
        for (int a:arr) {
            if (sum>0) sum += a;
            else sum  = a;
            max = Math.max(max,sum);
        }
        return max;
    }

    /*
     * 找出一组数中 最小连续子序和
     * */
    public static int minSubArray(int[] arr){
        int min = arr[0];
        int sum = 0;
        for (int a:arr) {
            if (sum<0) sum += a;
            else sum  = a;
            min = Math.min(min,sum);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] a ={-7,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(a));
        System.out.println(minSubArray(a));
    }
}
