package sj223gb_assign2.exercise2;

/*
* Date: 2020-09-23.
* File Name: CollectionMain.Java
* Author: Sebastian Jonsson
*
* Copyright (c): Here comes the copyright statement if any ...
*/

/**
* Class that demonstrates the ArrayIntStack and ArrayIntList classes integration of the AbstractIntCollection class.
*
* @version 1.0 23 September 2021
* @author Sebastian Jonsson
*/
public class CollectionMain {
    
    public static void main(String[] args) {

        intListDemo();
        System.out.println("\n");
        intStackDemo();
    }

    /**
     * Runs the stack demonstration.
     */
    private static void intStackDemo() {
        ArrayIntStack stack = new ArrayIntStack();
        ArrayIntStack emptyStack = new ArrayIntStack();

        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(1);
        stack.push(5);
        stack.push(9);
        stack.push(2);
        stack.push(6);
        stack.push(5);
        stack.push(3);

        // System to printline calls toString automatically.
        System.out.println("Stack contents: " + stack);

        int poppedValue = stack.pop();
        System.out.println("Stack contents(Pop): " + stack + " - Popped: " + poppedValue + " (See above)");

        int peekValue = stack.peek();
        System.out.println("Stack contents(Peek): " + stack + " - Peeked: " + peekValue);

        System.out.println("Size of stack: " + stack.size());


        System.out.println("(Filled ArrayStack) isEmpty: " + stack.isEmpty());
        System.out.println("(Empty ArrayStack) isEmpty: " + emptyStack.isEmpty());
    }

    /**
     * Runs the list demonstration.
     */
    private static void intListDemo() {
        ArrayIntList list = new ArrayIntList();
        ArrayIntList emptyList = new ArrayIntList();
        
        list.add(7);
        list.add(5);
        list.add(6);
        list.add(8);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(-25);

        // System to printline calls toString automatically.
        System.out.println("List contents: " + list);
        list.addAt(12, 6);
        System.out.println("List after addAt: " + list);

        list.remove(2);
        System.out.println("List after remove: " + list);

        System.out.println("Size of list: " + list.size());
        System.out.println("Get specific index: " + list.get(1));

        System.out.println("(Filled ArrayList) isEmpty: " + list.isEmpty());
        System.out.println("(Empty ArrayList) isEmpty: " + emptyList.isEmpty());

        System.out.println("First encounter indexOf at: " + list.indexOf(5));
    }
}
