package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HUAWEI {
    //一行字符串，计算最后一个单词的长度，单词以空格隔开
    public static int StrLen(String s){
        char[] arr= s.toCharArray();
        int count=0;
        for (int i=arr.length-1;i>=0;i--){
            if (arr[i]!=' '){
                count++;
            }else{
                break;
            }
        }
        System.out.println(count);
        return count;
    }

    public static boolean choose(int n){
        boolean flag=false;
        if (n%10==7&&(n/10)%2!=0){
            flag=true;
        }
        return flag;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [][] arr = null;
        int count=0;
        List<int[]>list=new ArrayList<>();
        while (sc.hasNext()){
            int M = sc.nextInt();//M行数
            int N = sc.nextInt();//N列数
            arr=new int[M][N];
            int row =0,col =0;//行列指针
            int xLeft = 0;//左边界
            int xRight= arr[0].length-1;//右边界
            int yup=0;//上边界
            int ydown=arr.length-1;//下边界
            int totalCount=arr.length*arr[0].length;
            int direction = 0;//遍历方向 0：从左往右 1：从上往下 2：从右往左 3：从下往上
            while (count<totalCount){
                if (direction==0){
                    int[]aa=new int[2];
                    for (col=xLeft;col<=xRight;col++,count++){
                        if (choose(count)){
                            aa[0]=row;
                            aa[1]=col-1;
                            list.add(aa);
                        }
                    }
                    yup+=1;//上边界
                    direction=1;//变换方向
                    col--;
                }else if (direction==1){
                    int[]aa=new int[2];
                    for (row = yup;row<=ydown;row++,count++){
                        if (choose(count)){
                            aa[0]=row-1;
                            aa[1]=col;
                            list.add(aa);
                        }
                    }
                    xRight-=1;
                    direction=2;//变换方向
                }else if (direction==2){
                    int[]aa=new int[2];
                    for (col=xRight;col>=xLeft;col--,count++){
                        if (choose(count)){
                            aa[0]=row-1;
                            aa[1]=col+1;
                            list.add(aa);
                        }
                    }
                    ydown-=1;
                    direction=3;//变换方向
                    col++;
                }else if(direction==3){
                    int[]aa=new int[2];
                    for (row = ydown;row>=yup;row--,count++){
                        if (choose(count)){
                            aa[0]=row;
                            aa[1]=col-1;
                            list.add(aa);
                        }
                    }
                    xLeft+=1;
                    direction=0;
                    row++;
                }
            }
            break;
        }
        for (int[] a:list) {
            System.out.println(a[0]+":"+a[1]);
        }
//        System.out.println();
    }
//    public static void main(String[] args) {
//        StrLen("XSUWHQ");
//    }
}
