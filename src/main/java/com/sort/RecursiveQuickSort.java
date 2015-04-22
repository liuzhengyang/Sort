package com.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * Created by liuzhengyang on 2015/4/23.
 */
public class RecursiveQuickSort<T extends Comparable<T>> extends RecursiveAction {
    private T[] array;
    private int start;
    private int end;

    public RecursiveQuickSort(T[] srray, int start, int end) {
        this.array = srray;
        this.start = start;
        this.end = end;
    }

    public RecursiveQuickSort(T[] array) {
        this(array, 0, array.length - 1);
    }

    @Override
    protected void compute() {
        System.out.println(Thread.currentThread().getName() + " sort " + start + " to " + end);
        if(start == end){
            return;
        }
        int i = start;
        int j = end;
        T pivot = array[i];
        while(i < j){
            while(i < j){
                if(array[j].compareTo(pivot) < 0){
                    array[i++] = array[j];
                    break;
                }
                j--;
            }
            while(i < j){
                if(array[i].compareTo(pivot) > 0){
                    array[j--] = array[i];
                    break;
                }
                i++;
            }
        }

        // i == j
        array[i] = pivot;
        List<RecursiveQuickSort> tasks = new ArrayList<>();
        if(start < i){
            System.out.println("add task " + start + " : " + i);
            tasks.add(new RecursiveQuickSort<>(array, start, i - 1));
        }
        if(j < end){
            System.out.println("add task " + i + " : " + end);
            tasks.add(new RecursiveQuickSort<>(array, i + 1, end));
        }
        invokeAll(tasks);
    }
}
