package com.example.demo.bishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YinTaiLai {
    static class Sheep{
        public int age = 1;
    }
    public static class life{
        public static int getSheep(int n,int[] arr,int dead){
            ArrayList<Sheep>list=new ArrayList<>();
            list.add(new Sheep());

            List<Sheep>addSheep=new ArrayList<>();//添加
            List<Sheep>delSheep=new ArrayList<>();//死亡
            for (int i=0; i<n; i++){
                for (Sheep sheep : list){
                    for (int j=0; j<arr.length; j++){
                        if (sheep.age==arr[j]){
                            Sheep tmp = new Sheep();
                            tmp.age++;
                            addSheep.add(tmp);
                        }
                    }
                    if (sheep.age==dead){
                        delSheep.add(sheep);
                    }
                    sheep.age++;
                }
                list.addAll(addSheep);
                list.removeAll(delSheep);
                addSheep.clear();
                delSheep.clear();//清空元素
            }
            return list.size();//获取羊圈总数
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int[] arr= new int[2];
            for (int i=0; i<2; i++){
                arr[i]= sc.nextInt();
            }
            int dead = sc.nextInt();
            int year = sc.nextInt();
            System.out.println(getSheep(year,arr,dead));
        }
    }
}
