package com.example.demo.entity;

public class Node {
    private String data;
    private Node leftNode;
    private Node right;

    public Node(String data, Node leftNode, Node right) {
        this.data = data;
        this.leftNode = leftNode;
        this.right = right;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
