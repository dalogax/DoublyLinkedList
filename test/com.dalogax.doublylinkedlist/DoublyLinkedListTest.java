package com.dalogax.doublylinkedlist;


import com.dalogax.doublylinkedlist.DoublyLinkedList;

import com.dalogax.doublylinkedlist.DoublyLinkedListException;
import com.dalogax.doublylinkedlist.DoublyLinkedNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: dalogax@gmail.com
 * Date: 18/10/15
 * Time: 16:58
 */
public class DoublyLinkedListTest {

    @Test
    public void getDataTest(){
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        Integer i = 1;
        try {
            list.insertLast(i);
            assertEquals(list.getFirst().getData(), i);
        } catch (DoublyLinkedListException e) {
            fail("ERROR:" + e.toString());
        }

    }

    @Test
    public void insertAndGetFirstLastTest(){
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        try {
            list.insertLast(1);
            assertEquals(list.getFirst(), list.getLast());
            list.insertLast(2);
            assertNotSame(list.getFirst(), list.getLast());
        } catch (DoublyLinkedListException e) {
            fail("ERROR:" + e.toString());
        }

    }

    @Test(expected = DoublyLinkedListException.class)
    public void insertFirstExceptionTest() throws DoublyLinkedListException {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        list.insertFirst(null);
        fail("ERROR: shouldnt reach here");
    }

    @Test(expected = DoublyLinkedListException.class)
    public void insertLastExceptionTest() throws DoublyLinkedListException {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        list.insertLast(null);
        fail("ERROR: shouldnt reach here");
    }

    @Test(expected = DoublyLinkedListException.class)
    public void getFirstExceptionTest() throws DoublyLinkedListException {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        list.getFirst();
        fail("ERROR: shouldnt reach here");
    }

    @Test(expected = DoublyLinkedListException.class)
    public void getLastExceptionTest() throws DoublyLinkedListException {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        list.getLast();
        fail("ERROR: shouldnt reach here");
    }

    @Test
    public void getAndGetPosTest(){
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        try {
            list.insertLast(0);
            list.insertLast(1);
            list.insertLast(2);
            list.insertLast(3);
            DoublyLinkedNode node = list.get(2);
            assertEquals(list.getPos(node), 2);
            assertEquals(node.getData(),2);
        } catch (DoublyLinkedListException e) {
            fail("ERROR:"+e.toString());
        }
    }

    @Test(expected = DoublyLinkedListException.class)
    public void getPosExceptionTest() throws DoublyLinkedListException {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        list.insertLast(1);
        DoublyLinkedNode node = list.getFirst();
        list.removeLast();
        list.getPos(node);
        fail("ERROR: shouldnt reach here");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getExceptionTest() throws DoublyLinkedListException {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        list.get(2);
        fail("ERROR: shouldnt reach here");
    }

    @Test
    public void objectListAndSizeTest(){
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>();
        assertEquals(list.size(),0);
        try {
            list.insertLast(1);
            list.insertLast("dos");
            list.insertLast(new Double(3.0));
        } catch (DoublyLinkedListException e) {
            fail("ERROR:" + e.toString());
        }

        assertEquals(list.size(),3);
    }

    @Test
    public void isEmptyTest(){
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>();
        assertTrue(list.isEmpty());
        try {
            list.insertLast(1);
        } catch (DoublyLinkedListException e) {
            fail("ERROR:" + e.toString());
        }
        assertFalse(list.isEmpty());
    }

    @Test
    public void removeFirstAndLastTest(){
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>();
        try {
            list.insertLast(2);
            list.removeFirst();
            assertTrue(list.isEmpty());
            list.insertFirst(1);
            list.insertFirst(0);
            list.removeLast();
            assertEquals(list.size(), 1);
            assertEquals(list.getFirst().getData(),0);
            list.insertLast(1);
            assertEquals(list.size(), 2);
            list.removeFirst();
            assertEquals(list.size(), 1);
        } catch (DoublyLinkedListException e) {
            fail("ERROR:" + e.toString());
        }

    }

    @Test(expected = DoublyLinkedListException.class)
     public void removeFirstExceptionTest() throws DoublyLinkedListException {
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>();
        list.removeFirst();
        fail("ERROR: shouldnt reach here");
    }

    @Test(expected = DoublyLinkedListException.class)
    public void removeLastExceptionTest() throws DoublyLinkedListException {
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>();
        list.removeLast();
        fail("ERROR: shouldnt reach here");
    }

    @Test
    public void removeTest(){
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>();
        try {
            list.insertLast(1);
            list.insertLast(2);
            list.insertLast(3);
            assertEquals(list.size(),3);
            list.remove(list.get(1));
            assertEquals(list.size(),2);
            list.remove(list.getLast());
            assertEquals(list.size(),1) ;
            list.remove(list.getFirst());
            assertTrue(list.isEmpty());
        } catch (DoublyLinkedListException e) {
            fail("ERROR:" + e.toString());
        }

    }

    @Test(expected = DoublyLinkedListException.class)
    public void removeExceptionTest() throws DoublyLinkedListException {
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>();
        list.insertLast(1);
        DoublyLinkedNode node = list.getFirst();
        list.remove(node);
        list.remove(node);
        fail("ERROR: shouldnt reach here");
    }

    @Test
    public void containsTest(){
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>();
        try {
            list.insertLast(1);
            list.insertLast(2);
            list.insertLast(3);
            list.insertLast(4);
            assertTrue(list.contains(1));
            list.removeFirst();
            assertFalse(list.contains(6));
        } catch (DoublyLinkedListException e) {
            fail("ERROR:" + e.toString());
        }
    }

    @Test
    public void toStringTest(){
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>();
        try {
            list.insertLast(1);
            list.insertLast("dos");
            list.insertLast(new Double(3.0));
            assertEquals(list.toString(),"[{1}, {dos}, {3.0}]");
        } catch (DoublyLinkedListException e) {
            fail("ERROR:" + e.toString());
        }
    }
}
