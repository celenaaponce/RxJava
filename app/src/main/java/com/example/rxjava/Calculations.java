package com.example.rxjava;

import android.util.Log;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Calculations {
    public static void calc(){
        int sumInt = IntStream.of(1,2,3)
                .sum();
        Log.e("e", String.valueOf(sumInt));

        OptionalInt maxOptional = IntStream.of(1,2,3).max();

        Log.e("e", String.valueOf(maxOptional));

        OptionalInt minOptional = IntStream.of(1,2,3).min();
        Log.e("e", String.valueOf(minOptional));

        OptionalDouble avgOptional = IntStream.of(1,2,3).average();
        Log.e("e", String.valueOf(avgOptional));

        IntSummaryStatistics summaryStatistics = IntStream.of(1,2,34).summaryStatistics();

        Log.e("e", String.valueOf(summaryStatistics));

    }
}
