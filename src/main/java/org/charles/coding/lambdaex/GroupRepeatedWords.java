package org.charles.coding.lambdaex;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupRepeatedWords {
    public static void main(String[] args) {
        // find count of all characters
        // ignore case
        // Expected output:JAVA = 3, SPRING = 2, MICROSERVICES = 1, SQL = 1, CLOUD = 1
        String[] array = {"jaVa", "Spring", "Microservices", "java", "SqL", "Java", "cLoud", "spring"};

        String collect = Arrays.stream(array).map(String::toUpperCase)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream().sorted(Collections.reverseOrder(Comparator.comparingLong(Map.Entry::getValue)))
                .map(e -> e.getKey() + " = " + e.getValue())
                .collect(Collectors.joining(", "));

        System.out.println(collect);
    }
}
