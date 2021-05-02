
package intstackdemo;

import java.util.*;
/**
 * Main class for an integer based stack that connects them with linked lists.
 * 
 * This class initializes and calls on various functions within the
 * IntNodeforStacks class.  This, with the compliment of a program to call on 
 * this class's various functions, will create and manage a stack of integers,
 * LIFO, all built on a linked list.
 * 
 * @author Nathan Garrett
 * @version 1.0.0 July 18, 2020
 */

public class IntStack{
    
    //Top of the stack to be created.
    private IntNodeforStacks top;
    //the size of the stack at any given time.
    private int size;
    
    /**
     * Constructor for the InStack object.
     * 
     * Starts an empty stack with a size of zero.
     */
    public IntStack(){
        
        this.top = null;
        this.size = 0;
    }
    
    /**
     *Determines whether or not the stack in use is full or not. 
     * 
     * @return true if the top has no value, and false if there is data at the top.
     */
    public boolean isEmpty(){
    
        return top == null;
    }
    /**
     * Method to display the top value of a stack.
     * 
     * @return the int data value of the top node
     */
    public int peek(){
    
        if(isEmpty())
            throw new IllegalArgumentException("Cannot peek, list is empty.");
    
        return top.getData();
    }
    
    /**
     * Method to remove the top node from the stack list.
     * 
     * @return the int data from the data being popped.
     */
    public int pop(){
        
        if(isEmpty())
            throw new IllegalArgumentException("Cannot pop, list is empty.");
        
        IntNodeforStacks popTop = top;
        top = popTop.getLink();
        size --;
        return popTop.getData();
    }
    
    /**
     * Method to push a new node to the top of the stack.
     * 
     * @param data int data value to be assigned to the new node.
     */
    public void push(int data){
    
        IntNodeforStacks topper = new IntNodeforStacks(data, null);
    
        if(top == null){
            top = topper;
        }
        else{
            topper.setLink(top);
            top = topper;
        }
        size ++;
    }
    
    /**
     * Method to return the size of the stack.
     * 
     * @return int data value representing the current size of the stack.  Counts
     * how many nodes there are.
     */
    public int size(){
    
        return size;
    }
}

