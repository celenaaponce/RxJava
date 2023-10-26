package com.example.rxjava;

import android.util.Log;

import io.reactivex.rxjava3.core.Observable;

public class CreatingObserver {
    public static void createob(){
        Observable<String> source = Observable.just("Orange", "Black", "Red");

        source.subscribe(e -> Log.e("e", "Observer 1:" + e),
                error -> Log.e("e", "Observer 1:" + error),
                () -> Log.e("e", "Complete"));

        source.subscribe(e -> Log.e("e", "Observer 1:" + e),
                error -> Log.e("e", "Observer 1:" + error));

        source.subscribe(e -> Log.e("e", "Observer 1:" + e));
    }
}
