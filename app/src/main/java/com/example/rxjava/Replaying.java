package com.example.rxjava;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public class Replaying {

    public static void replay() throws InterruptedException {
        @NonNull
        Observable<@NonNull Long> src = Observable.interval(1, TimeUnit.SECONDS)
                .replay(2, 4, TimeUnit.SECONDS)
                .autoConnect();
        src.subscribe(f -> Log.e("e",  "Obs 1: " + f));

        Thread.sleep(5000);

        src.subscribe(f -> Log.e("e",  "Obs 2:" + f));

        Thread.sleep(3000);
    }
}
