package org.charles.coding.lambdaex;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseAIntegerList {
    public static void main(String[] args) {
        List<Integer> list = List.of(11,23,22,43,43,27);

        list.stream().distinct().collect(Collectors.collectingAndThen(Collectors.toList(), l -> {
            Collections.reverse(l);
            return l;
        })).forEach(System.out::println);

        // This sorts not reverses
//        list.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
