package com.dalogax.doublylinkedlist;

/**
 * Created with IntelliJ IDEA.
 * User: dalogax@gmail.com
 * Date: 16/10/15
 * Time: 16:33
 */
public class DoublyLinkedList<E> {

    private DoublyLinkedNode first;
    private DoublyLinkedNode last;

    public DoublyLinkedList() {
        first=last=null;
    }

    /*
    Insert a node in the first position
     */
    public synchronized void insertFirst(E data) throws DoublyLinkedListException {
        if(data==null){
            throw new DoublyLinkedListException("The object is null");
        }
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
    public synchronized void insertLast(E data) throws DoublyLinkedListException {
        if(data==null){
            throw new DoublyLinkedListException("The object is null");
        }
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
            if (node.isFirst()){
                removeFirst();
            }
            else if(node.isLast()){
                removeLast();
            }
            else{
                node.getPrevious().setNext(node.getNext());
                node.getNext().setPrevious(node.getPrevious());
            }
        }
        else {
            throw new DoublyLinkedListException("The node is not in the list");
        }
    }

    public synchronized void removeFirst() throws DoublyLinkedListException {
        if (!isEmpty()){
            if (first==last){
                first=last=null;
            }
            else{
                first=first.getNext();
                first.setPrevious(null);
            }
        }
        else{
            throw new DoublyLinkedListException("List is empty");
        }
    }

    public synchronized void removeLast() throws DoublyLinkedListException {
        if (!isEmpty()){
            if (first==last){
                first=last=null;
            }
            else{
                last=last.getPrevious();
                last.setNext(null);
            }
        }
        else{
            throw new DoublyLinkedListException("List is empty");
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
            nodeCheck=nodeCheck.getNext();
        }
        return false;
    }

    /*
   Checks that the list contains a node with an element
   */
    public boolean contains(E element){
        DoublyLinkedNode nodeCheck = first;
        while (nodeCheck!=null){
            if (nodeCheck.getData().equals(element)){
                return true;
            }
            nodeCheck=nodeCheck.getNext();
        }
        return false;
    }

    public DoublyLinkedNode getFirst() throws DoublyLinkedListException {
        if(isEmpty()){
            throw new DoublyLinkedListException("List is empty");
        }
        return first;
    }

    public DoublyLinkedNode getLast() throws DoublyLinkedListException {
        if(isEmpty()){
            throw new DoublyLinkedListException("List is empty");
        }
        return last;
    }

    /*
    Returns the element in the n position of the list
     */
    public DoublyLinkedNode get(int i) throws IndexOutOfBoundsException {
        int pos = 0;
        DoublyLinkedNode node = first;
        while (node!=null){
            if (i==pos){
                return node;
            }
            pos++;
            node=node.getNext();
        }
        throw new IndexOutOfBoundsException("The position selected is out of bounds");
    }

    /*
    Returns the position of the node in the list
     */
    public int getPos(DoublyLinkedNode n) throws DoublyLinkedListException {
        int pos = 0;
        DoublyLinkedNode node = first;
        while (node!=null){
            if (node==n){
                return pos;
            }
            pos++;
            node=node.getNext();
        }
        throw new DoublyLinkedListException("The node is not in the list");
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
            sList+="{"+node.toString()+"}";
            if (node.getNext()!=null){
                sList+=", ";
            }
            node=node.getNext();
        }
        sList+="]";
        return sList;
    }
}