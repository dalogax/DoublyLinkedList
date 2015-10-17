package com.dalogax.doublylinkedlist;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 16/10/15
 * Time: 17:59
 */

public class DoublyLinkedNode<E> {

    private E data;
    private DoublyLinkedNode next;
    private DoublyLinkedNode previous;

    protected DoublyLinkedNode(E data, DoublyLinkedNode next, DoublyLinkedNode previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    protected DoublyLinkedNode(E data) {
        this(data,null,null);
    }

    protected DoublyLinkedNode() {
        this(null,null,null);
    }

    public boolean isFirst(){
        return previous==null;
    }

    public boolean isLast(){
        return next==null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
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

    @Override
    public String toString() {
        return data.toString();
    }
}
