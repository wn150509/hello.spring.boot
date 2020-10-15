package com.example.demo.LetCode;

import java.util.HashMap;
import java.util.LinkedList;

/*
* LRU算法（最近最远算法）
*
* */
public class LRU {
    private LinkedList<Integer> linkedList;
    private HashMap<Integer,Integer> map;

    private int max_size;
    private int cur_size=0;

    public LRU(int cap){
        linkedList=new LinkedList<>();
        map=new HashMap<>();
        max_size=cap;
    }

    public int get(int key){        //get方法
        if (!map.containsKey(key)){
            return -1;
        }                           //不存在，返回 -1
        int val = map.get(key);     //存在 ，返回value值
        Object o = key;
        linkedList.remove(o);       //删除链表里key值
        linkedList.addLast(key);    //将该值放入尾部，更新使用情况
        return val;
    }

    public void put(int key , int value){
        if (map.containsKey(key)){
            map.put(key,value);
            Object o = key;
            linkedList.remove(o);
            linkedList.addLast(key);
        }else {
            map.put(key,value);
            linkedList.addLast(key);
            cur_size++;
            if (cur_size>max_size){
                int tmp = linkedList.removeFirst();
                map.remove(tmp);
                cur_size--;
            }
        }
    }
}
