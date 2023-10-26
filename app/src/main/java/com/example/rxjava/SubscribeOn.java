package com.example.rxjava;

import android.util.Log;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SubscribeOn {
    public static void comps() throws InterruptedException {
        Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(Schedulers.computation())
                .map(e -> e.toUpperCase())
                .doOnNext(f -> Log.e("e",  "Sub 1: " + Thread.currentThread().getName()))
                .observeOn(Schedulers.newThread())
                .filter(e -> e.startsWith("P"))
                .observeOn(Schedulers.io())
                .subscribe(f -> print(f));

        Thread.sleep(50000);
    }

    public static void print(String element) throws InterruptedException {

        Log.e("e", element + " : Printed By : " + Thread.currentThread().getName());
    }
}

