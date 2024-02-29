package org.charles.coding.lambdaex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharacter {
    public static void main(String[] args) {
        String input = "Java articles are Awesome";
        find(input);
    }

    private static void find(String input){
        input.chars().mapToObj(i -> Character.toLowerCase((char) i))
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().ifPresent(System.out::println);
    }
}
