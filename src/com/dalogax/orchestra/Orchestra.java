package com.dalogax.orchestra;

import com.dalogax.doublylinkedlist.DoublyLinkedList;
import com.dalogax.doublylinkedlist.DoublyLinkedListException;
import com.dalogax.doublylinkedlist.DoublyLinkedNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: dalogax@gmail.com
 * Date: 18/10/15
 * Time: 21:00
 * <p/>
 * Orchesta is a test project for the DoublyLinkedList.
 * Doubly linked lists has the advantage of being capable to have a fast access to the
 * next and previous element.
 * The assignation of sits in an orchestra(cinema, theatre,..) usually needs to access
 * to the correlative sits in order to find a place for a group of people.
 */
public class Orchestra {
    public static ArrayList<DoublyLinkedList<Sit>> orchestra;
    public static int rows;
    public static int columns;

    public static void main(String[] args) {
        orchestra = new ArrayList<DoublyLinkedList<Sit>>();
        initializeOrchestra();
        System.out.println("Welcome to the Orchestra APP");
        System.out.println("This is the status of the orchestra:");
        System.out.println("Rows: " + rows + " Columns: " + columns);
        printOrchestra();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Number of sits to reserve: ");
        try {
            Integer nSits = Integer.parseInt(br.readLine());
            System.out.print("Select a sit: ");
            Integer selectedSit = Integer.parseInt(br.readLine());
            DoublyLinkedList<Integer> assigned = assignSits(nSits, selectedSit);
            if (assigned!=null) {
                System.out.println("Assigned sits: " + assigned.toString());
            } else {
                System.out.println("Impossible to find enough correlative sits");
            }
        } catch (IOException e) {
            System.err.println("ERROR:" + e);
        } catch (DoublyLinkedListException e) {
            System.err.println("ERROR:" + e);
        }
    }

    private static DoublyLinkedList<Integer> assignSits(Integer nSits, Integer selectedSit) throws DoublyLinkedListException {
        DoublyLinkedList<Sit> row = orchestra.get((selectedSit / columns) % rows);
        DoublyLinkedNode<Sit> node = row.get((selectedSit % columns) - 1);
        DoublyLinkedNode<Sit> nodeBack = node;
        DoublyLinkedNode<Sit> nodeForward = node;
        DoublyLinkedList<Integer> assigned = new DoublyLinkedList<Integer>();
        boolean backBlocked = false;
        boolean forwardBlocked = false;
        if (!node.getData().isOccupied()) {
            node.getData().setOccupied(true);
            assigned.insertLast(node.getData().getId());
            nSits--;
            while (nSits > 0 && (!backBlocked || !forwardBlocked)) {
                if (!backBlocked) {
                    nodeBack = nodeBack.getPrevious();
                    if (nodeBack != null && !nodeBack.getData().isOccupied()) {
                        nodeBack.getData().setOccupied(true);
                        assigned.insertFirst(nodeBack.getData().getId());
                        nSits--;
                    } else {
                        backBlocked = true;
                    }
                }
                if (!forwardBlocked && nSits > 0) {
                    nodeForward = nodeForward.getNext();
                    if (nodeForward != null && !nodeForward.getData().isOccupied()) {
                        nodeForward.getData().setOccupied(true);
                        assigned.insertLast(nodeForward.getData().getId());
                        nSits--;
                    } else {
                        forwardBlocked = true;
                    }
                }
            }
            if (nSits == 0) {
                return assigned;
            } else {
                return null;
            }
        } else {
            return null;
        }

    }

    private static void initializeOrchestra() {
        Random randGen = new Random();
        rows = randGen.nextInt(10) + 10; //Random rows in range 10-20
        columns = randGen.nextInt(10) + 10; //Random columns in range 10-20
        int id = 1;
        for (int i = 0; i < rows; i++) {
            DoublyLinkedList<Sit> row = new DoublyLinkedList<Sit>();
            for (int j = 0; j < columns; j++) {
                Sit sit = new Sit(randGen.nextBoolean(), id);
                id++;
                row.insertLast(sit);
            }
            orchestra.add(row);
        }
    }

    private static void printOrchestra() {
        System.out.println();
        System.out.print("*");
        for (int i = 0; i < columns; i++) {
            System.out.print("*******");
        }
        System.out.println("*");
        for (int i = 0; i < rows; i++) {
            DoublyLinkedList<Sit> row = orchestra.get(i);
            System.out.print("*");
            try {
                DoublyLinkedNode<Sit> n = row.getFirst();
                while (n != null) {
                    Sit sit = n.getData();
                    if (sit.isOccupied()) {
                        System.out.print(" [***] ");
                    } else {
                        System.out.print(" [" + String.format("%03d", sit.getId()) + "] ");
                    }
                    n = n.getNext();
                }
                System.out.println("*");
            } catch (DoublyLinkedListException e) {
                System.err.println("ERROR:" + e);
            }
        }
        System.out.print("*");
        for (int i = 0; i < columns; i++) {
            System.out.print("*******");
        }
        System.out.println("*");
    }

}
