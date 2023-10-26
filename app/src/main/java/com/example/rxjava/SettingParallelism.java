package com.example.rxjava;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class SettingParallelism {

    public static void setting() throws ExecutionException, InterruptedException {
        Log.e("e", String.valueOf(Runtime.getRuntime().availableProcessors()));//has 8 cores
//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");
        Log.e("e", String.valueOf(ForkJoinPool.getCommonPoolParallelism()));

        ForkJoinPool pool = new ForkJoinPool(2);

        List<Employee2> list = new ArrayList<>();

        for (int i=0; i<100; i++){
            list.add(new Employee2("John", 20000));
            list.add(new Employee2("Rohn", 3000));
            list.add(new Employee2("Tom", 15000));
            list.add(new Employee2("Bheem", 8000));
            list.add(new Employee2("Shiva", 200));
            list.add(new Employee2("Krishna", 50000));
        }

        long count = pool.submit(() ->
        list.parallelStream()
                .filter(e -> e.getSalary() > 1000)
                .count()).get();
        Log.e("e", String.valueOf(count));
    }
}
