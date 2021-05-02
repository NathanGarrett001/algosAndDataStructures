
package intqueuedemo;

import java.util.*;
/**
 * Main class for an integer based queue that is connected via linked lists
 * 
 * This class will be the framework of a program that creates a simple, integer
 * based Queue data structure, all held together with a linked list.  The order 
 * for adding and removal is first in, first out.
 * 
 * @author Nathan Garrett
 * @version 1.0.0 July 19, 2020
 */

public class IntQueue {
    
    //This node will signify the front of the line.
    IntNodeforQueue front;
    //This is the node that will represent the back of the line, or the most recently added
    IntNodeforQueue rear;
    //default size will be zero.
    int size = 0;
    
    /**
     * Constructor for the IntQueue class
     * 
     * This method creates a new queue, with a size of zero, and a pointer to
     * null, where the head and the rear are equivalent.
     */
    public IntQueue(){
        
        this.front = this.rear = null;
    }
    
    /**
     * Method to check whether the queue is empty or not.
     * 
     * @return True if the queue is empty(front is null value), and false if not 
     */
    public boolean isEmpty(){
        
        return front == null;
    }
    
    /**
     * Method to add a new node to the back of the line.
     * 
     * @param data Int data value to be assigned to the new node.
     */
    public void add(int data){
        
        IntNodeforQueue temp = new IntNodeforQueue(data, null);
        
        if(this.rear == null){
            this.front = this.rear = temp;
            size ++;
            return;
        }
        this.rear.link = temp;
        this.rear = temp;
        size ++;
    }
    
    /**
     * Method to remove the node at the front of the line.
     * 
     * @return int data value of the node being removed.
     * @exception IllegalArgumentException throws if the list is empty. 
     */
    public int remove(){
        
        if(this.front == null){
            throw new IllegalArgumentException("The list is empty.");
        }
        IntNodeforQueue temp = this.front;
        int firstRemoved = front.getData();
        this.front = this.front.link;
        size --;
        
        if(this.front == null)
            this.rear = null;
        
        return firstRemoved;
    }
    
    /**
     * Method to return the current size of the queue.
     * 
     * @return int data value representing the size. 
     */
    public int size(){
        
        return size;
    }
    
    /**
     * BONUS METHODS!!  Method to peek at the rear node's assigned data value
     * 
     * I felt like I needed a way to just peek at these values at any given time
     * and they turned out pretty useful.
     * 
     * @return current int data value of the rear node.
     */
    public int rearPeek(){
        
        return this.rear.getData();   
    }
    
    /**
     * Method to peek at the data value of the front node.
     * 
     * @return int data value assigned to the front of the line.
     */
    public int frontPeek(){
        
        return this.front.getData();
    }
}
