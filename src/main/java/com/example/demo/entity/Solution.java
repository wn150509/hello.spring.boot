package com.example.demo.entity;

import java.util.*;

public class Solution {
    public static  int ss(String[] strings,String str){
        Set<String>set=sort(strings);

        for (int i=set.size()-1;i>=0;i--){
            if (str.contains(set.toArray()[i].toString())){
                String[] split = str.split(set.toArray()[i].toString());
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < split.length; j++) {
                    // 将切割后的结果拼接起来
                    builder.append(split[j]);
                }
                str= String.valueOf(builder);
                System.out.println(str);
            }
        }
        return str.length();
    }

    public static Set<String>sort(String[] strings){
        Set<String> set=new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int num=new Integer(o1.length()).compareTo(new Integer(o2.length()));
                if (num==0){
                    return o1.compareTo(o2);
                }
                return num;
            }
        });
        for (String s:strings) {
            set.add(s);
        }
        return set;
    }

    public int respace(String[] arr,String s){
        Set<String> set=new HashSet<>(Arrays.asList(arr));
        int n=s.length(),count=0;
        int[] dp=new int[n+1];
        for (int i=1;i<=n;i++){
            dp[i]=dp[i-1]+1;

            for (int j=0;j<i;j++){
                if (set.contains(s.substring(j,i))){
                    dp[i]=Math.min(i,j);
                    System.out.println(s.substring(j,i));
                    count+=s.substring(j,i).length();
                }
            }
        }
        return n-count;
    }

    public static int  fib(int n){
        if(n==0||n==1){
            return n;
        }

        int[] dp =new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i] =dp[i-1]+dp[i-2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }
    public static void main(String[] args) {
//        String[] arr={"looked","just","like","her","brother"};
//        String s="jesslookedjustliketimherbrother";
//        System.out.println(espace(arr,s));
        System.out.println(fib(10));
    }

    public static int espace(String[] dictionary, String sentence) {
        // 构建字典树
        Trie trie = new Trie();
        for (String word: dictionary) {
            trie.insert(word);
        }
        // 状态转移，dp[i] 表示字符串的前 i 个字符的最少未匹配数
        int n = sentence.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int idx: trie.search(sentence, i - 1)) {
                dp[i] = Math.min(dp[i], dp[idx]);
            }
        }
        return dp[n];
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // 将单词倒序插入字典树
        public void insert(String word) {
            TrieNode cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                int c = word.charAt(i) - 'a';
                if (cur.children[c] == null) {
                    cur.children[c] = new TrieNode();
                }
                cur = cur.children[c];
            }
            cur.isWord = true;
        }

        // 找到 sentence 中以 endPos 为结尾的单词，返回这些单词的开头下标。
        public List<Integer> search(String sentence, int endPos) {
            List<Integer> indices = new ArrayList<>();
            TrieNode cur = root;
            for (int i = endPos; i >= 0; i--) {
                int c = sentence.charAt(i) - 'a';
                if (cur.children[c] == null) {
                    break;
                }
                cur = cur.children[c];
                if (cur.isWord) {
                    indices.add(i);
                }
            }
            return indices;
        }
    }

    static class  TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[26];

        public TrieNode() {}
    }
}
