package com.jack.a03_data_structure.a03_queue;

/**
 * @创建者 Jack
 * @创建时间 2021/4/15 10:30
 * @描述
 */
public class QueueClient {

    public static void main(String[] args){
        MyQueue myQueue = new MyQueue(10);
        try {
            myQueue.enQueue(1);
            myQueue.enQueue(2);
            myQueue.enQueue(3);
            myQueue.enQueue(4);
            myQueue.enQueue(5);
            myQueue.enQueue(6);
            myQueue.enQueue(7);
            myQueue.enQueue(8);
            myQueue.enQueue(9);
//            myQueue.enQueue(10);

            myQueue.printAll();

            System.out.println(" 出队 " + myQueue.deQueue());
            System.out.println(" 出队 " + myQueue.deQueue());
            System.out.println(" 出队 " + myQueue.deQueue());
            System.out.println(" 出队 " + myQueue.deQueue());
            System.out.println(" 出队 " + myQueue.deQueue());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyQueue{
        private int[] array;
        private int front;
        private int rear;

        public MyQueue(int capacity) {
            array = new int[capacity];
        }

        //入队
        public void enQueue(int element) throws Exception {
            if((rear + 1) % array.length == front){
                throw new Exception("队列已满");
            }

            //入队
            array[rear] = element;
            rear = (rear + 1) % array.length;
        }

        //出队
        public int deQueue() throws Exception {
            if(rear == front){
                throw new Exception("队列已空");
            }

            int element = array[front];
            front = (front + 1) % array.length;
            return element;
        }

        //打印队列数据
        public void printAll(){
            System.out.println(" ==================================== ");

            for(int i = front;i != rear;i = (i + 1) % array.length){
                System.out.println(" 序号 " + i + "   " + array[i]);
            }
        }

    }

}
