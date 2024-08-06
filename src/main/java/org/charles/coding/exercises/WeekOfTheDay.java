package org.charles.coding.exercises;

import java.util.Arrays;
import java.util.List;

public class WeekOfTheDay {
    public static void main(String[] args) {
        List<String> dayList = Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");
        String currDay = "Thu";
        int offset = 14;

        int currDayIdx = dayList.indexOf(currDay);
        int totalOffset = (currDayIdx + offset) % 7;
        System.out.printf("Offsetted day is: %s\n", dayList.get(totalOffset).toUpperCase());
    }
}
