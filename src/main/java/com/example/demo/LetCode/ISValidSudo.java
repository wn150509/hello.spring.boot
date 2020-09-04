package com.example.demo.LetCode;

import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class ISValidSudo {
    public static boolean isValidSudo(char[][] board){
        //遍历行
        for (int i=0; i<board.length; i++){
            boolean[] flags=new boolean[board[i].length];
            for (int j=0; j<board[i].length; j++){
                char a = board[i][j];
                if (a!='.'){
                    if (flags[a-'1']){
                        return false;
                    }else {
                        flags[a-'1']=true;
                    }
                }
            }
        }
        //遍历列
        for (int i=0; i<board.length; i++){
            boolean[] flags=new boolean[board.length];
            for (int j=0; j<board[i].length; j++){
                char a = board[j][i];
                if (a!='.'){
                    if (flags[a-'1']){
                        return false;
                    }else {
                        flags[a-'1']=true;
                    }
                }
            }
        }
        //遍历3x3
        for (int box=0; box<board.length; box++){
            boolean[] flags=new boolean[board.length];
            for (int i=0; i<3; i++){
                for (int j=0; j<3; j++){
                    char a = board[i+3*(box/3)][j+3*(box%3)];
                    if (a!='.'){
                        if (flags[a-'1']){
                            return false;
                        }else {
                            flags[a-'1']=true;
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println();
    }
}
