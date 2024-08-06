package org.charles.coding.leetcode;

import java.util.Arrays;
import java.util.List;

public class WordBreakProblem {
    public static void main(String[] args) {
        String word = "break";
        String[] dict = {"break", "bre", "ak", "br", "eak", "b", "r", "e", "a", "k"};
        wordBreak(word, word.length(), Arrays.asList(dict), "");
    }

    private static void wordBreak(String word, int wordLen, List<String> dict, String ans){
        for (int i = 1; i <= wordLen; i++) {
            String temp = word.substring(0,i);
            if (dict.contains(temp)){
                if (i==wordLen) {
                    ans = ans + temp;
                    System.out.println(ans);
                    return;
                }
                wordBreak(word.substring(i,wordLen), wordLen-i, dict, ans+temp+" ");
            }
        }
    }
}
