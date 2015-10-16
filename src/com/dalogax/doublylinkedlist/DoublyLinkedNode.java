package com.dalogax.doublylinkedlist;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 16/10/15
 * Time: 16:33
 * To change this template use File | Settings | File Templates.
 */
public class DoublyLinkedNode {

    Object data;
    DoublyLinkedNode next;
    DoublyLinkedNode previous;

    public DoublyLinkedNode() {
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public DoublyLinkedNode getNext() {
        return next;
    }

    //Protected -> only this package manages the behaviour of the List
    protected void setNext(DoublyLinkedNode next) {
        this.next = next;
    }

    public DoublyLinkedNode getPrevious() {
        return previous;
    }

    //Protected -> only this package manages the behaviour of the List
    protected void setPrevious(DoublyLinkedNode previous) {
        this.previous = previous;
    }
}
