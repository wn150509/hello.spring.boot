package com.example.demo.test;

import com.example.demo.entity.Node;
//递归方法实现
public class BinaryTree_DiGui {

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
        System.out.print(node.getData());
    }

    public static void preOrder(Node node){//先序
        printNode(node);
        if (node.getLeftNode()!=null){
            preOrder(node.getLeftNode());
        }
        if (node.getRight()!=null){
            preOrder(node.getRight());
        }
    }

    public static void Order(Node node){//中序
        if (node.getLeftNode()!=null){
            Order(node.getLeftNode());
        }
        printNode(node);
        if (node.getRight()!=null){
            Order(node.getRight());
        }
    }

    public static void backOrder(Node node){//后序
        if (node.getLeftNode()!=null){
            backOrder(node.getLeftNode());
        }
        if (node.getRight()!=null){
            backOrder(node.getRight());
        }
        printNode(node);
    }

    public static void main(String[] args) {
        Node node = init();//初始化

        System.out.println("先序");
        preOrder(node);

        System.out.println("中序");
        Order(node);

        System.out.println("后序");
        backOrder(node);
    }
}
