package com.example.rxjava;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ObservingTheStream {

    public static void obs(){
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Alchemist", "Paulo", "Adventure", 4.408));
        books.add(new Book("The Notebook", "Sparks", "Romance", 4.10));
        books.add(new Book("Horror Cocktail", "Bloch", "Horror", 2.67));
        books.add(new Book("House of Leaves", "Mark", "Horror", 4.109));
//        List<Book> popularHorrorBooks = books.stream()
//                .filter((book) -> book.getGenre().equalsIgnoreCase("Horror"))
//                .filter((book) -> book.getRating() > 3)
//                .collect(Collectors.toList());

        Stream<Book> stream = books.stream();
        Stream<Book> horrorBooks = stream.filter((book) -> book.getGenre().equalsIgnoreCase("Horror"));
        Stream<Book> popularHorrorBooks = horrorBooks.filter((book) -> book.getRating() > 3);
        List<Book> collect = popularHorrorBooks.collect(Collectors.toList());


    }
}
