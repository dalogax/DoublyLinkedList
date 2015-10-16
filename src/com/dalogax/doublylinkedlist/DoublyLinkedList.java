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
    public synchronized void insertFirst(Object data){
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
    public synchronized void insertLast(Object data){
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
    public synchronized void remove(DoublyLinkedNode node) throws DoublyLinkedListException {
        if (contains(node)){
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
        else {
            throw new DoublyLinkedListException("The node does not exist in the list");
        }
    }
    /*
    Checks that the list contains a node
     */
    private boolean contains(DoublyLinkedNode node){
        DoublyLinkedNode nodeCheck = first;
        while (nodeCheck!=null){
            if (nodeCheck==node){
                return true;
            }
            node=node.getNext();
        }
        return false;
    }

    public synchronized void removeFirst() throws DoublyLinkedListException {
        if (!isEmpty()){
            first=first.getNext();
        }
        else{
            throw new DoublyLinkedListException("List is empty");
        }
    }

    public synchronized void removeLast() throws DoublyLinkedListException {
        if (!isEmpty()){
            last=last.getPrevious();
        }
        else{
            throw new DoublyLinkedListException("List is empty");
        }
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