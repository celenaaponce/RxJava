package com.example.rxjava;

import android.util.Log;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Consumer;

public class ObserverandObservable {
    public static void oo() {
        Observable<Integer> source = new ObservableCreate<Integer> (new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
                try {
                    emitter.onNext(10);
                    emitter.onNext(11);
                    emitter.onComplete();
                } catch (Throwable t) {
                    emitter.onError(t);
                }
            }
        });
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e("on Subscribed", "on Subscribed");
            }

            @Override
            public void onNext(@NonNull Integer t) {
                Log.e("On Next", "On Next: " + t);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("On Error", "${e.printStackTrace()}");

            }

            @Override
            public void onComplete() {
                Log.e("Completed", "Completed");
            }
        };

        source.subscribe(observer);

    }
}
