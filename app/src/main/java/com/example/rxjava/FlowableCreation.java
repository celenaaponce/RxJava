package com.example.rxjava;

import android.util.Log;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FlowableCreation {
    public static void flow() throws InterruptedException {
        Flowable.create(emitter -> {
            for (int i = 0; i <= 5000; i++) {
                if (emitter.isCancelled())
                    return;
                emitter.onNext(i);
            }
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER)
                .observeOn(Schedulers.io())
                .subscribe(e -> Log.e("e", "" + e));

        Thread.sleep(2000);
    }
}
