package org.charles.coding.exercises;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ListToMap {

    public static void main(String[] args) {
        // Convert list to map
        List<Person> list = List.of(
                new Person("Charles", "Finney"),
                new Person("Ludina", "Iswariya"),
                new Person("Gladina", "Estheria")
        );
        System.out.println(listToMap(list));
    }

    private static HashMap<String, String> listToMap(List<Person> list) {
        return list.stream()
                .collect(Collectors.toMap(Person::getFirstName, Person::getLastName, (f, l) -> f + "," + l, HashMap::new));
    }
}
