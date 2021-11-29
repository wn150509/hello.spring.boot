package com.example.demo.test;

public class LinkedListTest{

    class Node{
        private Node pro;
        private Object obj;
        private Node next;

        public Node() {
        }

        public Node(Node pro, Object obj, Node next) {
            this.pro = pro;
            this.obj = obj;
            this.next = next;
        }

        public Node getPro() {
            return pro;
        }

        public Object getObj() {
            return obj;
        }

        public Node getNext() {
            return next;
        }

        public void setPro(Node pro) {
            this.pro = pro;
        }

        public void setObj(Object obj) {
            this.obj = obj;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void add(Object obj){
        Node node = new Node();
        //是否为第一个节点

        if (first == null){
            node.setPro(null);
            node.setObj(obj);
            node.setNext(null);

            first = node;
            last = node;
            size++;
        } else {
            node.setPro(last);
            node.setObj(obj);
            node.setNext(null);

            last.setNext(node);
            last = node;
            size++;
        }
    }

    public Boolean remove(Object obj) {
        if (first == null){
            return false;
        }
        Node node = first;

        for (int i=0; i<size; i++) {
            if (node.getObj().equals(obj)){
                Node pro = node.getPro();
                Node next = node.getNext();
                node = null;

                if (pro != null && next != null) {
                    next.pro = pro;
                    pro.next = next;
                }else if (pro == null && next != null){
                    first = next;
                    next.pro = null;
                }else if (pro != null && next == null) {
                    last = pro;
                    pro.next = null;
                }
                size--;
                return true;
            }else {
                node = node.getNext();
            }
        }
        return false;
    }

    public Object get(int index){
        Node node = first;
        if (index<0 || index>size){
            return null;
        }else {
            for (int i=0; i<size; i++){
                if (i == index) {
                    return node.getObj();
                }else {
                    node = node.getNext();
                }
            }
        }
        return null;
    }

    public void add(int index, Object obj){
        Node newNode = new Node();
        if (size == 0){
            newNode.setNext(null);
            newNode.setObj(obj);
            newNode.setPro(null);

            first = newNode;
            last = newNode;
            size++;
        }else {
            Node node = first;
            if (index == 0) {
               newNode.setPro(null);
               newNode.setObj(obj);
               newNode.setNext(node);

               node.setPro(newNode);
               first = newNode;
               size++;
            }else if(index == size){
                newNode.setPro(node);
                newNode.setObj(obj);
                newNode.setNext(null);

                node.setNext(newNode);
                last = newNode;
                size++;
            }else if (index < size && index>0){
                Node node1 = first;
                for (int i=1; i<size; i++) {
                    if (i==index) {

                    }
                }
            }
        }
    }

}
