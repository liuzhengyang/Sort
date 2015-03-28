package com.sort;

import static com.sort.ArrayUtil.swap;

/**
 * Created by liuzhengyang on 2015/3/28.
 */
public class HeapSort {
    public static void sort(int[] array){
        buildMaxHeapify(array);
        for(int i = array.length - 1; i > 0; i--){
            swap(array, 0, i);
            maxHeapify(array, i, 0);
        }
    }

    private static void buildMaxHeapify(int[] array){
        int startIndex = ((array.length - 1) - 1)/2;
        for(int i = startIndex; i >=0; i--){
            maxHeapify(array,array.length, i);
        }
    }

    private static void maxHeapify(int[] array, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        if(left < heapSize && array[largest] < array[left]){
            largest = left;
        }
        if(right < heapSize && array[largest] < array[right]){
            largest = right;
        }
        if(largest != index){
            swap(array, largest, index);
            maxHeapify(array, heapSize, largest);
        }
    }

}
