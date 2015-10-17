package com.dalogax;

import com.dalogax.doublylinkedlist.DoublyLinkedList;
import com.dalogax.doublylinkedlist.DoublyLinkedListException;

public class Main {

    public static void main(String[] args) throws DoublyLinkedListException{
	    DoublyLinkedList<Object> list = new DoublyLinkedList<Object>();
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
        try {
            list.get(1);
        } catch (DoublyLinkedListException e) {
            System.out.println("ERROR: "+e.toString());
        }
        //list2 type string
        DoublyLinkedList<String> list2=new DoublyLinkedList<String>();
        list2.insertLast("New");
        try {
            System.out.println(list2.get(0));
        } catch (DoublyLinkedListException e) {
            System.out.println("ERROR: "+e.toString());
        }
        System.out.println(list2.getPos(list2.getFirst()));
    }
}
