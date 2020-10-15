package com.example.demo.bishi;

import java.util.Scanner;

public class HuaWei2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//行
        int m = sc.nextInt();//列
        int ans = 0;        //步数
        double pD=0.0, pR=0.0, pS=0.0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                double pd=3*j, pr=3*j+1, ps=3*j+2;
                pD=3*j; pR=3*j+1; pS=3*j+2;
                if (j!=m-1){
                    ans++;
                }
                if (ps==1.0){
                    System.out.println(0.0);
                    return;
                }
                if (pd==1.0){
                    break;
                }
                if (pr==1.0){
                    continue;
                }
            }
        }
    }
}
