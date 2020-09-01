package com.example.demo.test;

import org.hibernate.event.spi.SaveOrUpdateEvent;

import java.util.*;

public class demo {
    public static String ss(String s){
        char[] arr=s.toCharArray();//将字符串转为字符数组
        Map<String, Integer> hashMap=new HashMap<>();//新建Hashmap  K:String---V:Integer
        for (int a=0;a<arr.length;a++){//遍历字符数组
            int value=0;
            if ((arr[a]<='z'&&arr[a]>='a')||(arr[a]>='A'&&arr[a]<='Z')
                    ||(arr[a]<='9'&&arr[a]>='0')||arr[a]==' '){ //此外字符不计数，不加入hashmap中
                if (hashMap.get(String.valueOf(arr[a]))!=null){ //已插入该字符
                    value=hashMap.get(String.valueOf(arr[a]));  //获取该字符当前数量
                }
                hashMap.put(String.valueOf(arr[a]),value+1);    //字符数量加一
            }
        }
        //根据值降序（双条件排序）
        List<Map.Entry<String,Integer>> list=new ArrayList<Map.Entry<String,Integer>>(hashMap.entrySet());//将hashMap转为list
        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>() {    //使用collections.sort方法
            @Override                       //重写了比较方法
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int i =o2.getValue()-o1.getValue();     //比较数量，数量多的排在前列
                if (i==0){                  //若数量一致，将字符的ASCII码作比较，数值大的排在前列
                    return (int)o2.getKey().charAt(0)-(int)o1.getKey().charAt(0);
                }
                return i;
            }
        });
        StringBuilder sb=new StringBuilder();           //新建StringBuilder对象，传输快
        for (Map.Entry<String, Integer> map:list) {     //将排序完的依次append到sb对象上
            sb.append(map.getKey());
        }
        s=String.valueOf(sb);
        return s;       //返回最终的字符串
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer>maxlist=new ArrayList<>();
        while (in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();

            int[] arr = new int[n];
            Scanner nn = new Scanner(System.in);
            int nm=n;
            while (n>0){
                arr[nm-n]=nn.nextInt();
                n--;
            }

            while (m>0){
                Scanner mm = new Scanner(System.in);
                String mm1 = mm.next();
                String mm2 = mm.next();
                String mm3 = mm.next();
                if (mm1.equals("Q")){
                    int mmax=0;
                    for (int i=Integer.parseInt(mm2)-1;i<Integer.parseInt(mm3);i++){
                        mmax=Math.max(mmax,arr[i]);
                    }
                    System.out.println("打印最大值："+mmax);
                    maxlist.add(mmax);
                }else {
                    arr[Integer.parseInt(mm2)-1]=Integer.parseInt(mm3);
                }
                m--;
                System.out.println("打印m:"+m);
            }
            break;
        }
        System.out.println(maxlist);
//        String a = "aadecrvees";
//
//        Set set = new LinkedHashSet();
//        char[] chars = a.toCharArray();
//        for(int i = 0 ; i < a.length() ; i ++){
//            set.add(chars[i]);
//        }
//        StringBuffer ss=new StringBuffer();
//        for (Object sss:set) {
//            ss.append(sss);
//        }
//        System.out.println(ss);
//        System.out.println(set.toString());
    }
}
