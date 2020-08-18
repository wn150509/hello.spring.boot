package com.example.demo.entity;

import com.fasterxml.jackson.databind.util.LinkedNode;

import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrintLinkedList {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static void print(ListNode head){
        Stack<ListNode>stack=new Stack<>();
        ListNode temp=head;
        while (temp!=null){
            stack.push(temp);
            temp=temp.next;
        }
        int[] arr=new int[stack.size()];
        for (int i=0;i<arr.length;i++){
            arr[i]= stack.pop().val;
            System.out.println(stack.pop().val);
        }
    }

    public static int countDigitOne(int n) {
        int count=0;
        int index=0;
        for (int i=1;i<=n;i++){
            String s = String.valueOf(i);
            while ((index = s.indexOf("1", index)) != -1) {
                index = index + "1".length();
                count++;
            }
//            Pattern p=Pattern.compile("1");
//            Matcher m=p.matcher(s);
//            while (m.find()){
//                count++;
//            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(100));
    }
}
