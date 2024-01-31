package org.charles.coding.exercises;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NthHighestSalary {

    public static void main(String[] args) {
        // Get nth highest salary
        Map<String, Integer> empSalaryMap = Map.of(
                "Charles",100,
                "Grandson",200,
                "Finney", 200,
                "Ludina", 400,
                "Iswariya", 600,
                "Fernando", 600
        );
        System.out.println(getNthHighestSalary(1, empSalaryMap));
    }

    private static Map.Entry<Integer, List<String>> getNthHighestSalary(int n, Map<String, Integer> empSalaryMap) {
        if (n<empSalaryMap.size() && n>0) {
            return empSalaryMap.entrySet().stream()
                    .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                    .entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                    .toList().get(n - 1);
        }
        return null;
    }
}
