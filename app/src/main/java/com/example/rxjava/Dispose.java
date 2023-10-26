package com.example.rxjava;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public class Dispose {
    private static final CompositeDisposable disp = new CompositeDisposable();
    public static void dispose() throws InterruptedException{

        @NonNull
        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);

        @NonNull
        Disposable d1 = source.subscribe(e -> Log.e("e", "Observer 1:" + e));
        Disposable d2 = source.subscribe(e -> Log.e("e", "Observer 2:" + e));

        Thread.sleep(5000);
        disp.addAll(d1, d2);
        disp.dispose();

        Thread.sleep(10000);
    }
}
