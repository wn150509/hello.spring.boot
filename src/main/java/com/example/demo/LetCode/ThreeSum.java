package com.example.demo.LetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 三数之和
* 输入：nums = {1,-1,2,0,-1,3}
* 输出：[[1,-1,0],[-1,-1,2]]
* 从数组中选择三个数，使其之和相加为零，结果集不可有重复元素
* */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> listList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {          //排序后若第一位大于零则结果为空集
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {//
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] > 0) {
                    break;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] > 0) {
                        break;
                    }
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        listList.add(list);
                    }
                }
            }
        }
        return listList;
    }

    public static void main(String[] args) {
        int[] nums = {1,-1,0,-1,2,3};
        System.out.println(threeSum(nums));
    }

}
