package com.dalogax.doublylinkedlist;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 16/10/15
 * Time: 16:33
 */
public class DoublyLinkedList {

    private DoublyLinkedNode first;
    private DoublyLinkedNode last;

    public DoublyLinkedList() {
    }

    public void add(Object data){
        DoublyLinkedNode newNode = new DoublyLinkedNode(data, null, last);
        last.setNext(newNode);
        last=newNode;
    }

    public void print(){
        DoublyLinkedNode node = first;
        while (node!=null){
            System.out.println(node.getData().toString());
            node=node.getNext();
        }
    }

    public DoublyLinkedNode getFirst() {
        return first;
    }

    public DoublyLinkedNode getLast() {
        return last;
    }

}
