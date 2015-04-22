package com.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by liuzhengyang on 2015/4/23.
 */
public class RecurisiveQuickSortTest {


    @Test
    public void testForkJoinSort() throws InterruptedException {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        Integer[] array = {14,24,45,436,46,3,47,21,3532,3,5,35,63,2,3};
        RecursiveQuickSort<Integer> task = new RecursiveQuickSort<>(array);
        forkJoinPool.invoke(task);
        System.out.println(forkJoinPool.getStealCount());
        System.out.println(Arrays.toString(array));
    }
}
