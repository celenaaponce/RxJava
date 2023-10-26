package com.example.rxjava;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class ZipAndCombineLatest {

    public static void zac() throws InterruptedException {
        Observable<Long> src1 = Observable.interval(200, TimeUnit.MILLISECONDS).take(10);
        Observable<Long> src2 = Observable.interval(1, TimeUnit.SECONDS).take(10);
        Observable.combineLatest(src1, src2, (e1, e2) -> "Source1: " + e1 + "Source2: " + e2).subscribe(f -> Log.e("e", f));

        Thread.sleep(20000);

    }
}
