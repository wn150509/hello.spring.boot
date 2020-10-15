package com.example.demo.bishi;

public class HenSheng{
    public static int[] mergeSort(int[] data,int low, int high){
        int mid = (low+high)/2;
        if (low<high){
            mergeSort(data,low,mid);
            mergeSort(data,mid+1,high);
            merge(data,low,mid,high);
        }
        return data;
    }

    public static void merge(int[] nums,int low,int mid,int high){
        int[] temp = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k = 0;

        while (i<=mid && j<=high){  //将较小值先加入到暂存数组种
            if (nums[i]<nums[j]){
                temp[k++]=nums[i++];
            }else {
                temp[k++]=nums[j++];
            }
        }

        while (i<=mid){//将左边剩余加入数组
            temp[k++]=nums[i++];
        }

        while (j<=high){//将右边剩余加入数组
            temp[k++]=nums[j++];
        }

        for (int m=0; m<temp.length; m++){//将排序结果copy到原数组中
            nums[m+low]=temp[m];
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,5,7,9,3,4};
        for (int a:mergeSort(arr,0,arr.length-1)) {
            System.out.println(a);
        }
    }
}
