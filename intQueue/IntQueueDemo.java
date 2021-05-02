
package intqueuedemo;

import java.util.*;
/**
 * Test program for the IntQueue class
 * 
 * This program will test the various properties of the Queue data structure.
 * This program utilizes a linked list. 
 * 
 * @author Nathan Garrett
 * @version 1.0.0 July 19, 2020
 */

public class IntQueueDemo {

    IntQueue queue;
    
    /**
     * Main method for the demo program. Calls the intro method and creates the
     * IntStackDemo object to be utilized.
     * 
     * @param args All main arguments including objects for IntQueue and IntNodeforQueue.
     */
    public static void main(String[] args) {
       
        IntQueueDemo demo = new IntQueueDemo();
        
        System.out.print("Welcome to the Super Duper Queueper Scooper!\n\n");
        intro(demo);
        
    }
    /**
     * Intro method for the display.
     * 
     * This method will display the main menu options and call various methods
     * based on the input.
     * 
     * @param demo This program as an object. 
     */
    public static void intro(IntQueueDemo demo){
        
        IntQueue queue = null;
        
        Scanner keyboard = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        int menuOption;
        boolean queueExists = false;
        
        do{
            System.out.println("----------Main Menu----------\n");
            System.out.println("[1]- Initialize Queue");
            System.out.println("[2]- Enqueue");
            System.out.println("[3]- Dequeue");
            System.out.println("[4]- Dequeue All");
            System.out.println("[5]- Queue Size");
            System.out.println("[6]- Print Queue horizontally without Dequeueing");
            System.out.print("[0]- Exit\nChoose wisely good sir...\n---> ");
            
            //This verifies that the user enters a valid integer
            if(keyboard.hasNextInt()){
                menuOption = keyboard.nextInt();
            }
            else{
                keyboard.nextLine();
                menuOption = -1;
            }
            //This is to check whether the user has initialized their stack first before moving on.
            if(!queueExists && menuOption > 1){
                System.out.print("Please initialize your queue first!\n<Press Enter>\n");
                sc.nextLine();
                continue;
            }
            //Switch case for valid user input
            switch(menuOption){
        
                case 1: // Calls for a queue initialization 
                    demo.queueInitializer(demo);
                    queueExists = true;
                    break;
                case 2:  //Calls to add an integer to the line.
                    demo.enqueue(demo);
                    break;
                case 3:  // Calls to remove the first-in node from the line.
                    demo.dequeue(demo);
                    break;
                case 4:  //Calls to remove all nodes, first in, first out.
                    demo.dequeueAll(demo);
                    break;
                case 5:  //Calls to show the size of the current queue.
                    demo.queueSize(demo);
                    break;
                case 6: // Calls for verification of a queue and then to print horizontally.
                    demo.horzPrintValid(demo, queue);
                    break;
                case 0:  //Exit option
                    System.out.println("Thank you for using the Theme park queue line simulator!");
                    break;
                default:  //error and kickback if the user supplies invalid input.
                    System.out.print("Sorry, please enter a valid menu option"
                        + " between 0 and 6.\n<Press Enter\n");
                    sc.nextLine();
                    break;
            }
        }
        //exit
        while(menuOption != 0);
        System.out.println("Goodbye!\n");
        System.exit(0);
    }
    /**
     * Method to Initialize a fresh queue.  If one already exists, it clears it 
     * and starts a new one.
     * 
     * @param demo the current program with all input so far.
     */
    public void queueInitializer(IntQueueDemo demo){
        
        Scanner sc = new Scanner(System.in);
    
        queue = new IntQueue();
    
        System.out.print("Ok, I will initialize a fresh shiny new queueueueue for you!\n<Press Enter>");
        sc.nextLine();
    }
    
    /**
     * Method to add a node to the current queue.
     * 
     * This method first verifies the input and user decision, then asks the user
     * to fill the node with an integer value.  The value is added and a node is 
     * created at the back of the line.
     * 
     * @param demo current program with all input so far.
     */
    public void enqueue(IntQueueDemo demo){
        
        Scanner keyboard = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        int input;
        
        //user verification
        System.out.print("Are you sure you want to add a new node to the back of the line?\n[1] - Yes\n[2] - No\n--->");
        if(keyboard.hasNextInt()){
            input = keyboard.nextInt();
            if(input == 1){
                System.out.print("\nWhat value will be added to the queue?  Please only use integer values.\n---->  ");
                
                //After verifying, the value is added and the action is relayed to the user.
                if(keyboard.hasNextInt()){
                    input = keyboard.nextInt();
                    queue.add(input);
                    System.out.print("Your value of [" + queue.rearPeek() + "] has been added to the line\n<Press Enter>\n");
                    sc.nextLine();
                }
                else{
                    System.out.print("Please enter a valid integer.\n<Press Enter>\n");
                    sc.nextLine();
                }
            }
            else if(input == 2){
                System.out.print("Ok, going back to the main menu.\n<Press Enter>\n");
                sc.nextLine();
            }
            //kickback to the selection if there were any typos.
            else{
                System.out.print("Please enter a valid option.\n<Press Enter>\n");
                sc.nextLine();
                enqueue(demo);
            }
        }
        //kickback to the selection if there were any typos.
        else{
            System.out.print("Please enter a valid option.\n<Press Enter>\n");
            sc.nextLine();
            enqueue(demo);
        }      
    }
    /**
     * Method to remove a node from the front of the queue.
     * 
     * This method verifies the user input and decision, then proceeds to 
     * dequeue a node from the front of the line, while displaying the action to
     * the user.
     * 
     * @param demo program with all user input so far.
     */
    public void dequeue(IntQueueDemo demo){
        
        Scanner keyboard = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        int input = 0;
    
        //User verification
        System.out.print("Are you sure you would like to dequeue the node in "
                + "front?\n[1] - Yes\n[2] - No\n---> ");
    
        if(keyboard.hasNextInt()){
            input = keyboard.nextInt();
        }
        //kickback to the beginning of this method
        else{
            System.out.print("Please enter a valid option.\n<Press Enter>\n");
            sc.nextLine();
            dequeue(demo);
        }
        //This statement does the removing and output.
        if(input == 1){
            try{
                System.out.print("You just dequeued a value of [" + queue.remove() + "] from the line.\n");
                System.out.print("Your new value in front is [" + queue.frontPeek() + "].\n<Press Enter>\n");
                sc.nextLine();
                }
                catch(IllegalArgumentException i){
                    System.out.print("Sorry, your line is empty\n<Press Enter>\n");
                    sc.nextLine();
                }
            keyboard.nextLine();
        }
        else if(input == 2){
            System.out.print("Ok, going back to the main menu.\n<Press Enter>\n");
            sc.nextLine();
        }
        //kickback to method start
        else{
            System.out.print("Sorry, invalid response.  Pleae try again.\n<Press Enter>\n");
            sc.nextLine();
            dequeue(demo);
        }
    }
    
