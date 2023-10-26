package com.example.rxjava;

import android.util.Log;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public class Buffering {

    public static void buf() {
//        Observable.range(1, 30)
//        .buffer(4, 5)
//                .subscribe(e -> Log.e("e", "Observer:" + e));

//        Observable.interval(500, TimeUnit.MILLISECONDS)
//                .buffer(1, TimeUnit.SECONDS, 2)
//                .subscribe(e -> Log.e("e", "Observer 1:" + e));
        @NonNull
        Observable<Long> interval = Observable.interval(1, TimeUnit.SECONDS);

        Observable.interval(500, TimeUnit.MILLISECONDS).window(interval).subscribe(e -> Log.e("e", "Observer:" + e));
    }

}
