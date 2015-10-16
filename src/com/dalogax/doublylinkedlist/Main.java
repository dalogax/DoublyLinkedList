package com.dalogax.doublylinkedlist;

public class Main {

    public static void main(String[] args) {
	    DoublyLinkedList list = new DoublyLinkedList();
        System.out.println(list.toString());
        list.add(1);
        System.out.println(list.toString());
        list.add("dos");
        list.add(new Double(3.0));
        System.out.println(list.toString());
    }

}
