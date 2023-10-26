package com.example.rxjava;

import android.util.Log;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NewThreadScheduler {
    public static void comps() throws InterruptedException {
        Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(Schedulers.newThread());

        src.subscribe(e -> task());

        Thread.sleep(6000);
        src.subscribe(e -> task());
        src.subscribe(e -> task());
        src.subscribe(e -> task());
        src.subscribe(e -> task());

        Thread.sleep(50000);
    }

    public static void task() throws InterruptedException {
        Thread.sleep(1000);
        Log.e("e", "Observer 1:" + Thread.currentThread().getName());
    }
}

