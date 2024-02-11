package org.charles.coding.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReverseVowels {
    public static void main(String[] args) {
        char[] arr = {'a','e','i','o','u'};
        System.out.println(reverseVowels(" apG0i4maAs::sA0m4i0Gp0"));
    }

    public static String reverseVowels(String s) {
        List<Character> vowels = List.of('a','A','e','E','i','I','o','O','u','U');
        char[] arr = s.toCharArray();
        int length = arr.length;
        int i=0;
        int j=length-1;
        char charAtI,charAtJ;
        while (i<j){
            charAtI = s.charAt(i);
            charAtJ = s.charAt(j);
            if (!vowels.contains(charAtI))
                i++;
            if (!vowels.contains(charAtJ))
                j--;
            if (vowels.contains(charAtI)
                    && vowels.contains(charAtJ)){
                char temp = arr[i];
                arr[i++] = arr[j];
                arr[j--] = temp;
            }
        }

        return String.valueOf(arr);
    }
}
