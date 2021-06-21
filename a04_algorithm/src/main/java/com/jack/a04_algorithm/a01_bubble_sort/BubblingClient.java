package com.jack.a04_algorithm.a01_bubble_sort;

import java.util.Arrays;

/**
 * @创建者 Jack
 * @创建时间 2021/4/25 10:33
 * @描述
 */
public class BubblingClient {

    public static void main(String[] arg){
        int[] array = new int[]{1,3,5,6,2,4,8,9,10,7};



//        bubbleSort(array);
        bubbleSort2(array);

        System.out.println(" ============= ");
        System.out.println("排序后的数据 " + Arrays.toString(array));
    }

    //优化前的方案
    private static void bubbleSort(int[] array) {
        for(int i = 0;i < array.length - 1;i++){        //外部循环控制回合。
            for(int j = 0;j < array.length - i - 1;j++){    //内部循环-处理每一轮的冒泡处理，先进行元素比较，再进行元素交换。
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        System.out.println("排序后的数据 " + Arrays.toString(array));
    }

    /**
     * 优化后的方案
     * 1.对于有序的，不需要多次循环；
     * 2.定义无序数列的边界；
     */
    private static void bubbleSort1(int[] array) {

        //定义最后一次交换的位置
        int lastExchangeIndex = 0;

        //定义无序的边界
        int sortBorder = array.length - 1;

        for(int i = 0;i < array.length - 1;i++){
            boolean isSorted = true;
            for(int j = 0;j < sortBorder;j++){
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //因为有元素交换，所以不是有序的
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if(isSorted){
                break;
            }
        }

        System.out.println("排序后的数据 " + Arrays.toString(array));
    }

    //温习冒泡排序的写法
    private static void bubbleSort2(int[] array){

        //优化2：边界问题处理
        int sortBord = array.length - 1;
        int lastChangeIndex = 0;

        //双重循环的方式
        for (int i = 0; i < array.length; i++) {

            //优化1：增加变量标记
            boolean isSort = true;

            //外层循环控制回合次数

//            for (int j = 0; j < array.length - i - 1; j++) {
            for (int j = 0; j < sortBord; j++) {
                //内存循环比较前后两个值得大小，内循环一轮结束之后，最大值在最右侧
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSort = false;             //证明排过序
                    lastChangeIndex = j;
                }
            }

            sortBord = lastChangeIndex;

            if(isSort){     //已经有序了
                break;
            }

        }

        System.out.println("排序后的数据 " + Arrays.toString(array));

    }
}
