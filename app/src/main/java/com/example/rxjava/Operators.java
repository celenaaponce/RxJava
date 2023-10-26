package com.example.rxjava;

import android.util.Log;

import io.reactivex.rxjava3.core.Observable;

public class Operators {

    public static void op(){
        Observable.just(60, 57, 89, 90, 23, 100, 98).filter(e -> e > 75)
                .sorted()
                .subscribe(e -> Log.e("e", "Observer 2:" + e));
    }
}
