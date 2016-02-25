/**
 * LinkedList.java
 * Lucy Lu and Allie Warren, 3/15/14
 * Used to store anagrams
 */

import java.io.*;
import java.util.*;

/**
 * LinkedList is a singly-linked list of String, designed to introduce
 * the basic mechanisms of link list construction and use.
 */
public class LinkedList {
    private Node head;

    private class Node {
        public String key;
        public Node next; 

        public Node() {
            this.next = null;
            this.key = null;
        }

        public Node(String s) {
            this.key = s;
            this.next = null;
        }
    }

    /**
     * Default constructor
     */
    public LinkedList() {
        this.head = null;
    }

    /**
     * Appends the specified String to the end of this list
     * @param s the String to be inserted into this list. 
     */
    public void add(String s) {
        // Get a new node ready for addition to the list.
        Node newNode = new Node(s);

        // There are two cases to handle: adding to an
        // empty list or adding to a non-empty list.
        if (this.head == null) {
            this.head = newNode;
        } else {
            // To add the new node to the end of the list, we have
            // to walk from the head of the list to the very last
            // node on the list, and then attach the new node there.
            Node currentNode = this.head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    /**
     * Returns a string representation of this list.
     * @return a string representation of this list.
     */
    public String toString() {
        String stringRepresentation = "[";
        Node currentNode = this.head;
        while (currentNode != null) {
            if (currentNode != this.head) {
                stringRepresentation = stringRepresentation + ", ";
            }
            stringRepresentation = stringRepresentation + currentNode.key;
            currentNode = currentNode.next;
        }
        stringRepresentation = stringRepresentation + "]";
        return stringRepresentation;
    }

    /**
     * Prints this LinkedList to standard output, one String per line.
     */
    public void print() {
        Node currentNode = this.head;
        while (currentNode != null) {
            System.out.println(currentNode.key);
            currentNode = currentNode.next;
        }
    }

   

    /**
     * Returns the String at the specified 0-based position in this list.
     * @param index the index of the String to return.
     * @return the String at the specified index, or null if the index is out of range.
     */
    public String get(int index) {
        Node currentNode = this.head;
        for (int i=0; i<index; i++) {
                currentNode=currentNode.next;
            }
        return currentNode.key;
    }

    /**
     * Removes the String at the specified 0-based position in this list.
     * @param index the index of the String to remove.
     */
    public void remove(int index) {
        Node currentNode = this.head;
        if (index>0 && index<size()) {
            for (int i=1; i<index; i++) {
                currentNode=currentNode.next;
            }
            currentNode.next=currentNode.next.next;
        } else if (index==0) {
            this.head=currentNode.next;
        } else {
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode = null;
        }
        }

    /**
     * Returns the number of strings in this list.
     * @return the number of strings in this list.
     */
    public int size() {
        Node currentNode = this.head;
        int size = 0;
        while (currentNode != null) {
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }
    
}