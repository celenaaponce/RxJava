package com.example.rxjava;

import android.util.Log;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ComputationScheduler {

    public static void comps() throws InterruptedException {
        Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(Schedulers.computation());

        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());

        Thread.sleep(50000);
    }

    public static void compute() throws InterruptedException {
        Thread.sleep(1000);
        Log.e("e", "Observer 1:" + Thread.currentThread().getName());
    }
}
