package org.charles.coding.lambdaex;

import java.util.Arrays;
import java.util.stream.Collectors;

public class IsNumbersRepeated {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,2,3,1}));
        System.out.println(solution(new int[] {1,2,3,4}));
    }

    private static boolean solution(int[] array){
        return Arrays.stream(array).boxed()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream().anyMatch(e -> e.getValue() > 1);
    }
}
