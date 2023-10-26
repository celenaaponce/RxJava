package com.example.rxjava;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ParallelStreams {
    public static void para(){

        long startTime;
        long endTime;
        List<Employee2> list = new ArrayList<>();

        for (int i=0; i<100; i++){
            list.add(new Employee2("John", 20000));
            list.add(new Employee2("Rohn", 3000));
            list.add(new Employee2("Tom", 15000));
            list.add(new Employee2("Bheem", 8000));
            list.add(new Employee2("Shiva", 200));
            list.add(new Employee2("Krishna", 50000));
        }

        startTime = System.currentTimeMillis();
        Log.e("start ", String.valueOf(startTime));
        Log.e("e", "Performing sequential " + list.stream()
                .filter(e -> e.getSalary() > 1000)
                .count());
        endTime = System.currentTimeMillis();
        Log.e("start ", String.valueOf(endTime));

        Log.e("duration", "time taken: " + String.valueOf(endTime-startTime));

        startTime = System.currentTimeMillis();
        Log.e("start ", String.valueOf(startTime));
        Log.e("e", "Performing parallel " + list.parallelStream()
                .filter(e -> e.getSalary() > 1000)
                .count());
        endTime = System.currentTimeMillis();
        Log.e("start ", String.valueOf(endTime));
        long overallTime = endTime-startTime;
        Log.e("duration", "time taken: " + String.valueOf(overallTime));
    }
}
