package com.dalogax.doublylinkedlist;

import java.security.InvalidParameterException;

/**
 * Created with IntelliJ IDEA.
 * User: dalogax@gmail.com
 * Date: 16/10/15
 * Time: 16:33
 */
public class DoublyLinkedList<E> {

    private DoublyLinkedNode<E> first;
    private DoublyLinkedNode<E> last;

    public DoublyLinkedList() {
        first = last = null;
    }

    /*
     * Insert a node in the first position
     * @param data The element
     */
    public synchronized void insertFirst(E data){
        DoublyLinkedNode<E> newNode = new DoublyLinkedNode<E>(data);
        if (isEmpty()) {
            first = last = newNode;
        } else {
            newNode.setNext(first);
            first.setPrevious(newNode);
            first = newNode;
        }
    }

    /*
     * Insert a node in the last position
     * @param data The element
     */
    public synchronized void insertLast(E data) {
        DoublyLinkedNode<E> newNode = new DoublyLinkedNode<E>(data);
        if (isEmpty()) {
            first = last = newNode;
        } else {
            newNode.setPrevious(last);
            last.setNext(newNode);
            last = newNode;
        }
    }

    /*
     * Remove a node from the list (the node must be on the list)
     * @param node The node
     * @throws DoublyLinkedListException if the parameter is null
     */
    public synchronized void remove(DoublyLinkedNode<E> node) throws DoublyLinkedListException {
        if (contains(node)) {
            if (node.isFirst()) {
                removeFirst();
            } else if (node.isLast()) {
                removeLast();
            } else {
                node.getPrevious().setNext(node.getNext());
                node.getNext().setPrevious(node.getPrevious());
            }
        } else {
            throw new DoublyLinkedListException("The node is not in the list");
        }
    }

    public synchronized void removeFirst() throws DoublyLinkedListException {
        if (!isEmpty()) {
            if (first == last) {
                first = last = null;
            } else {
                first = first.getNext();
                first.setPrevious(null);
            }
        } else {
            throw new DoublyLinkedListException("List is empty");
        }
    }

    public synchronized void removeLast() throws DoublyLinkedListException {
        if (!isEmpty()) {
            if (first == last) {
                first = last = null;
            } else {
                last = last.getPrevious();
                last.setNext(null);
            }
        } else {
            throw new DoublyLinkedListException("List is empty");
        }
    }

    /*
    * Checks that the list contains a node
    * @param node The node
    */
    private boolean contains(DoublyLinkedNode<E> node) {
        DoublyLinkedNode<E> nodeCheck = first;
        while (nodeCheck != null) {
            if (nodeCheck == node) {
                return true;
            }
            nodeCheck = nodeCheck.getNext();
        }
        return false;
    }

    /*
     * Checks that the list contains a node with an element
     * @param element The element
     */
    public boolean contains(E element) {
        DoublyLinkedNode<E> nodeCheck = first;
        while (nodeCheck != null) {
            if (nodeCheck.getData().equals(element)) {
                return true;
            }
            nodeCheck = nodeCheck.getNext();
        }
        return false;
    }

    public DoublyLinkedNode<E> getFirst() throws DoublyLinkedListException {
        if (isEmpty()) {
            throw new DoublyLinkedListException("List is empty");
        }
        return first;
    }

    public DoublyLinkedNode<E> getLast() throws DoublyLinkedListException {
        if (isEmpty()) {
            throw new DoublyLinkedListException("List is empty");
        }
        return last;
    }

    /*
     * Returns the element in the n position of the list
     * @param i The index
     */
    public DoublyLinkedNode<E> get(int i) throws IndexOutOfBoundsException {
        int pos = 0;
        DoublyLinkedNode<E> node = first;
        while (node != null) {
            if (i == pos) {
                return node;
            }
            pos++;
            node = node.getNext();
        }
        throw new IndexOutOfBoundsException("The position selected is out of bounds");
    }

    /*
     * Returns the position of the node in the list
     * @param node The node
     */
    public int getPos(DoublyLinkedNode<E> n) throws DoublyLinkedListException {
        int pos = 0;
        DoublyLinkedNode<E> node = first;
        while (node != null) {
            if (node == n) {
                return pos;
            }
            pos++;
            node = node.getNext();
        }
        throw new DoublyLinkedListException("The node is not in the list");
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void clear(){
        first = last = null;
    }

    public int size() {
        int size = 0;
        DoublyLinkedNode<E> node = first;
        while (node != null) {
            size++;
            node = node.getNext();
        }
        return size;
    }

    @Override
    public String toString() {
        String sList = "[";
        DoublyLinkedNode<E> node = first;
        while (node != null) {
            sList += "{" + node.toString() + "}";
            if (node.getNext() != null) {
                sList += ", ";
            }
            node = node.getNext();
        }
        sList += "]";
        return sList;
    }
}