    /**
     * Method to dequeue all nodes from the line, from front to end.
     * 
     * This method will verify user input and decision, and proceed to remove
     * nodes from the queue until empty.  Output will display the order the nodes
     * were removed.
     * 
     * @param demo current program
     */
    public void dequeueAll(IntQueueDemo demo){
        
        Scanner keyboard = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        int input = 0;
        IntQueue temp;
    
        //User verification
        System.out.print("Are you sure you want to dequeue the whole line?\n"
            + "[1] - yes\n[2] - No\n---> ");
        if(keyboard.hasNextInt()){
            input = keyboard.nextInt();
        }
        //Kickback to beginning of method
        else{
            System.out.print("Please enter a valid option.\n<Press Enter>\n");
            sc.nextLine();
            dequeueAll(demo);
        }
        if(input == 1){
        
            if(queue.isEmpty()){
                System.out.print("Sorry, your queue is empty.\n<Press Enter>\n");
                sc.nextLine();
            }
            //This part does the dequeueing in a for loop.
            else{
                System.out.print("Ok.  These are the values being dequeued, in "
                        + "order from front to rear:\n --->  ");
                for(temp = this.queue; queue.size() != 0;){
                    System.out.print("[" + queue.frontPeek() + "]  ");
                    queue.remove();
                }
                System.out.print("\n\n<Press Enter>\n");
                sc.nextLine();
            }
        }
        else if(input == 2){
            System.out.print("Ok, going back to the main menu.\n<Press Enter>\n");
            sc.nextLine();
        }
        else{
            System.out.print("Sorry, invalid response.  Please try again...\n<Press Enter>\n");
            sc.nextLine();
            dequeueAll(demo);
        }
    }   
    
    /**
     * Method to display the current size of the queue.
     * 
     * Simple call on the queue.size() method and display.
     * 
     * @param demo current program. 
     */
    public void queueSize(IntQueueDemo demo){
    
        Scanner sc = new Scanner(System.in);
        
        System.out.print("The current size of your line is " + queue.size() + 
                ".\n<Press Enter>");
        sc.nextLine();
    }
    
    /**
     * Method to tell if a queue is empty.
     * 
     * @param demo current program
     * @param queue the queue being questioned
     */
    public void horzPrintValid(IntQueueDemo demo, IntQueue queue){
        IntQueue temp = this.queue;
        Scanner sc = new Scanner(System.in);
    
        if(!temp.isEmpty()){
            //Call to the next moethod which will do the printing.
            demo.horzPrintNoDeque(queue);
        }
        else{
            System.out.print("Sorry, there is no stack to display.\n<Press Enter>\n");
            sc.nextLine();
        }
    }
    
    /**
     * Method to print the values of each node, from rear to front.
     * 
     * This method will be using 3 fro loops. One to dequeue the nodes and record
     * their value, the second will displayed saved values, and the third will 
     * enqueue the values back where they were.
     * 
     * @param queue queue being used.
     */
    public void horzPrintNoDeque(IntQueue queue){
    
        Scanner sc = new Scanner(System.in);
        IntQueue temp = this.queue;
        int qSize = temp.size();
        int[] queueVals = new int[qSize];
        int qVal;
    
        System.out.print("\n\nOk. Here's what your line looks like.\n\n\n");
        System.out.print("{ [ End ]--->");
        for(int i = 0; i < qSize ; i ++){
            qVal = temp.remove();
            queueVals[i] = qVal;
        }
        for(int i = (qSize-1); i >= 0; i--){
            qVal = queueVals[i];
            System.out.print("[NODE-" + (i + 1) + "|VAL-" + qVal + "]--->");
        }
        for(int i = 0; i < qSize ; i ++){
            qVal = queueVals[i];
            temp.add(qVal);
        }
        System.out.print("[Front] }  :D  ");
        sc.nextLine();
    }
}
