package com.example.rxjava;

import android.util.Log;

import io.reactivex.rxjava3.core.Observable;

public class Grouping {
    public static void gro(){
        Observable<Employee> obs = Observable.just(
                new Employee(100, "alexa", 60000, 4.0),
                new Employee(123, "Dhwanit", 94000, 4.7),
                new Employee(236, "mike", 65000, 4.0),
                new Employee(155, "ella", 85000, 4.4),
                new Employee(443, "george", 50000, 3.6),
                new Employee(127, "shareeja", 85000, 4.5),
                new Employee(344, "daniel", 60000, 4.0),
                new Employee(509, "lucy", 94000, 4.7),
                new Employee(344, "harry", 75000, 4.3)
        );

//        obs.groupBy(e->e.getRating())
//                .flatMapSingle(e -> e.toMultimap(key -> e.getKey(), emp -> emp.getName()))
//                .subscribe(f -> Log.e("e",  "" + f));

        obs.groupBy(e->e.getRating())
                .flatMapSingle(e -> e.toList())
                .subscribe(f -> Log.e("e",  "" + f));
    }
}
