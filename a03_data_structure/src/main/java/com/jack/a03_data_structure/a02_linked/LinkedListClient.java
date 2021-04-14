package com.jack.a03_data_structure.a02_linked;

/**
 * @创建者 Jack
 * @创建时间 2021/4/14 10:03
 * @描述
 */
public class LinkedListClient {

    //头节点
    private static Node head;

    //尾节点
    private static Node last;

    //链表长度
    private static int size;

    public static void main(String[] args){

        //增
        insert(1,0);
        insert(2,1);
        insert(3,2);
        insert(4,3);
        insert(5,4);
        insert(6,5);
        printAll("增");


        //查
        int value = query(1).val;
        System.out.println();
        System.out.println("查询 ============= ");
        System.out.println("value = " + value);

        //改
        update(0,11);
        update(5,33);
        printAll("改");

        //删
        delete(0);
        delete(3);
        printAll("删");

    }

    private static void delete(int index) {

        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }

        if(index == 0){
            //删除头部
            head = query(index + 1);
        }else if(index == size - 1){
            //删除尾部
            last = query(index - 1);
        }else {
            //删除中间
            Node preNode = query(index - 1);
            preNode.next = query(index + 1);
        }

        size--;
    }

    private static void update(int index,int val) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }

        Node targetNode = query(index);
        targetNode.val = val;
    }

    /**
     * 查找指定索引的节点
     */
    private static Node query(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }

        //从头节点开始查找，直到index位置
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    /**
     * 尾部增加
     * 中间增加
     * 头部增加
     * @param val
     * @param index
     */
    private static void insert(int val,int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }

        Node insertNode = new Node(val);
        if(size == 0){
            //空链表
            head = insertNode;
            last = insertNode;
        }else if(index == 0){
            //头部插入
            insertNode.next = head;
            head = insertNode;
        }else if(index == size){
            //尾部插入
            last.next = insertNode;
            last = insertNode;
        }else{
            //中间插入
            //需要借助查找方法
            Node preNode = query(index-1);
            Node indexNode = query(index);
            preNode.next = indexNode;
            indexNode.next = indexNode;
        }

        size++;
    }

    //遍历操作
    private static void printAll(String printWay){
        System.out.println(printWay + "===================================");
        for (int i = 0; i < size; i++) {
            System.out.println("i = " + (i + 1) + ",value = " + query(i).val);
        }
    }


    static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }

}
