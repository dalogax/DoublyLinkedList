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

    /*
    Insert a node in the first position
     */
    public void insertFirst(Object data){
        DoublyLinkedNode newNode = new DoublyLinkedNode(data);
        if (isEmpty()) {
            first=last=newNode;
        }
        else{
            newNode.setNext(first);
            first.setPrevious(newNode);
            first=newNode;
        }
    }

    /*
    Insert a node in the last position
     */
    public void insertLast(Object data){
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

    /*
    Remove a node from the list (the node must be on the list)
     */
    public void remove(DoublyLinkedNode node){
        /*TODO
         Comprobar que el nodo pertenece a la lista
         */
        if (node==first){
            removeFirst();
        }
        else if(node==last){
            removeLast();
        }
        else{
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
        }
    }

    public void removeFirst(){
        first=first.getNext();
    }

    public void removeLast(){
        last=last.getPrevious();
    }

    public boolean isEmpty(){
        return first==null;
    }

    public int size(){
        int size = 0;
        DoublyLinkedNode node = first;
        while (node!=null){
            size++;
            node=node.getNext();
        }
        return size;
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