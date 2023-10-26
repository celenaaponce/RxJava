package com.example.rxjava;

import android.util.Log;

import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public class CreatingObservable {
    public static void co() {
        Observable<Integer> source = Observable.create(
               e -> {
                   e.onNext(10);
                   e.onNext(11);
                   e.onNext(12);
                   e.onComplete();
               }
        );
        source.subscribe(e -> Log.e("e", "Observer 1:" + e));

        Observable<Integer> just = Observable.just(1, 2, 3);
        just.subscribe(e -> Log.e("e", "Observer 1:" + e));

        List<String> list = List.of("Ram", "Shyam", "Mike");

        @NonNull
        Observable<String> fromIterable = Observable.fromIterable(list);
        fromIterable.subscribe(e -> Log.e("e", "Observer 1:" + e));
    }
}
