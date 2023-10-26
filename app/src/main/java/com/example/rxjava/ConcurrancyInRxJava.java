package com.example.rxjava;

import android.util.Log;

import io.reactivex.rxjava3.core.Observable;

public class ConcurrancyInRxJava {
    public static void concu(){
        Observable<String> source = Observable.create(
                e-> {
                    new Thread(() -> {
                        e.onNext("Hello");
                        e.onNext("RxJava");
                    }).start();
                }
        );
        source.subscribe(f -> Log.e("e",  "Sub 1: " + f + "Thread is: " + Thread.currentThread().getName()));
        source.subscribe(f -> Log.e("e",  "Sub 2: " + f + "Thread is: " + Thread.currentThread().getName()));
    }
}
