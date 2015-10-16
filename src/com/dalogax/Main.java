package com.dalogax;

import com.dalogax.doublylinkedlist.DoublyLinkedList;
import com.dalogax.doublylinkedlist.DoublyLinkedListException;

public class Main {

    public static void main(String[] args) throws DoublyLinkedListException{
	    DoublyLinkedList list = new DoublyLinkedList();
        System.out.println(list.toString());
        list.insertLast(1);
        System.out.println(list.toString());
        list.insertLast("dos");
        list.insertLast(new Double(3.0));
        System.out.println(list.toString());
        System.out.println("size: " + list.size());
        System.out.println("First: "+list.getFirst());
        System.out.println("Last: "+list.getLast());
        list.insertFirst(0);
        System.out.println(list.toString());
        list.removeLast();
        System.out.println(list.toString());
        //Removing second node
        list.remove(list.getFirst().getNext());
        System.out.println(list.toString());
        list.removeFirst();
        System.out.println(list.toString());
        list.removeFirst();
        System.out.println(list.toString());
        try {
            list.removeFirst();
        } catch (DoublyLinkedListException e) {
            System.out.println("ERROR: "+e.toString());
        }
    }
}
