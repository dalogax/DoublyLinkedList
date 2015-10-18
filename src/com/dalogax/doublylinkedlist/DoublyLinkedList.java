package com.dalogax.doublylinkedlist;

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

    /***
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

    /***
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

    /***
     * Insert a node in the index position
     * @param data The element
     * @param index The index
     */
    public synchronized void insert(E data, int index) {
        DoublyLinkedNode<E> newNode = new DoublyLinkedNode<E>(data);
        if (isEmpty()) {
            first = last = newNode;
        }
        else if (index == 0){
            insertFirst(data);
        }
        else if (index >= size()){
            throw new IndexOutOfBoundsException();
        } else {
            DoublyLinkedNode<E> oldNode = get(index);
            newNode.setPrevious(oldNode.getPrevious());
            oldNode.getPrevious().setNext(newNode);
            newNode.setNext(oldNode);
            oldNode.setPrevious(newNode);
        }
    }

    /***
     * Remove a node from the list (the node must be on the list)
     * @param node The node
     * @throws DoublyLinkedListException if the parameter is null
     */
    public synchronized void remove(DoublyLinkedNode<E> node) {
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

    public synchronized void removeFirst() {
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

    public synchronized void removeLast() {
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

    public void removeIndex(int index) {
        remove(get(index));
    }

    /***
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

    /***
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

    public DoublyLinkedNode<E> getFirst() {
        if (isEmpty()) {
            throw new DoublyLinkedListException("List is empty");
        }
        return first;
    }

    public DoublyLinkedNode<E> getLast() {
        if (isEmpty()) {
            throw new DoublyLinkedListException("List is empty");
        }
        return last;
    }

    /***
     * Returns the element in the n position of the list
     * @param index The index
     */
    public DoublyLinkedNode<E> get(int index) {
        int pos = 0;
        DoublyLinkedNode<E> node = first;
        while (node != null) {
            if (index == pos) {
                return node;
            }
            pos++;
            node = node.getNext();
        }
        throw new IndexOutOfBoundsException("The position selected is out of bounds");
    }

    /***
     * Returns the position of the node in the list
     * @param node The node
     */
    public int indexOf(DoublyLinkedNode<E> node) {
        int pos = 0;
        DoublyLinkedNode<E> nodeSearch = first;
        while (nodeSearch != null) {
            if (nodeSearch == node) {
                return pos;
            }
            pos++;
            nodeSearch = nodeSearch.getNext();
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