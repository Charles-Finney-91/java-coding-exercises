package org.charles.coding.lambdaex;

import org.charles.coding.exercises.Person;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ListToMap {

    public static void main(String[] args) {
        // Convert list to map
        List<Person> list = List.of(
                new Person("Charles", "Finney"),
                new Person("Ludina", "Iswariya"),
                new Person("Gladina", "Estheria"),
                new Person("Charles", "Grandson")
        );
        System.out.println(listToMap(list));
    }

    private static HashMap<String, String> listToMap(List<Person> list) {
        return list
                .stream()
                .collect(Collectors.toMap(Person::getFirstName, Person::getLastName, (l1, l2) -> l2, LinkedHashMap::new));
    }
}
