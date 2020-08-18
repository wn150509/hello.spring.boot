package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		int i = 1;
		while (i <= 10) {
			if (i == 5) {
				//i++;
				System.out.println("死循环");
				continue;
			}
			System.out.println(i);
			i++;
		}
	}

	static class Solution {
		public static void main(String[] args) {
//			Arrays.sort(arr);
			String s="abcd";
			String []s1={"ab","ec"};
			String[] s2={"eee","ffff"};
			int[] index={0,2};
//			System.out.println(s.replace(s1[0],s2[0]));
//			System.out.println(replace(s,s1,s2,index));
            String ss1="abc";
            String ss2="a";
            String ss3=ss2+"bc";

            System.out.println(ss1==ss3.intern());
		}
		public static String replace(String s,String[] s1,String[] s2,int[] index){
			HashMap<Integer,String[]>map=new HashMap<>();
			for (int i=0;i<index.length;i++){
				String[] strings={s1[i],s2[i]};
				map.put(index[i],strings);
			}
			List<String>list=new ArrayList<>();
			Arrays.sort(index);
			int start=0;//起始位置
			for(int i=0;i<index.length;i++){
				String source=map.get(index[i])[0];
				String target=map.get(index[i])[1];
				int in=s.indexOf(source,index[i]);
				if (in==index[i]){
					list.add(s.substring(start,in));
					list.add(target);
					start=in+source.length();
				}
			}
			list.add(s.substring(start));
			StringBuilder stringBuilder=new StringBuilder();
			for (int i=0;i<list.size();i++){
				stringBuilder.append(list.get(i));
			}
			return stringBuilder.toString();
		}
		public static String ss(String s,String source,String target){
			return s.replace(source,target);
		}
		public  static int vivo(int n){
		    if (n<=9) return n;
		    for (int i=9;i>1;i--){
		        if (n%i==0) return vivo(n/i)*10+i;
            }
		    return -1;
        }
		public static int res(int n){
		    int count=1;//第一天产量
            int incr=2;//第二天开始增量=2
            for (int i=2;i<=n;){
                int j=0;
                while (j<incr&&i<=n){
                    count+=incr;
                    i++;
                    j++;
                }
                incr++;
            }
		    int res=0;
		    for (int i=1;n>0;i++){
		        res+=i*Math.min(i,n);
		        n-=i;
            }
		    return count;
        }
		public static int findKthLargest(int[] nums, int k) {
			return quart(nums,0,nums.length-1)[k-1];
		}
		public static int[] quart(int[] arr,int s,int e){
			int i=s;
			int j=e;
			int p=arr[s];
			while(i<j){
				while((i<j)&&(p>arr[j])){
					j--;
				}
				while((i<j)&&(p<arr[i])){
					i++;
				}
				if((arr[i]==arr[j])&&(i<j)){
					i++;
				}else{
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
//					exchange(arr[i],arr[j]);
				}
			}
			if(i-1>s) arr=quart(arr,s,i-1);
			if(j+1<e) arr=quart(arr,j+1,e);
			return (arr);
		}
		public static void exchange(int a,int b){
			int c=0;
			if(a<b){
				c=a;
				a=b;
				b=c;
			}
		}
	}

}
