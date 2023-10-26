package com.example.rxjava;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public class ConnectableObservable {
    public static void conn() throws InterruptedException{
        io.reactivex.rxjava3.observables.@NonNull ConnectableObservable<@NonNull Long> source= Observable.interval(1, TimeUnit.SECONDS).publish();

        source.connect();

        source.subscribe(e -> Log.e("e", "Observer 1:" + e));
        Thread.sleep(10000);
        source.subscribe(e -> Log.e("e", "Observer 2:" + e));
        Thread.sleep(10000);
    }
}
