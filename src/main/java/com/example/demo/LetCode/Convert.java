package com.example.demo.LetCode;
/*
* Z字形变换
* 例子：
*       输入：“LEETCODEISHIRING”  3
*       输出："LCIRETOESIIGEDHN"
*       解释：L   C   I   R
*            E T O E S I I G
*            E   D   H   N
*   题解：找规律
* */
public class Convert {
    public static String convert(String s , int rowNum){
        if(rowNum==1||s==" ") return s;
        char[] arr = s.toCharArray();       //原字符数组
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<rowNum; i++){
            for (int j=i; j<arr.length; j+=(rowNum-1)*2){
                sb.append(arr[j]);
                if (i>0&&i<rowNum-1){
                    int sec = j+2*(rowNum-i-1);
                    if (sec<arr.length){
                        sb.append(arr[sec]);
                    }
                }
            }
        }
        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING",3));
    }
}
