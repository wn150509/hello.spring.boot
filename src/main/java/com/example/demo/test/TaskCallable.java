package com.example.demo.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.Callable;

public class TaskCallable implements Callable<Object> {
    private int taskNum;

    public TaskCallable(int taskNum) {
        this.taskNum = taskNum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test1();
    }

    //用Executors.newFixedThreadPool创建线程池
    private static void test1() throws InterruptedException, ExecutionException {
        System.out.println("------运行开始------");
        Date date1 = new Date();
        int taskSize = 5;
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        List<Future> list = new ArrayList<Future>();

        for (int i=0; i<taskSize; i++){
            Callable callable = new TaskCallable(i);
            Future future = pool.submit(callable);
            list.add(future);
        }

        pool.shutdown();

        for (Future f:list) {
            System.out.println(">>> 运行程序："+ f.get().toString());
        }

        Date date2 = new Date();
        System.out.println("执行结束，用时："+(date2.getTime()-date1.getTime())+"毫秒");
    }

    @Override
    public Object call() throws Exception {
        System.out.println(">>>"+taskNum+"任务启动");
        Date datestmp1 = new Date();
        Thread.sleep(1000);
        Date datestmp2 = new Date();
        long time = datestmp2.getTime()-datestmp1.getTime();
        System.out.println(">>>"+taskNum+"任务终止");
        return taskNum+"任务返回运行结果，当前时间："+time;
    }
}
