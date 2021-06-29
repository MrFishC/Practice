package com.jack.a04_algorithm.a04_heap_sort;

import java.util.Arrays;

/**
 * @创建者 Jack
 * @创建时间 2021/5/31 11:29
 * @描述 《漫画算法》果然了不起
 *
 * 经典至极
 */
public class HeapSortClient {
    public static void main(String[] arg){
        int[] arr = new int[] {1,3,2,4,6,5,7,8,9,10,0};
        heapSort(arr);
        System.out.println("==================================");
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] array) {

        //1.构建最大堆
        for (int i = (array.length - 2)/2; i >= 0;i--) {
            downAdjust(array,i,array.length);
        }

        System.out.println("-------最大堆构建完毕-------");
        System.out.println(Arrays.toString(array));

        System.out.println("-------开始排序-------");
        for (int i = array.length - 1; i > 0 ; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            //分析一下i = array.length - 1的情况
            downAdjust(array,0,i);
        }

    }

    private static void downAdjust(int[] array,int parentIndex,int length){
        //保存父节点值，用于最后的赋值
        int temp = array[parentIndex];
        //根据父节点计算左孩子在数组中的索引
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            // 存在右孩子，且右孩子值大，需要childIndex++
            if (childIndex + 1 < length && array[childIndex] < array[childIndex + 1]) {
                childIndex++;
            }

            //父节点大于左右孩子节点，跳出循环
            if(temp >= array[childIndex]){
                break;
            }

            //父节点小于childIndex节点的值，将数组childIndex索引的值赋值给parentIndex索引位置
            //同时，重新计算parentIndex和childIndex变量
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;        //parentIndex左孩子的索引
            //继续下一轮循环
        }

        //此时的parentIndex就变成最后一个没有左右孩子的节点了
        array[parentIndex] = temp;
    }
}
