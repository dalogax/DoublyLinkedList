package com.dalogax.doublylinkedlist;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 16/10/15
 * Time: 16:33
 */
public class DoublyLinkedNode {

    private Object data;
    private DoublyLinkedNode next;
    private DoublyLinkedNode previous;

    public DoublyLinkedNode(Object data, DoublyLinkedNode next, DoublyLinkedNode previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public DoublyLinkedNode(Object data) {
        this(data,null,null);
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

    protected void setNext(DoublyLinkedNode next) {
        this.next = next;
    }

    public DoublyLinkedNode getPrevious() {
        return previous;
    }

    protected void setPrevious(DoublyLinkedNode previous) {
        this.previous = previous;
    }
}
