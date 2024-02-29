package org.charles.coding.leetcode;

public class IsSubsequence {
    public static void main(String[] args) {
//        System.out.println("abc".indexOf('d'));
        System.out.println(isSubsequenceV2("abc", "abe"));
    }

    private static boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;
        else if (t.length() == 0)
            return false;
        else {
            StringBuilder sb = new StringBuilder(t);
            for (char c : s.toCharArray()) {
                if (sb.indexOf(String.valueOf(c)) == -1)
                    return false;
                else
                    sb.delete(0,sb.indexOf(String.valueOf(c))+1);
            }
            return true;
        }
    }

    private static boolean isSubsequenceV2(String s, String t) {
        int i = 0;
        int j = 0;

        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
