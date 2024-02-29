package org.charles.coding.tests;

public class Test {
    public static void main(String[] args) {
        test(0);
        test(1);
    }

    private static void test(int i){
        try{
            if (i == 0)
                throw new Exception();
            System.out.println(0);
        } catch(Exception e){
            System.out.println(1);
        } finally {
            System.out.println(2);
        }
    }
}
