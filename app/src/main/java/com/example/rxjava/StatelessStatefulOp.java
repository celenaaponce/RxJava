package com.example.rxjava;

import java.util.List;
import java.util.stream.Collectors;

public class StatelessStatefulOp {
    public static void stateless(){
        List<Integer> list = List.of(1,2,4,5,6,7,9);
        List<Integer> collect = list.parallelStream()//can't use parallel when on stateful methods
                .skip(2)
                .limit(5)
                .collect(Collectors.toList());
    }
}
