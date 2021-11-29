package com.example.demo.test;

import java.util.concurrent.atomic.AtomicBoolean;

public class CAStest extends abstractclass implements Runnable{
    private static AtomicBoolean flag = new AtomicBoolean(true);

    public static void main(String[] args) {
        CAStest caStest = new CAStest();
//        Thread thread0 = new Thread(caStest);
//        Thread thread1 = new Thread(caStest);
//        thread0.start();
//        thread1.start();
//        abstractclass a = new CAStest();
        int[] arr = {72,6,57,88,60,42,83,73,48,85};
        for (int a:caStest.getQ(arr,0,arr.length-1)) {
            System.out.print(a+" ");
        }
    }
    public int[] getQ(int[] arr, int l, int r){
        if (l<r) {
            int i = k(arr,l,r);
            getQ(arr,l,i-1);
            getQ(arr,i+1,r);
        }
        return arr;
    }
    public int k(int[] arr, int l, int r) {
        int temp = arr[l];
        while (l<r) {
            while (l<r && arr[r]>=temp) {
                r--;
            }
            arr[l] = arr[r];
            while (l<r && arr[l]<=temp) {
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = temp;
        return l;
    }
    @Override
    public void run() {
        System.out.println("thread:"+Thread.currentThread().getName()+"flag"+flag.get());
        if (flag.compareAndSet(true,false)) {
            System.out.println("当前线程"+Thread.currentThread().getName()+"flag:"+flag.get());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag.set(true);
        }else {
            System.out.println("重试机制："+Thread.currentThread().getName()+"flag:"+flag.get());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            run();
        }
    }

    @Override
    void aa() {

    }
}
