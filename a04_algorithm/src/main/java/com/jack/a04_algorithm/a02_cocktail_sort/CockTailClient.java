package com.jack.a04_algorithm.a02_cocktail_sort;

import java.util.Arrays;

/**
 * @创建者 Jack
 * @创建时间 2021/5/19 13:55
 * @描述 鸡尾酒排序
 *
 * 优点是能够在特定条件下，减少排序的回合数；而缺点也很明显，就是代码量几乎增加了1倍。
 *
 */
public class CockTailClient {

    public static void main(String[] arg){
        int[] array = new int[]{1,3,5,6,2,4,8,9,10};
        cockTailSort(array);
        System.out.println("排序后的数据 " + Arrays.toString(array));
    }

    private static void cockTailSort(int[] array){

        for (int i = 0; i < array.length/2; i++) {      //控制回合
            boolean sort = true;

            //从左到右
            for (int j = i; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]){
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    sort = false;
                }
            }

            if(sort){
                break;
            }

            sort = true;

            //从右到左
            for (int j = array.length - i - 1; j > i; j--) {
                if(array[j] < array[j - 1]){
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    sort = false;
                }
            }

            if(sort){
                break;
            }
        }

    }
}
