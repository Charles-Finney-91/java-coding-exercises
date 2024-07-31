package org.charles.coding.lambdaex;

import java.util.Comparator;
import java.util.List;

public class SortBySumOfDigits {
    public static void main(String[] args) {
        List<Integer> list = List.of(1110,111,110,11,100,10,1);

        list.stream()
                .sorted(Comparator.comparing(SortBySumOfDigits::getSumOfDigits).thenComparing((o1, o2) -> o1 - o2))
                .forEach(System.out::println);

    }

    private static int getSumOfDigits(Integer num) {
        int sumOfDigits = 0;

        do {
            sumOfDigits += num % 10;
            num /= 10;
        } while (num > 0);

        return sumOfDigits;
    }
}
