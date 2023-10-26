package com.example.rxjava;

import android.util.Log;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterOperation {
    public static void filt(){
        Stream.of(34,678,89,4,52,31,325,6).filter(e -> e%2==0)
                .forEach(e -> Log.e("e", e.toString()));
    }
}
