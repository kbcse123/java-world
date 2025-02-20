package com.javaworld.A1_Core_Java.A2_ClassesAndObjects;

/**
 * @author Shaik Khader
 
 
 
 
 */
class DataStructureClass {

    private final static int SIZE = 15;
    private int[] arrayOfInts = new int[SIZE];
    
    public DataStructureClass() {
        for (int i = 0; i < SIZE; i++) {
            arrayOfInts[i] = i;
        }
    }
    
    public int size() {
        return SIZE;
    }
    
    public int get(int index) {
        return arrayOfInts[index];        
    }
    
    interface DataStructureIterator extends java.util.Iterator<Integer> { }
    
    private class EvenIterator implements DataStructureIterator {
        
        private int nextIndex = 0;
                
        public boolean hasNext() {
            return (nextIndex <= SIZE - 1);
        }        
        
        public Integer next() {
            Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);
            nextIndex += 2;
            return retValue;
        }
    }
    
    public DataStructureIterator getEvenIterator() {
        return new EvenIterator();
    }
    
    public void printEven() {
        DataStructureIterator iterator = getEvenIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public void print(DataStructureIterator iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
    
    public void print(java.util.function.Function<Integer, Boolean> function) {
        for (int i = 0; i < SIZE; i++) {
            if (function.apply(i)) {
                System.out.print(arrayOfInts[i] + " ");
            }
        }
        System.out.println();
    }
    
    public static Boolean isEvenIndex(Integer index) {
        if (index % 2 == 0) return Boolean.TRUE;
        return Boolean.FALSE;
    }
    
    public static Boolean isOddIndex(Integer index) {
        if (index % 2 == 0) return Boolean.FALSE;
        return Boolean.TRUE;
    }

}

public class B3_Anonymous_Lamba_MethodRef_Example {
	public static void main(String... args) {
		DataStructureClass ds = new DataStructureClass();
        
        System.out.println("printEven()");
        ds.printEven();
        
        System.out.println("print(DataStructureIterator) with "    
            + "getEvenIterator");
        ds.print(ds.getEvenIterator());
        
        System.out.println("print(DataStructureIterator) with "
            + "anonymous class, odd indicies");
        ds.print(
            new DataStructureClass.DataStructureIterator() {
                private int nextIndex = 1;
                public boolean hasNext() {
                    return (nextIndex <= ds.size() - 1);
                }
                public Integer next() {
                    int retValue = ds.get(nextIndex);
                    nextIndex += 2;
                    return retValue;
                }
            }
        );
        
        System.out.println("print(Function) with lambda expressions");
        ds.print(index -> {
            if (index % 2 == 0) return Boolean.TRUE;
            return Boolean.FALSE;
        });
        ds.print(index -> {
            if (index % 2 == 0) return Boolean.FALSE;
            return Boolean.TRUE;
        });
        
        System.out.println("print(Function) with method references");
        ds.print(DataStructureClass::isEvenIndex);
        ds.print(DataStructureClass::isOddIndex);
	}

}
