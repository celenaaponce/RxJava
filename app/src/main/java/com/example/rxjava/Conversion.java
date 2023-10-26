package com.example.rxjava;

import android.util.Log;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Conversion {
    public static void convo() throws InterruptedException {
//        Observable.range(1, 1000000)
//                .toFlowable(BackpressureStrategy.BUFFER)
//                .observeOn(Schedulers.io())
//                .subscribe(e -> Log.e("e", e + Thread.currentThread().getName()));
//        Thread.sleep(5000);

        Flowable.range(1, 1000000)
                .toObservable()
                .observeOn(Schedulers.io())
                .subscribe(e -> Log.e("e", e + Thread.currentThread().getName()));
        Thread.sleep(5000);
    }
}
