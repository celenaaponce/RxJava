package com.example.rxjava;

import android.util.Log;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class OperatorsInAction {
    public static void oia(){
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

        obs.filter(e -> e.getRating() > 4.0)
                .sorted((e1, e2) -> Double.compare(e2.getRating(), e1.getRating()))
                .map(e -> e.getName())
                .take(4)
                .toList()
                .subscribe(e -> Log.e("e", "Observer 2:" + e));

        List<Integer> expenses = List.of(200, 500, 300, 340, 129, 234, 999, 1030, 3400, 890, 996, 789);

        Observable.fromIterable(expenses)
                .reduce((a,b) -> a+b)
                .subscribe(e -> Log.e("e", "Observer 2:" + e));
    }

}
