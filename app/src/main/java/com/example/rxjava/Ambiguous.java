package com.example.rxjava;

import android.util.Log;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class Ambiguous {
    public static void ambig() throws InterruptedException {
        Observable<String> ob1 = Observable.interval(1, TimeUnit.SECONDS).take(10).map(e -> "Ob1: " + e);
        Observable<String> ob2 = Observable.interval(10, TimeUnit.MILLISECONDS).take(10).map(e-> "Ob 2: " +e);

        Observable.amb(Arrays.asList(ob1, ob2)).subscribe(f -> Log.e("e", "Observer 2:" + f));

        Thread.sleep(11000);
    }
}
