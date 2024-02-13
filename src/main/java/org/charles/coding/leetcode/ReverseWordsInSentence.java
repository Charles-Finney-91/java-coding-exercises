package org.charles.coding.leetcode;

public class ReverseWordsInSentence {
    public static void main(String[] args) {
        System.out.println(solution(" Hello World ") + "|");
    }

    private static String solution(String str){
        String[] words = str.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length-1; 0<=i ; i--) {
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
