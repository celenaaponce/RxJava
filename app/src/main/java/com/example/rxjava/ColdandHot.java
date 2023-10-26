package com.example.rxjava;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class ColdandHot {
    public static void ch(){
        List<Integer> list = new ArrayList<>();
        list.add(16);
        list.add(17);
        list.add(18);

        Observable<Integer> source = Observable.fromIterable(list);

        source.subscribe(e -> Log.e("e", "Observer 1:" + e));

        list = getData(list);
        source.subscribe(e -> Log.e("e", "Observer 1:" + e));
    }

    private static List<Integer> getData(List<Integer> list){
        list.add(19);
        return list;
    }

    //Hot


}
