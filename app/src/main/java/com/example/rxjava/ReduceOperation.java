package com.example.rxjava;

import android.util.Log;

import java.util.stream.Stream;

public class ReduceOperation {
    public static void red(){
        Integer sum = Stream.of(1,2,34,56,76,87,89,90)
                .reduce(0, (a,b)-> a+b);
        Log.e("e", sum.toString());
    }
}
