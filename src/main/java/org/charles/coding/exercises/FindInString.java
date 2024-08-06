package org.charles.coding.exercises;

public class FindInString {
    public static void main(String[] args) {
        System.out.println(solutionV1("IZzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzswariyaFernaNdo"));
    }

    private static String solutionV1(String str){
        String[] strArr = getLowerCharacters();
        for (int i = strArr.length-1; i >= 0; i--) {
            String sUpper = strArr[i].toUpperCase();
            if(str.contains(strArr[i].toLowerCase()) && str.contains(sUpper))
                return sUpper;
        }
        return "NO";
    }

    private static String[] getLowerCharacters() {
        char a = 'a';
        String[] strArr = new String[26];
        strArr[0] = "a";
        for (int i = 1; i < strArr.length; i++) {
            char prev = strArr[i-1].charAt(0);
            strArr[i] = String.valueOf(++prev);
        }
        return strArr;
    }
}
