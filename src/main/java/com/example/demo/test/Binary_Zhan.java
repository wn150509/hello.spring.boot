package com.example.demo.test;

import com.example.demo.entity.Node;

import java.util.Stack;

//二叉树遍历非递归
public class Binary_Zhan {

    public static Node init(){//初始化树
        Node H = new Node("H", null, null);
        Node K = new Node("k", null, null);
        Node D = new Node("D", null, null);
        Node G = new Node("G", H, K);
        Node C = new Node("C", D, null);
        Node F = new Node("F", G,null);
        Node B = new Node("B", null, C);
        Node E = new Node("E",null,F);
        Node A = new Node("A", B, E);
        return A;  //返回根节点
    }

    public static void printNode(Node node){//打印权值
        System.out.println(node.getData());
    }

    public static void preOrderStack(Node root){//先序
        Stack<Node> stack = new Stack<>();
        Node node = root;

        while (node!=null || stack.size()>0){
            if (node!=null){
                printNode(node);
                stack.push(node);
                node=node.getLeftNode();
            }else {
                node = stack.pop();
                node = node.getRight();
            }
        }
    }

    public static void OrderStack(Node root){//中序
        Stack<Node> stack = new Stack<>();
        Node node = root;

        while (node!=null || stack.size()>0){
            if (node!=null){
                stack.push(node);
                node=node.getLeftNode();
            }else {
                node = stack.pop();
                printNode(node);
                node = node.getRight();
            }
        }
    }

    public static void backOrderStack(Node root){
        Stack<Node> stack = new Stack<>();
        Stack<Node> outstack = new Stack<>();
        Node node = root;

        while (node!=null || stack.size()>0){
            if (node!=null){
                outstack.push(node);
                stack.push(node);
                node=node.getRight();
            }else {
                node = stack.pop();
                node = node.getLeftNode();
            }
        }

        while (outstack.size()>0){
            printNode(outstack.pop());
        }
    }

    public static void main(String[] args) {
        Node node = init();

        System.out.println("先序");
        preOrderStack(node);

        System.out.println("中序");
        OrderStack(node);

        System.out.println("后序");
        backOrderStack(node);
    }
}
