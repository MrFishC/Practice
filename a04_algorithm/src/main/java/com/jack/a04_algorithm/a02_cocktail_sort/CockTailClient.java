package com.jack.a04_algorithm.a02_cocktail_sort;

import java.util.Arrays;

/**
 * @创建者 Jack
 * @创建时间 2021/5/19 13:55
 * @描述 鸡尾酒排序
 *
 * 优点是能够在特定条件下，减少排序的回合数；而缺点也很明显，就是代码量几乎增加了1倍；
 * 每一轮：先比较左侧跟右侧的元素，然后再比较右侧跟左侧的元素；
 */
public class CockTailClient {

    public static void main(String[] arg){
        int[] array = new int[]{1,3,5,6,2,4,8,9,7,10};
        int[] array1 = new int[]{10,7,2,5,1,4,3,8,6,9};
        int[] array2 = new int[]{4,8,9,10,1,3,5,6,2,7};
        cockTailSort(array);
        cockTailSort(array1);
        cockTailSort(array2);
        System.out.println("排序后的数据  " + Arrays.toString(array));
        System.out.println("排序后的数据1 " + Arrays.toString(array1));
        System.out.println("排序后的数据2 " + Arrays.toString(array2));
    }

    private static void cockTailSort(int[] array) {

        //将临时变量提取到循环外部
        int temp = 0;

        //定义无序的边界
        int rightSortBorder = array.length - 1;

        int leftSortBorder = 0;

        //定义最后一次交换的位置
        int lastExchangeIndex = 0;

        for (int i = 0; i < array.length / 2; i++) {

            boolean isSort = true;
            //内部分两次循环

            //1.左侧跟右侧比较-循环结束后最大的元素在最右侧
//            for (int j = i; j < array.length - 1; j++) {
            for (int j = i; j < rightSortBorder; j++) {
                if(array[j] > array[j + 1]){
                    //交换元素
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    lastExchangeIndex = j;
                    isSort = false;
                }
            }

            rightSortBorder = lastExchangeIndex;

            if(isSort){
                break;
            }

            isSort = true;

            //1.右侧跟左侧比较
//            for (int j = array.length - i - 1; j > i; j--) {
            for (int j = array.length - i - 1; j > leftSortBorder; j--) {
                //右侧大于左侧，交换元素
                if(array[j] < array[j - 1]){
                    //交换元素
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                    lastExchangeIndex = j;
                    isSort = false;
                }
            }

            leftSortBorder = lastExchangeIndex;

            System.out.println(" leftSortBorder  = " + leftSortBorder + " ,rightSortBorder = " + rightSortBorder);

            if(isSort){
                break;
            }

        }

    }
}
