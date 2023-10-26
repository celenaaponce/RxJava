package com.example.rxjava;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SingleUse {

    public static void su(){
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Alchemist", "Paulo", "Adventure", 4.408));
        books.add(new Book("The Notebook", "Sparks", "Romance", 4.10));
        books.add(new Book("Horror Cocktail", "Bloch", "Horror", 2.67));
        books.add(new Book("House of Leaves", "Mark", "Horror", 4.109));

        Stream<Book> stream = books.stream();

        List<Book> popularHorrorBooks = books.stream()
                .filter((book) -> book.getGenre().equalsIgnoreCase("Horror"))
                .filter((book) -> book.getRating() > 3)
                .collect(Collectors.toList());
        popularHorrorBooks.forEach(book -> Log.e("e", book.getName()));
        List<Book> popularRomanticBooks = books.stream()
                .filter((book) -> book.getGenre().equalsIgnoreCase("Romance"))
                .filter((book) -> book.getRating() > 3)
                .collect(Collectors.toList());
        popularRomanticBooks.forEach(book -> Log.e("e", book.getName()));

    }
}
