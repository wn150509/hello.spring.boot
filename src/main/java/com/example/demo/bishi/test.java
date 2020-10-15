package com.example.demo.bishi;

import javax.persistence.criteria.CriteriaBuilder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class test {
    public static List<String> test(String[] strs, int n, String s){
        StringBuilder str= new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int i=0; i<s.length(); i++){       //找出给定的字符串的特征值
            if ((s.charAt(i)-'0')<n){
                str.append(s.charAt(i));
            }
        }
        for (int i=0; i<strs.length; i++){
            StringBuilder sb= new StringBuilder();
            for (int j=0; j<strs[i].length(); j++){
                if ((strs[i].charAt(j)-'0')<n){
                    sb.append(strs[i].charAt(j));
                }
            }
            if (sb.equals(str)||sb.toString().contains(String.valueOf(str))){
                list.add(strs[i]);
            }
        }
        return list;
    }

    public static int getNum(String s){
        int n = 0, d=0;
        char sign = '+';
        Stack<Integer> nums = new Stack<>();
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)>='0'){      //利用加减乘除和空格的ASCII码都小于‘0’
                d = d*10 +s.charAt(i)-'0';
            }
            if ((s.charAt(i)<'0'&&s.charAt(i)!=' ') || i==s.length()-1){
                if (sign=='+'){
                    nums.push(d);
                }else if (sign=='-'){
                    nums.push(-d);
                }else if (sign =='*' || sign =='/'){
                    int temp = sign == '*' ? nums.pop()*d : nums.pop()/d;
                    nums.push(temp);
                }
                sign = s.charAt(i);
                d = 0;
            }
        }
        for (int t : nums){
            n += t;
        }
        return n;
    }

    public static int getDay(int y1, int m1, int d1, int y2, int m2, int d2){
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        String time1 = String.valueOf(y1)+"-"+String.valueOf(m1)+"-"+String.valueOf(d1);
        String time2 = String.valueOf(y2)+"-"+String.valueOf(m2)+"-"+String.valueOf(d2);
        try {
            calendar1.setTime(sdf.parse(time1));
            calendar2.setTime(sdf.parse(time2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int count = 0;
        while (calendar1.compareTo(calendar2)<=0){
            if (calendar1.get(Calendar.DAY_OF_WEEK)!=7 && calendar1.get(Calendar.DAY_OF_WEEK)!=1){
                count++;
            }
            calendar1.add(Calendar.DAY_OF_MONTH,1);
        }
        return count;
    }

    public static int reorder (int[] prices){
        int count = 0;
//        List<Integer>list = new ArrayList<>();
        if (prices.length==1){
            count=1;
        }
        if (prices.length==2){
            if (prices[0]==prices[0]){
                return count;
            }else {
                count=1;
            }
        }
        Arrays.sort(prices);
        if (prices.length>2){
            count=prices.length-2;
        }
        for (int i=1; i<prices.length-1; i++){

        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//N个糖
        int tmp=n,count=0;
        int k=1;
        for (int i=k; i<=n; i++){
            count=i+count;
            if ((tmp-=count)==(i+1)){
                int a=0;
                while (n>0){
                   n-=i;
                   a++;
                   i--;
                }
                System.out.println(a);
            }else if ((tmp-=count)>(i+1)){
                continue;
            }else if ((tmp-=count)<(i+1)){
                i=k+1;
            }
        }
    }
}
