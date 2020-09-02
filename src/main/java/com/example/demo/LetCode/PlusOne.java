package com.example.demo.LetCode;

public class PlusOne {
    public static int[] plusOne(int[] arr){
        int index=arr.length-1;
        for (int i=index; i>=0; i--){
            arr[i]++;
            arr[i]=arr[i]%10;
            if (arr[i]!=0) return arr;
            /*if (arr[i]+1<10){
                arr[i]=arr[i]+1;
                return arr;
            }else {
                arr[i]=0;
                if (i==0){
                  arr = new int[index+2];
                  arr[0]=1;
                  return arr;
                }
            }*/
        }
        arr=new int[index+2];
        arr[0]=1;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr={9,9};
        for (Integer i:plusOne(arr)) {
            System.out.println(i);
        }

    }
}
