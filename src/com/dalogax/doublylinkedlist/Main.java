package com.dalogax.doublylinkedlist;

public class Main {

    public static void main(String[] args) {
	    DoublyLinkedList list = new DoublyLinkedList();
        System.out.println(list.toString());
        list.insertLast(1);
        System.out.println(list.toString());
        list.insertLast("dos");
        list.insertLast(new Double(3.0));
        System.out.println(list.toString());
        System.out.println("size: " + list.size());
        list.insertFirst(0);
        System.out.println(list.toString());
    }

}
