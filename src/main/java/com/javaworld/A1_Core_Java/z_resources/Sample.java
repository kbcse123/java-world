package com.javaworld.A1_Core_Java.z_resources;

public class Sample {
    String hi;
    String hi(){
        System.out.println(hi);
        return hi;
    }
     private static class NestedClass{
        String hiThere;
        void hiThere(){
            System.out.println(hiThere);
        }
    }

   protected class InnerClass{
        void hiThere(){
            String hi="";
            System.out.println(hi);
            class Hi{
                String there = hi;

            }
        }
    }

    public static void main(String[] args) {
        Sample.NestedClass nestedSample = new Sample.NestedClass();
        Sample.InnerClass innerSample = new Sample().new InnerClass();
    }
}
