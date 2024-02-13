package org.charles.coding.leetcode;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c'}));
    }

    private static int compress(char[] chars) {
        int character = chars[0];
        int counter = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (character == chars[i]){
                counter += 1;
            }
            else{
                sb.append((char)character);
                if (counter > 1){
                    sb.append(counter);
                }
                character=chars[i];
                counter = 1;
            }
        }
        // append the last character and count
        sb.append((char)character);
        if (counter > 1){
            sb.append(counter);
        }

        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }

        return sb.length();
    }
}
