package com.example.rxjava;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class MergeAndConcat {
    public static void mac() throws InterruptedException {
//        Observable<String> src1 = Observable.just("Ella", "Alex", "Lily");
//        Observable<String> src2 = Observable.just("Priya", "Chloe");
        Observable<String> src1 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src1 :" +e);
        Observable<String> src2 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src2 :" +e);
//        Observable.concat(src1, src2).subscribe(e -> Log.e("e", "Observer 2:" + e));
        src1.concatWith(src2).subscribe(e -> Log.e("e", "Observer 2:" + e));
        Thread.sleep(20000);
    }
}
