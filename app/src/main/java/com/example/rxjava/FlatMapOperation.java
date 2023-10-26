package com.example.rxjava;

import java.util.stream.Stream;

public class FlatMapOperation {
    public static void flmap(){
        Stream<String> a = Stream.of("Hello", "There!");
        Stream<String> b = Stream.of("Learning", "Java?");

        Stream<Stream<String>> c = Stream.of(a, b);//not ideal

        Stream<String> stringStream = Stream.of(a, b).flatMap(e -> e);

    }
}
