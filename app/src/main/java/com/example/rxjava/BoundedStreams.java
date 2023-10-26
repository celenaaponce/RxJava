package com.example.rxjava;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BoundedStreams {
    public static void bound(){
        //stream() on Collection
        List<Integer> list = List.of(1,4,7,9,4);
        Stream<Integer> streamInt = list.stream();

        //how to stream map
        Map<Integer, String> map = Map.of(1, "one", 2, "two", 3, "three", 4, "four");
        Stream<Map.Entry<Integer, String>> entries = map.entrySet().stream();

        Stream<String> values = map.values().stream();
        Stream<Integer> keys = map.keySet().stream();

        //static of() method
        Stream<String> streamStrings = Stream.of("Hey!", "Happy", "Thanksgiving");


        //stream() of Arrays Class
        Integer[] integerArray = {3, 5, 7, 89, 9};
        Stream<Integer> stream = Arrays.stream(integerArray);
        int[] intArr = {3, 5, 7, 89, 9};
        IntStream stream1 = Arrays.stream(intArr);

        //builder() of stream class
        Stream.Builder<Integer> builder = Stream.builder();
        
        builder.add(1);
        builder.add(4);
        Stream<Integer> build = builder.build();
    }
}
