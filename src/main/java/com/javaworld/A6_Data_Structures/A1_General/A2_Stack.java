package com.javaworld.A6_Data_Structures.A1_General;
/**
 *
 */

import java.util.Random;

/**
 * @author Shaik Khader
 *
 *         A stack or LIFO (last in, first out) is an abstract data type that
 *         serves as a collection of elements, with two principal operations:
 *         push, which adds an element to the collection, and pop, which removes
 *         the last element that was added. In stack both the operations of push
 *         and pop takes place at the same end that is top of the stack. It can
 *         be implemented by using both array and linked list.
 *
 *         Insertion : O(1) Deletion : O(1) Access Time : O(1) [Peek]
 *
 *         Insertion and Deletion at one end.
 *
 *         Applications of stack :
 *
 *         .Stacks are used for maintaining function
 *         calls (the last called function must finish execution first), we can
 *         always remove recursion with the help of stacks.
 *
 *         .Stacks are also used in cases where we have to reverse a word, check
 *         for balanced parenthesis and in editors where the word you typed the
 *         last is the first to be removed when you use undo operation.
 *
 *         .To implement forward and back functionality in web browsers.
 *
 *         .Backtracking in an algorithm.
 *
 */

class MyStack {
    int size, top;
    int[] stack; // Maximum size of Stack

    boolean isEmpty() {
        return (top < 0);
    }

    boolean isFull() {
        return (top == (size - 1));
    }

    MyStack(int size) {
        top = -1;
        this.size = size;
        stack = new int[size];
    }

    boolean push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow... Cannot push -> " + x);
            return false;
        } else {
            System.out.println("Item pushed -> " + x);
            stack[++top] = x;
            return true;
        }
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow...");
            return 0;
        } else {
            System.out.println("\n\nItem popped -> " + peek());
            int x = stack[top];
            stack[top--] = 0; // optional
            return x;
        }
    }

    int peek() {
        return stack[top];
    }

    void printStack() {
        for (int a : stack) {
            System.out.print(a + " | ");
        }
    }

}

public class A2_Stack {
    public static void main(String... args) {
        basicDemo();
    }

    private static void basicDemo() {
        MyStack stack = new MyStack(10);
        System.out.println("\n*** PUSH Operation ***");
        while (!stack.isFull()) {
            stack.push(new Random().nextInt(100));
        }
        System.out.println("\n*** POP Operation ***");
        stack.printStack();
        while (!stack.isEmpty()) {
            stack.pop();
            stack.printStack();

        }

    }

}
