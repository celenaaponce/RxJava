package com.example.rxjava;

import android.util.Log;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class Switching {
    public static void swt() throws InterruptedException {
        Observable<String> source = Observable.just("John", "Lily", "Emma", "Reyan", "Darshin")
                .concatMap(s -> Observable.just(s).delay(ThreadLocalRandom.current().nextInt(1000), TimeUnit.MILLISECONDS));

        Observable.interval(2, TimeUnit.SECONDS)
                .switchMap(s -> source.doOnDispose(
                () -> Log.e("e", "Dispose")
                )
                )
                .subscribe(item -> Log.e("e", "output" + item));

        Thread.sleep(10000);
    }
}
