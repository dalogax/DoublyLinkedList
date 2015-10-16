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
        DoublyLinkedNode newNode = new DoublyLinkedNode(data);
        if (isEmpty()) {
            first=last=newNode;
        }
        else{
            newNode.setPrevious(last);
            last.setNext(newNode);
            last=newNode;
        }
    }

    public boolean isEmpty(){
        return first==null;
    }

    @Override
    public String toString(){
        String sList = "[";
        DoublyLinkedNode node = first;
        while (node!=null){
            sList+="{"+node.getData().toString()+"}";
            if (node.getNext()!=null){
                sList+=", ";
            }
            node=node.getNext();
        }
        sList+="]";
        return sList;
    }

    public DoublyLinkedNode getFirst() {
        return first;
    }

    public DoublyLinkedNode getLast() {
        return last;
    }

}