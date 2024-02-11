package org.charles.coding.leetcode;

import java.util.List;

public class RemoveVowels {
    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println(vowelsRemoved(str));
    }

    private static String vowelsRemoved(String str){
        List<Character> vowels = List.of('a','e','i','o','u');
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<str.length()){
            if (vowels.contains(str.toLowerCase().charAt(i)))
                i++;
            else
                sb.append(str.charAt(i++));
        }
        return sb.toString();
    }


}
