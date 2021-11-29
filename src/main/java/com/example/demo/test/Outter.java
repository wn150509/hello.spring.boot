package com.example.demo.test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.text.html.HTMLDocument;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Outter {
    private static AtomicInteger count = new AtomicInteger(0);

    public int[] singleNumbers(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            if (hashSet.add(nums[i])) {
                continue;
            }else {
                hashSet.remove(nums[i]);
            }
        }
        int[] arr = new int[hashSet.size()];
        int j =0;
        for (int a : hashSet) {
            arr[j] = a;
            j++;
        }
        return arr;
    }

    //元音辅音 a e i o u A E I O U 字符串转换

    public String changeStr(String str) {
        if (str.trim() == "" || str==null){
            return "";
        }
        char[] arr = str.toCharArray();
        int[] index = new int[arr.length];//元音辅音下标
        for(int i=0; i<arr.length; i++) {
            char a = arr[i];
            if (a=='a' || a=='e' || a=='i' || a=='o' || a=='u' || a=='A' || a=='E' || a=='I' || a=='O' || a=='U') {
                index[i] = 1;
            }
        }

        int i=0, j=arr.length-1;
        while (i<j) {
            while (index[i]!=1 && i<j)++i;
            while (index[j]!=1 && i<j)--j;
            if (i<j) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                ++i;--j;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char a: arr) {
            sb.append(a);
        }
        return sb.toString();
    }

    public boolean isSuccess(int[] arr, int n) {
        if (arr.length==0 || arr.length<n) {
            return false;
        }
        int count = 0; //满足情况的数量
        for (int i=0; i<arr.length; i++) {
            if (i==0) {
                if (arr[i]==0 && arr[i+1]==0){ count++;arr[i]=1;}
            }else if (i==arr.length-1) {
                if (arr[i]==0 && arr[i-1]==0){ count++;arr[i]=1;}
            }else {
                if (arr[i-1]==0 && arr[i]==0 && arr[i+1]==0){ count++;arr[i]=1;}
            }
        }
        return count>=n;
    }

    //回文字符串，最多允许删除一个字符是否还构成回文字符串
    public boolean validPalindrome(String str) {
        if (str.length()==1 || str.trim()=="") return true;
        char[] arr = str.toCharArray();
        int index0=-1, index1=-1;//记录第一次的不构成回文字符串的下标
        int flag0=-1, flag1=-1; //记录第二次比较后的不构成回文字符串的flag
        int i=0, j=str.length()-1;
        while (i<j) {
            if (arr[i]!=arr[j]) {
                index0 = i;
                index1 = j;
                break;
            }
            ++i; --j;
        }
        if (index0 != -1) {//左侧出现了不一致字符
            char[] a = new char[str.length()-1];
            int n = 0;//记录删除一个字符后新数组的下标
            for (int m=0; m<arr.length; m++) {
                if (m!=index0) {
                    a[n]=arr[m];
                    n++;
                }
            }
            int x=0, y=a.length-1;
            while (x<y) {
                if (a[x]!=a[y]) {
                    flag0=0;
                }
                ++x; --y;
            }
        }
        if (index1 != -1) {//右侧出现了不一致字符
            char[] a = new char[str.length()-1];
            int n = 0;//记录删除一个字符后新数组的下标
            for (int m=0; m<arr.length; m++) {
                if (m!=index1) {
                    a[n]=arr[m];
                    n++;
                }
            }
            int x=0, y=a.length-1;
            while (x<y) {
                if (a[x]!=a[y]) {
                    flag1=0;
                }
                ++x; --y;
            }
        }
        if (flag0==0 && flag1==0)return false;
        return true;
    }

    public String render(String tpl, String name, int age) {
        char[] chars = tpl.toCharArray();
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<chars.length; i++) {
            if (chars[i]=='{') {
                if (flag!=0){
                    i+=6;
                    sb.append(age);
                }else {
                    i+=7;
                    flag++;
                    sb.append(name);
                }
            }else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
    /*
    * 递归求1~n的和
    * */
    public int getSum(int n) {
        if (n == 1) {
            return 1;
        }else {
            return n+getSum(n-1);
        }
    }
    class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    class Solution{
        public ArrayList<Integer> pre = new ArrayList<>();
        public ArrayList<Integer> middle = new ArrayList<>();
        public ArrayList<Integer> then = new ArrayList<>();

        public int[][] getOrder(TreeNode root) {
            preOrder(root);
            middleOrder(root);
            thenOrder(root);

            int[][] result = new int[3][pre.size()];
            result[0] = toIntArray(pre);
            result[1] = toIntArray(middle);
            result[2] = toIntArray(then);
            return result;
        }

        public int[] toIntArray(ArrayList<Integer> list) {
            if (list == null || list.size()<1) {
                return new int[0];
            }
            int[] result = new int[list.size()];
            for (int i=0; i<list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }

        public void preOrder(TreeNode root){
            if (root == null) {
                return;
            }
            pre.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }

        public void middleOrder(TreeNode root){
            if (root == null) {
                return;
            }
            middleOrder(root.left);
            middle.add(root.val);
            middleOrder(root.right);
        }

        public void thenOrder(TreeNode root){
            if (root == null) {
                return;
            }
            thenOrder(root.left);
            thenOrder(root.right);
            then.add(root.val);
        }
    }

    public int getIndex(int[] arr, int a) {// 二分查找
        int low = 0, high = arr.length-1, mid;
        while (low<high){
            mid = (low+high)/2;
            if (a == arr[mid]){
                return mid;
            }
            if (a > arr[mid]){
                low = mid+1;
            }else {
                high = mid -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws InterruptedException {
        Outter outter = new Outter();
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(outter.getIndex(arr,10));
    }

    public String longestCommonPrefix (String[] strs) {
        // write code here
        if (strs.length==0 || strs==null) {
            return "";
        }
        if(strs.length==1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(strs[0]);
        for(int i=1; i<strs.length; i++) {
            StringBuilder sbb = new StringBuilder();
            int j = 0;
            while(j<strs[i].length() && j< sb.length()){
                if(strs[i].charAt(j) == sb.charAt(j)) {
                    sbb.append(sb.charAt(j));
                    j++;
                }else{
                    break;
                }
            }
            sb = sbb;
        }
        return sb.toString();
    }

     static class solution {
        public boolean verifyPostorder(int[] postorder) {
            Stack<Integer> stack = new Stack<>();
            int root = Integer.MAX_VALUE;
            for (int i=postorder.length-1; i>=0; i--) {
                if (root<postorder[i]) return false;
                while (!stack.isEmpty() && stack.peek()>postorder[i]) {
                    root = stack.pop();
                }
                stack.add(postorder[i]);
            }
            return true;
        }

        public String addBinary(String a, String b) {
            char[] aa = a.toCharArray();
            char[] bb = b.toCharArray();
            int i = aa.length-1;
            int j = bb.length-1;
            StringBuilder sb = new StringBuilder();
            int ss = 0;
            while (i>=0 && j>=0) {
                if (ss==1){
                    if (aa[i]=='1' && bb[j]=='1'){
                        sb.append(1);
                        ss=1;
                    }else {
                        if (aa[i]=='0' && bb[j]=='0'){
                            sb.append(1);
                            ss=0;
                        }else {
                            sb.append(0);
                            ss=1;
                        }
                    }
                }else {
                    if (aa[i]=='1' && bb[j]=='1'){
                        sb.append(0);
                        ss=1;
                    }else {
                        sb.append((aa[i]-'0')+(bb[j]-'0'));
                    }
                }
                i--;
                j--;
            }
            if (i>-1){
                while (i>=0){
                    if (ss==1 && aa[i]=='1'){
                        sb.append(0);
                        ss=1;
                    }else {
                        sb.append(ss+(aa[i]-'0'));
                        ss=0;
                    }
                    i--;
                }
            }
            if (j>-1){
                while (j>=0){
                    if (ss==1 && bb[j]=='1'){
                        sb.append(0);
                        ss=1;
                    }else {
                        sb.append(ss+(bb[j]-'0'));
                        ss=0;
                    }
                    j--;
                }
            }
            if (ss==1) sb.append(ss);
            return sb.reverse().toString();
        }
    }
}
