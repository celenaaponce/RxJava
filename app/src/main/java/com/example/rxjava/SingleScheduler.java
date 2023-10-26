package com.example.rxjava;

import android.util.Log;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SingleScheduler {
    public static void comps() throws InterruptedException {
        Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(Schedulers.single());

        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());

        Thread.sleep(50000);
    }

    public static void sensitiveTask() throws InterruptedException {
        Thread.sleep(1000);
        Log.e("e", "Observer 1:" + Thread.currentThread().getName());
    }
}
