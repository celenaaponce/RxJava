package com.example.rxjava;

import android.util.Log;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteStreams {
    public static void inf(){
        Stream.iterate(0, i -> i+1);

        IntStream.iterate(0, i -> i-1)
                .limit(15)
                .forEach(e -> Log.e("e", String.valueOf(e)));

        Stream.generate(new Random() :: nextInt).forEach(e->Log.e("e", String.valueOf(e)));
    }
}
