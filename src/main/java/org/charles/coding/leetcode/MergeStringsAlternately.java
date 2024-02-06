package org.charles.coding.leetcode;

import java.util.Arrays;

public class MergeStringsAlternately {
    public static void main(String[] args) {
        String word1 = "ace";
        String word2 = "bdfg";

        System.out.println(mergeStringsAlternatelyV2(word1, word2));
    }

    private static String mergeStringsAlternatelyV1(String word1, String word2){
        int i=0;
        int j=0;
        boolean isI = true;
        StringBuilder result = new StringBuilder();

        while (i<word1.length() && j<word2.length()){
            if (isI){
                result.append(word1.charAt(i));
                i++;
                isI = false;
            }
            else {
                result.append(word2.charAt(j));
                j++;
                isI = true;
            }
        }

        if (i<word1.length()){
            result.append(word1, i, word1.length());
        }
        if (j<word2.length()){
            result.append(word2, j, word2.length());
        }

        return result.toString();
    }

    private static String mergeStringsAlternatelyV2(String word1, String word2){
        int length1 = word1.length(), length2 = word2.length();
        int i=0,j=0, k=0;
        char[] result = new char[length1 + length2];

        while (k<result.length){
            if (i<length1)
                result[k++] = word1.charAt(i++);

            if (j<length2)
                result[k++] = word2.charAt(j++);
        }

        return String.valueOf(result);
    }
}

