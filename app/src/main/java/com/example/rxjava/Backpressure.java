package com.example.rxjava;

import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.atomic.AtomicInteger;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Backpressure {
    public static void bp(){
        Flowable.range(1, 1000000)
                .map(e -> {
                    Log.e("e", "Produced item is : " + e + Thread.currentThread().getName());
                    return e;
                })
                .observeOn(Schedulers.io())
                .subscribe(new Subscriber<Integer>() {

                    Subscription s;
                    AtomicInteger count = new AtomicInteger(0);
                    @Override
                    public void onSubscribe(Subscription s) {
                        this.s = s;
                        Log.e("e", "Asking for 20 items");
                        s.request(20);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e("e", "Subscriber consumed is : " + integer);

                        if(count.getAndIncrement() % 20 ==0){
                            Log.e("e", "Asking for next 20 items");
                            s.request(20);
                        }
                        sleep(100);
                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        Log.e("e", "Completed");
                    }
                });
                sleep(1000000000);
    }

    public static void sleep(long milliseconds){
        try{
        Thread.sleep(milliseconds);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
