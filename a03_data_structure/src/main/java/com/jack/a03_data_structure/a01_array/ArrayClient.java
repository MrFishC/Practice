package com.jack.a03_data_structure.a01_array;

/**
 * @创建者 Jack
 * @创建时间 2021/4/13 10:05
 * @描述 数组的操作
 */
public class ArrayClient {

    public static void main(String[] args){
        //数据结构无非增删改查
        int[] array = new int[]{9,7,2,3,1,2,5,4};

        MyArray myArray = new MyArray(5);

        query(array);
        update(array);

        //队尾插入
        insert("队尾插入",myArray,1,0);
        insert("队尾插入",myArray,2,1);
        insert("队尾插入",myArray,3,2);
        insert("队尾插入",myArray,4,3);

        //中间插入
        insert("中间插入",myArray,9,3);

        //扩容处理
        insert("扩容插入",myArray,11,2);

        delete("删除操作",myArray,2);
    }

    /**
     * 删除的操作跟扩容的操作相反
     *  时间复杂度   O(N)
     *  空间复杂度   O(1)        对于时间和空间复杂度感觉不是很到位，故不太肯定 哈哈
     */
    private static void delete(String functionName, MyArray myArray, int index) {
        //判断index是否越界
        if(index > myArray.size || index < 0){
            throw new IndexOutOfBoundsException("超出数组实际元素范围！");
        }

        //从右向左循环
        for(int i = myArray.size - 1;i >= index;i--){
            myArray.array[i] = myArray.array[i - 1];
        }

        myArray.size--;
        printArray(functionName + " 删除位置为 " + index,myArray.array);
    }

    /**
     * 插入分3种情况
     *  1.数组长度足够，队尾插入（等同于update操作）
     *  2.数组长度足够，中间插入
     *  2.超范围插入(扩容处理)
     *
     *  时间复杂度   O(N)
     *  空间复杂度   O(1)        对于时间和空间复杂度感觉不是很到位，故不太肯定 哈哈
     */
    private static void insert(String functionName,MyArray myArray,int element,int index) {

        //判断index是否越界
        if(index > myArray.size || index < 0){
            throw new IndexOutOfBoundsException("超出数组实际元素范围！");
        }

        //add：判断是否需要扩容处理
        if(myArray.size >= myArray.array.length){
            myArray.array = resize(myArray);
        }

        //从右向左循环
        for(int i = myArray.size - 1;i >= index;i--){
            myArray.array[i + 1] = myArray.array[i];
        }

        myArray.array[index] = element;
        myArray.size++;

        printArray(functionName + " 插入位置为 " + index,myArray.array);
    }

    private static int[] resize(MyArray myArray){
        int[] newArray = new int[myArray.array.length * 2];
        //从旧数组复制到新数组
        System.arraycopy(myArray.array, 0, newArray, 0, myArray.array.length);
        return newArray;
    }

    private static void update(int[] array) {
        int value = array[array.length - 1];
        array[array.length - 1] = value + 10;
        System.out.println("修改 最后一个元素的值 " + array[array.length - 1]);
    }

    private static void query(int[] array) {
        System.out.println("查询 最后一个元素的值 " + array[array.length - 1]);
    }

    //遍历数组
    private static void printArray(String functionName,int[] array){

        System.out.println(functionName + " =========遍历数组========= ");

        for (int i = 0; i < array.length; i++) {
            System.out.println(" 索引 = " + i + ",value = " + array[i]);
        }
    }

    static class MyArray{
        public int size;               //数组中实际元素的数量
        public int[] array;           //数组初始化的长度
        public MyArray(int capacity){
            array = new int[capacity];
            size = 0;
        }
    }

}
