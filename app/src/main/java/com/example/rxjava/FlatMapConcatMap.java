package com.example.rxjava;

import android.util.Log;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class FlatMapConcatMap {
    public static void fmcm(){
        List<String> list = List.of("Hello", "Reactive", "Programming");

        Observable.fromIterable(list)
                .flatMap(e -> Observable.fromArray(e.split("")))
                        .subscribe(f -> Log.e("e", "Observer 2:" + f));
    }
}
