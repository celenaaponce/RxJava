package com.example.rxjava;

import android.util.Log;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class Variants {
    public static void vari(){
        Observable<String> source = Observable.just("Alex", "Justin", "Jack");
        Observable<String> source1 = Observable.empty();


        source.first("Name").subscribe(e -> Log.e("e", "Observer 1:" + e));

        Single.just("Alex").subscribe(e -> Log.e("e", "Observer 1:" + e));

        source1.firstElement().subscribe(e -> Log.e("e", "Observer 2:" + e),
                e -> Log.e("e", "Observer 2: Comp"));

        Completable completable = Completable.complete();
        completable.subscribe(() -> Log.e("e", "complete"));

        Completable.fromRunnable(() -> Log.e("e", "executing"))
                .subscribe(() -> Log.e("e", "completed"));

    }
}
