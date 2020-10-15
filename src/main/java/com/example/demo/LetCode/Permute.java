package com.example.demo.LetCode;

import java.util.*;

/*
* 全排列 1
* */
public class Permute {
    public static List<List<Integer>> permute (int[] nums){
        List<List<Integer>> lists = new ArrayList<>();
        int len = nums.length;
        if (len==0){
            return lists;
        }
        Deque<Integer> path = new ArrayDeque<Integer>();
        boolean[] used = new boolean[len];
        dfs(len,nums,0,path,lists,used);
        return lists;
    }

    public static void dfs(int len, int[] nums, int depth, Deque<Integer> path, List<List<Integer>> lists, boolean[] used){
        if (len == depth){
            lists.add(new ArrayList<>(path));
            return;
        }

        for (int i=0; i<len; i++){
            if (used[i]){
                continue;
            }

            used[i]=true;
            path.addLast(nums[i]);
            dfs(len,nums,depth+1,path,lists,used);
            path.removeLast();
            used[i]=false;
        }
    }
}
