package sj223gb_assign2.exercise4;

/*
* Date: 2020-09-27.
* File Name: Queue.Java
* Author: Sebastian Jonsson
*
* Copyright (c): Here comes the copyright statement if any ...
*/

/**
* Class that implements an interface for iterable generic queues.
*
* @version 1.0 24 September 2021
* @author Sebastian Jonsson
*/
public interface Queue<E> extends Iterable<E> {
    int size();
    boolean isEmpty();
    void enqueue(E element);
    E dequeue();
    E first();
    E last();
}
