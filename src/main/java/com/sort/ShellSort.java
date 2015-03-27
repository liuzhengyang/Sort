package com.sort;

/**
 * Shellsort is geenration of isnertion sort that allows the exchange of items that are far apart.
 * Created by liuzhengyang on 2015/3/27.
 */
public class ShellSort {

    public static void sort(int[] arr){

        int len = arr.length;
        int gap = len;
        while(gap > 1){
            gap = gap / 4 *2 +1;
            for(int i = gap; i < len; i ++){
                int temp = arr[i];
                int j;
                for(j = i; j >= gap && arr[j-gap] >temp; j-=gap){
                    arr[j] = arr[j-gap];
                }
                arr[j] = temp;
            }
        }
    }



}
