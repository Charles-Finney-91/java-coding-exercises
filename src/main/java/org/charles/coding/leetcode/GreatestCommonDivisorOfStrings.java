package org.charles.coding.leetcode;

import java.util.Arrays;

public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        String word1 = "TAUXXTAUXXTAUXXTAUXXTAUXX";
        String word2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        System.out.println(solution(word1, word2));
    }

    private static String solution(String str1, String str2){
        StringBuilder prefix = new StringBuilder();
        int i=0;
        String smallestString = str1.length() < str1.length() ? str1 : str2;
        while (i<smallestString.length()){
            prefix.append(smallestString.charAt(i++));
            if (Arrays.stream(smallestString.split(prefix.toString())).findAny().isEmpty()){
                break;
            }
        }

        if (str1.split(String.valueOf(prefix)).length == 0 && str2.split(String.valueOf(prefix)).length == 0){
            return String.valueOf(prefix);
        }
        else {
            return "";
        }
    }
}
