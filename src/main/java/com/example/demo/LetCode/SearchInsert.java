package com.example.demo.LetCode;

public class SearchInsert {
    public static int searchInsert(int[] arr,int n){
        int index=0;
        for(int i=0; i<arr.length; i++){
            if (n==arr[i]){
                return i;
            }
        }
        for (int i=arr.length-1; i>=0; i--){
            if (n>arr[i]){
                return i+1;
            }else {
                if (i==0){
                    return i;
                }
                continue;
            }
        }
        return index;
    }

    public static int two(int[] arr, int n){
        for (int i=0; i<arr.length; i++){
            if (arr[i]>=n){
                return i;
            }
        }
        return arr.length;
    }

    public static void main(String[] args) {
        int[] arr={1,3,5,6};
        System.out.println(two(arr,0));
    }
}
