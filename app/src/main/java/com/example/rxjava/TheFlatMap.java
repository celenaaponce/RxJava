package com.example.rxjava;

import android.util.Log;

import java.time.LocalTime;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TheFlatMap {
    public static void flatm() throws InterruptedException {
        Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .flatMap(e -> Observable.just(e).subscribeOn(Schedulers.computation())
                        .map(f -> compute(f)))
        .subscribe(e -> Log.e("e", "Observer 1:" + e));

        Thread.sleep(7000);
    }

    public static String compute(String element){
        String s = element + " : Printed By : " + Thread.currentThread().getName() + "at : " + LocalTime.now();
        return s;
    }
}
