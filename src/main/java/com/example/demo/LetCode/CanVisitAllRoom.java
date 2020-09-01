package com.example.demo.LetCode;

import java.util.List;
/*
* 钥匙与房间：有N个房间，每个房间的编号为0~N-1的数，每个房间有0~N-1的钥匙编号对应可以打开的房间
* 用已有钥匙打开房间，直到所有房间都能打开返回true，否则返回false；默认0号房间可以打开
* 例子：输入[[1,3],[2],[4],[],[]]
*       输出：true
*       输入：[[1],[],[2],[],[4]]
*       输出：false
* 回溯法求解该问题
* */
public class CanVisitAllRoom {
    int n;      //未被打开的房间数量
    //回溯方法
    public void backTrack(List<List<Integer>> rooms,boolean[] opened,int roomID){
        List<Integer> keys = rooms.get(roomID);     //获取该房间钥匙组
        opened[roomID]=true;        //标记该房间被打开过
        n--;                    //未被打开房间数减一
        if (n==0){      //未被打开为零则直接返回
            return;
        }
        for (int i=0; i<keys.size(); i++){      //遍历该房间的钥匙
            if (!opened[keys.get(i)]){
                backTrack(rooms,opened,keys.get(i));//回溯该方法，进入该钥匙对应的房间
            }
        }
    }

    public  boolean canVisitAllRooms(List<List<Integer>> rooms){
        boolean[] opened = new boolean[rooms.size()];
        n=rooms.size();
        backTrack(rooms,opened,0);//从零号房间开始
        return n==0 ? true : false;
    }

    public static void main(String[] args) {

    }
}
