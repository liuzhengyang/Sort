package com.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Created by liuzhengyang on 2015/4/23.
 */
public class RecursiveSort<T extends Comparable<T>> extends RecursiveAction {

    // 7 array length threshold for splitting
    public static final int THRESHOLD = 7;


    private T[] array;
    private int lo,hi; // inclusive

    public RecursiveSort(T[] array, int lo, int hi){
        this.array = array;
        this.lo = lo;
        this.hi = hi;
    }

    public RecursiveSort(T[] array) {
        this(array, 0, array.length - 1);
    }

    @Override
    protected void compute() {
        if(hi - lo < THRESHOLD){
//            RangeSort.sort(array, lo, hi);
        }else{
            // fork
            int mid = (lo + hi) >>> 1;
            RecursiveSort<T> recursiveSortLeft = new RecursiveSort<>(array, lo, mid);
            RecursiveSort<T> recursiveSortRight = new RecursiveSort<>(array, mid, hi);
            invokeAll(recursiveSortLeft, recursiveSortRight);
        }
    }
    public static class RangeSort<T extends Comparable<T>> extends RecursiveAction{
        private T[] array;
        private int start;
        private int end;

        public RangeSort(T[] srray, int start, int end) {
            this.array = srray;
            this.start = start;
            this.end = end;
        }

        public RangeSort(T[] array) {
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
            List<RecursiveSort> tasks = new ArrayList<>();
            if(start < i){
                System.out.println("add task " + start + " : " + i);
                tasks.add(new RecursiveSort<>(array, start, i - 1));
            }
            if(j < end){
                System.out.println("add task " + i + " : " + end);
                tasks.add(new RecursiveSort<>(array, i + 1, end));
            }
            invokeAll(tasks);
        }
    }

}

