package com.example.rxjava;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import io.reactivex.rxjava3.subjects.Subject;
import io.reactivex.rxjava3.subjects.UnicastSubject;

public class SubjectTypes {
    //other options: PublishSubject, ReplaySubject, BehaviorSubject, AsyncSubject
    public static void subtyp() throws InterruptedException {
        Subject<Long> subject = UnicastSubject.create();
        Observable.interval(1000, TimeUnit.MILLISECONDS).subscribe(subject);
        Thread.sleep(2000);
        subject.subscribe(f -> Log.e("e",  "Sub 1: " + f));

        Thread.sleep(2000);

//        subject.onNext("a");
//        subject.onNext("b");
//        subject.onNext("c");
//
//        subject.subscribe(f -> Log.e("e",  "Sub 2: " + f));
//
//        subject.onNext("d");
//        subject.onNext("e");
//        subject.onComplete();
    }
}
