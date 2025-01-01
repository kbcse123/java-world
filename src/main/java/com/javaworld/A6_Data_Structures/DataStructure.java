package com.javaworld.A6_Data_Structures;

public interface DataStructure<E> {
    boolean add(E e);
    E remove();
    int search(E e);
    boolean isEmpty();
}
