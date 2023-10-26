package com.example.rxjava;

import android.util.Log;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Consumer;

public class HelloRxJava {
    public static void test(){
        Observable<String> source = Observable.create(
                new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<String> e) throws Throwable {
                        e.onNext("Hello");
                        e.onNext("RxJava");
                    }
                }
        );

        source.subscribe(e -> Log.e("e", "Observer 1:" + e + "Thread is:" + Thread.currentThread().getName()));
        source.subscribe(e -> Log.e("e", "Observer 2:" + e + "Thread is:" + Thread.currentThread().getName()));
    }
}
