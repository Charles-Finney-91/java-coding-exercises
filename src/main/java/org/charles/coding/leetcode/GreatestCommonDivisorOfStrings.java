package org.charles.coding.leetcode;

import java.util.Arrays;

public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        String str1 = "ABCABC";
        String str2 = "ABC";

//        System.out.println(word1.split(word1).length);
//        System.out.println(solution(word1, word2));
        System.out.println(gcdOfStrings(str1, str2));
    }

    public static String gcdOfStrings(String str1, String str2) {
        if(str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        } else if (!str1.startsWith(str2)) {
            return "";
        } else if (str2.isEmpty()) {
            return str1;
        } else {
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }

    }

    private static String solution(String str1, String str2){
        if (str1.equals(str2)){
            return str2;
        }
        String smallStr = str1.length() < str2.length() ? str1 : str2;

        StringBuilder singlePrefix = new StringBuilder();
        for (char c : smallStr.toCharArray()) {
            singlePrefix.append(c);
            if (smallStr.split(singlePrefix.toString()).length == 0){
                break;
            }
        }

        if (singlePrefix.isEmpty()){
            return "";
        }
        else {
            String result = "";
            StringBuilder checker = new StringBuilder();
            while (smallStr.length() >= checker.length()){
                checker.append(singlePrefix);
                if (str1.split(String.valueOf(checker)).length == 0
                        && str2.split(String.valueOf(checker)).length == 0){
                    result = checker.toString();
                }
            }
            return result;
        }
    }

}
