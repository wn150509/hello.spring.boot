package com.example.demo.entity;

public class TwoListSearch {
    private int[][] arr;
    private int a;
    boolean flag=false;

    public boolean findNum(int[][] list,int n){
        int currentRow=0;
        int currentCol=list[0].length-1;
        int count=list.length;
        if (list.length<0){
            return flag;
        }
        while (currentRow<count&&currentCol>=0){
            if (list[currentRow][currentCol]==n){
                return flag=true;
            }
            if (list[currentRow][currentCol]<n){
                currentRow++;
            }else {
                currentCol--;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[][] arr= {{2,3,5,8},{4,5,8,9},{5,6,8,10},{6,11,9,13}};
        int a=13;
        TwoListSearch t=new TwoListSearch();
        System.out.println(t.findNum(arr,a));
    }
}
