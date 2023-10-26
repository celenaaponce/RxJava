package com.example.rxjava;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Laziness {
    public static void laz(){
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Alchemist", "Paulo", "Adventure", 4.408));
        books.add(new Book("The Notebook", "Sparks", "Romance", 4.10));
        books.add(new Book("Horror Cocktail", "Bloch", "Horror", 2.67));
        books.add(new Book("House of Leaves", "Mark", "Horror", 4.109));

        Stream<Book> stream = books.stream()
                .filter((book) -> book.getGenre().equalsIgnoreCase("Horror"))
                .peek(book -> Log.e("e", "Filtered book" + book.getName()))
                .filter((book) -> book.getRating() > 3);
//                .collect(Collectors.toList());
        Log.e("e", "Filtering done");
        collect(stream);
    }

    private static void collect(Stream<Book> stream) {
        List<Book> pHB = stream.collect(Collectors.toList());
        Log.e("e", "Collection done");
        pHB.forEach(book -> Log.e("e", book.getName()));

    }
}
