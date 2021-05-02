
package intstackdemo;

import java.util.*;

public class IntNodeforStacks {
     /**
     * data - The variable for containing the values for each node in the list
     */
    private int data;
    /**
     * IntNode - A reference to the class itself, a link to another node within this class. 
     */
    private IntNodeforStacks link;
/**
 * Constructor for the IntNode class.  No arguments.
 * 
 * This will initialize a new node for a given list.
 * 
 * @param data The value of the node
 * @param link The link pointer to the next node in the chain.
 */
public IntNodeforStacks(int data,IntNodeforStacks link){

    this.data = data;
    this.link = link;
}
/**
 * Getter method to return the data value of node in question
 * 
 * @return data returns the current int value for the node in question 
 */
public int getData(){

return data;    
}
/**
 * Getter method for the link pointer in the node in question.
 * 
 * This method returns a reference to the link the node in question has.  The
 * link points to the next node in the list.
 * 
 * @return link - The link reference in the current node to the next node.
 */
public IntNodeforStacks getLink(){
    
    return link;   
}
/**
 * Setter for the data in a node.
 * 
 * @param data - Sets a new int value to the node in question. 
 */
public void setData(int data){
    
    this.data = data;
}
/**
 * Sets a new link pointer for a node
 * 
 * @param link - The new pointer value for the node's link.
 */
public void setLink(IntNodeforStacks link){
    
    this.link = link;
}
/**
 * Method to add a new node
 * 
 * This method adds a new node after the node in question.
 * 
 * @param element The int value of the new node.
 */
public void addNodeAfter(int element){
    
    link = new IntNodeforStacks(element, link);
}
/**
 * Method to remove a node from the list.
 * 
 * This method removes a node by making it's link reference the node after it.
 * The node left out is auto truncated by garbage collection
 */
public void removeNodeAfter(){
    
    link = link.link;
}
/**
 * Method to return a number signifying the length of the list.
 * 
 * @param head - Head point of the current list
 * @return answer - The number signifying how many nodes there are in the list
 */
public static int listLength(IntNodeforStacks head){
    
    IntNodeforStacks cursor;
    int answer = 0;
    
    for(cursor = head; cursor != null ; cursor = cursor.link){
        answer ++;
    }
    return answer;   
}
/**
 * Method to search for a data value in a node and return the pointer to that node
 * 
 * @param head - reference to the head point in the list
 * @param target - The value that will be searched for.
 * @return cursor - The pointer to the node that has the value being searched for.
 */
public static IntNodeforStacks listSearch(IntNodeforStacks head, int target){
    
    IntNodeforStacks cursor;
    
    for(cursor = head; cursor != null; cursor = cursor.link){
        if(target == cursor.data){
            return cursor;    
        }
    }
    return null;
}
/**
 * Method to find a pointer to a specific position in a list
 * 
 * @param head - The head point of the current list
 * @param position - The node number that will be returned.  The first node starts at 1.
 * @return cursor - Returns the link to the position in question
 */
public static IntNodeforStacks listPosition(IntNodeforStacks head, int position){
    
    IntNodeforStacks cursor;
    
    if(position <= 0){
        throw new IllegalArgumentException("position is not positive.");
    }
    cursor = head;
    for(int i = 1; (i < position) && (cursor != null); i ++){
        cursor = cursor.link;
    }
    return cursor;
}
/**
 * Method to make a copy of a list
 * 
 * @param source - The list in question to be copied
 * @return copyHead The reference to the new lists head point.
 */
public static IntNodeforStacks listCopy(IntNodeforStacks source){
    
    IntNodeforStacks copyHead;
    IntNodeforStacks copyTail;
    
    if(source == null){
        return null;
    }
    
    copyHead = new IntNodeforStacks(source.data, null);
    copyTail = copyHead;
    
    while(source.link != null){
    
        source = source.link;
        copyTail.addNodeAfter(source.data);
        copyTail = copyTail.link;
    }
    return copyHead;
}
/**
 * Method to make a copy and return bot the head and tail points
 * 
 * @param source - The original list to be copied
 * @return answer - a 2 element array that carries the pointers to both the head and tail points in the new list.
 */
public static IntNodeforStacks[] listCopyWithTail(IntNodeforStacks source){
    
    IntNodeforStacks[] answer = new IntNodeforStacks[2];
    
    IntNodeforStacks copyHead;
    IntNodeforStacks copyTail;
    
    if(source == null){
        return answer;
    }
    copyHead = new IntNodeforStacks(source.data, null);
    copyTail = copyHead;
    
    while(source.link != null){
        
        source = source.link;
        copyTail.addNodeAfter(source.data);
        copyTail = copyTail.link;
    }
    answer[0] = copyHead;
    answer[1] = copyTail;
    return answer;
}
/**
 * Method to copy only part of a list
 * 
 * @param start - reference point of the node that the copy will begin with
 * @param end - where the copying stops
 * @return answer - 2 element array holding the references to the head and tail point of the partial copy.
 */
public static IntNodeforStacks[] listPart(IntNodeforStacks start, IntNodeforStacks end){

    IntNodeforStacks copyHead;
    IntNodeforStacks copyTail;
    IntNodeforStacks[] answer = new IntNodeforStacks[2];
    
    if(start == null){
        throw new IllegalArgumentException("start is null.");
    }
    if(end == null){
        throw new IllegalArgumentException("end is null.");
    }
    
    copyHead = new IntNodeforStacks(start.data, null);
    copyTail = copyHead;
    
    while(start != end){
        
        if(start == null){
            throw new IllegalArgumentException("Cannot find the end");
        }
        copyTail.addNodeAfter(start.data);
        copyTail = copyTail.link;
        }
    
    answer[0] = copyHead;
    answer[1] = copyTail;
    return answer;
    }    
}

