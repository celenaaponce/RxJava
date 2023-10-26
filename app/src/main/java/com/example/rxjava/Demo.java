package com.example.rxjava;

import android.util.Log;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class Demo {

    public static void demo(){
        @NonNull
        PublishSubject<String> subject = PublishSubject.create();
        Subject<String> serialized = subject.toSerialized();

        serialized.subscribe(f -> Log.e("e",  "" + f));
        serialized.subscribe(f -> Log.e("e",  "Obs2: " + f));
        serialized.onNext("Hello");
        serialized.onNext("BasicStrong");
        serialized.onComplete();
    }
}
