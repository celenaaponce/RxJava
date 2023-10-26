package com.example.rxjava;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class NumericStreams {
    public static void num(){
        List<Book> list = new ArrayList<>();
        list.add(new Book("The Alchemist", "Paulo", "Adventure", 4.408));
        list.add(new Book("The Notebook", "Sparks", "Romance", 4.10));
        list.add(new Book("Horror Cocktail", "Bloch", "Horror", 2.67));
        list.add(new Book("House of Leaves", "Mark", "Horror", 4.109));

        OptionalDouble average = list.stream()
                .mapToDouble(book -> book.getRating())
                .average();

        Log.e("avg", average.toString());

        IntStream intS = IntStream.of(1,3,5,8);
        DoubleStream doubleS = DoubleStream.of(1,3,5,8);
        LongStream longS = LongStream.of(1L, 3L, 5L, 8L);

        Stream<Integer> boxedInts = intS.boxed();
        doubleS.mapToObj(val -> val);

    }
}
