package com.example.demo.test;

import com.fasterxml.jackson.databind.util.LinkedNode;
import org.springframework.util.ObjectUtils;

import java.util.*;

public class LinkedDemo {
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public static boolean get(String s){
        HashMap<Character,Character> map=new HashMap<>();
        map.put(')','(');map.put(']','[');map.put('}','{');
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            char a =s.charAt(i);
            if (map.containsKey(a)){
                char top = stack.empty() ? '#' : stack.pop();
                if (top != map.get(a)){
                    return false;
                }
            }else {
                stack.push(a);
            }
        }
        return stack.empty();
  }

  public static ListNode getNewLink(ListNode l1,ListNode l2){
        if (l1==null) return l2;
        if (l2==null) return l1;

        ListNode prev = new ListNode(-1);

        ListNode p = prev;
        while (l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                p.next=l1;
                l1=l1.next;
            }else {
                p.next=l2;
                l2=l2.next;
            }
            p=p.next;
        }
        p.next= l1==null ? l2 : l1;
        return prev.next;
  }

  public static int firstUniqChar(String s){
      char[] a =s.toCharArray();
      for (int i=0;i<a.length;i++){
          for (int j=i+1;j<a.length;j++){
              if (a[i]==a[j]){
                  break;
              }
              if (j==a.length-1){
                  return i;
              }
          }
      }
      return -1;
  }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {1,2,3,4,5};
        String aa = "a";
        String bb = "a";
        System.out.println(ObjectUtils.nullSafeEquals(aa,bb));
     }
}
