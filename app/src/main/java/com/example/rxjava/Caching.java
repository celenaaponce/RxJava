package com.example.rxjava;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public class Caching {

    public static void cache() throws InterruptedException {
        @NonNull
        Observable<@NonNull Long> src = Observable.interval(1, TimeUnit.SECONDS)
                .cache();
        src.subscribe(f -> Log.e("e",  "Obs 1: " + f));

        Thread.sleep(5000);

        src.subscribe(f -> Log.e("e",  "Obs 2:" + f));

        Thread.sleep(3000);
}
}
