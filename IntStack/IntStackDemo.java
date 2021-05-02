
package intstackdemo;

import java.util.*;
/**
 * Tester Main Method for the IntStack class.
 * 
 * This program will test the functionality of the IntStack class and demonstrate
 * several properties of the Stack data structure.  This stack will utilize a
 * linked list.
 * 
 * @author Nathan Garrett
 * @version 1.0.0. July 18, 2020
 */
public class IntStackDemo {
    
    IntStack top = null;
/**
 * Main Method for the IntStack demo.
 * 
 * This is where the interface gets called.  I put the main menu in a different
 * method so that I could swap it out or change it easily.
 * 
 * @param args All of em...
 */    
public static void main(String[] args) {
        
    IntStackDemo demo = new IntStackDemo();
    System.out.println("Hello and welcome to the IntStack Demo 5000!\n\n");
    intro(demo);
}
/**
 * Method to display the main menu interface.
 * 
 * This displays an 8 part interactive menu with calls to the various functions 
 * on display. User must always enter option 1 to initialize the before being
 * able to manipulate it.  This particular program uses Linked Lists with 
 * integers as its data entry method.
 * 
 * @param demo created object for the program currently running.  Not sure yet why this works, but it does...
 */
public static void intro(IntStackDemo demo){
    
    IntStack top = null;
    Scanner keyboard = new Scanner (System.in);
    Scanner sc = new Scanner(System.in);  // Is there a better way to hold the screen before moving on besides putting sc.nextLine(), that requires less code?
    int menuOption;
    boolean stackExists = false;
    
    do{
        System.out.println("----------Main Menu----------\n");
        System.out.println("[1]- Initialize Stack");
        System.out.println("[2]- Push Value On");
        System.out.println("[3]- Pop Value Off");
        System.out.println("[4]- Pop Entire Stack");
        System.out.println("[5]- Peek Value At Top");
        System.out.println("[6]- Print Stack Size");
        System.out.println("[7]- Print vertically Without Popping");
        System.out.print("[0]- Exit\nChoose your fate...\n---> ");
    
        //This verifies that the user enters a valid integer
        if(keyboard.hasNextInt()){
            menuOption = keyboard.nextInt();
        }
        else{
            keyboard.nextLine();
            menuOption = -1;
        }
        //This is to check whether the user has initialized their stack first before moving on.
        if(!stackExists && menuOption > 1){
            System.out.print("Please initialize your stack first!\n<Press Enter>\n");
            sc.nextLine();
            continue;
        }
        //Switch case for valid user input
        switch(menuOption){
        
            case 1:  //Initializes the stack, or clears and starts a new stack over.
                demo.stackInitializer(demo);
                //sees that a stack now exists for manipulation.
                stackExists = true;
                break;
            case 2:  //Calls for the method to push a node on to the top.
                demo.stackPush(demo);
                break;
            case 3:  //Calls the method to pop the node
                demo.stackPopVal(demo);
                break;
            case 4:  //Calls the method to pop all nodes off the list, in order.
                demo.stackPopAll(demo);
                break;
            case 5:  //Calls the method to peek at the top value of the list.
                demo.stackTopPeek(top);
                break;
            case 6:  //Calls the method to print the current size of the stack by counting the nodes.
                demo.stackPrintSize(top);
                break;
            case 7:  //calls the method that verifies that there are nodes to display when calling the vertical print method.
                System.out.println("");
                demo.vertPrintValid(demo, top);
                System.out.print("");
                sc.nextLine();
                break;
            case 0:  //Exit option
                System.out.println("Thank you for using the Stack O' Tron 5 million!");
                break;
            default:  //error and kickback if the user supplies invalid input.
                System.out.print("Sorry, please enter a valid menu option"
                        + " between 0 and 7.\n<Press Enter>\n");
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
 * Method to initialize an empty stack, or to clear current stack and start over as empty.
 * 
 * @param demo object passed so the method will see the IntStack class... I think...hey it works.
 */
public void stackInitializer(IntStackDemo demo){

    Scanner sc = new Scanner(System.in);
    
    top = new IntStack();
    
    System.out.print("Ok, I will initialize a brand spankin' new empty stack for you!\n<Press Enter>");
    sc.nextLine();
}

/**
 * Method to push a node with an integer value on top of the stack.
 * 
 * @param demo IntStackDemo class with all current input
 */
public void stackPush(IntStackDemo demo){
    
    Scanner keyboard = new Scanner(System.in);
    Scanner sc = new Scanner(System.in);
    int input;
    
    //user verification
    System.out.print("Are you sure you want to push a new value?\n[1] - Yes\n[2] - No\n--->");
    if(keyboard.hasNextInt()){
        input = keyboard.nextInt();
        if(input == 1){
            System.out.print("\nWhat value would you like to add to the stack?  Please only use integer values.\n---->  ");
            
            //pushes the input value as a node on top of the stack.
            if(keyboard.hasNextInt()){
                input = keyboard.nextInt();
                top.push(input);
                System.out.print("Your value of [" + top.peek() + "] has been added to your stack.\n<Press Enter>\n");
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
            stackPush(demo);
        }
    }
    else{
        System.out.print("Please enter a valid option.\n<Press Enter>\n");
        sc.nextLine();
        stackPush(demo);
    }
}

/**
 * Method to pop the current top valued node off the stack.
 * 
 * @param demo object of current program with all current input so far. 
 */
public void stackPopVal(IntStackDemo demo){

    Scanner keyboard = new Scanner(System.in);
    Scanner sc = new Scanner(System.in);
    int input = 0;
    
    //User verification
    System.out.print("Are you sure you want to pop the current top "
            + "value?\n[1] - Yes\n[2] - No\n---> ");
    
    if(keyboard.hasNextInt()){
        input = keyboard.nextInt();
    }
    //kickback to the beginning of this method
    else{
        System.out.print("Please enter a valid option.\n<Press Enter>\n");
        sc.nextLine();
        stackPopVal(demo);
    }
    
    //This pops the valued node off and displays the value of the node that was popped.
    if(input == 1){
        try{
        System.out.print("You just popped a value of [" + top.pop() + "] from the list.\n<Press Enter>\n");
        sc.nextLine();
        }
        catch(IllegalArgumentException i){
            System.out.print("Sorry, your stack is empty\n<Press Enter>\n");
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
        stackPopVal(demo);
    }
}

/**
 * Method to pop all the nodes off the list and display them in the order they were popped.
 * 
 * @param demo Object of the main program with all current inputs.
 */
public void stackPopAll(IntStackDemo demo){
    
    Scanner keyboard = new Scanner(System.in);
    Scanner sc = new Scanner(System.in);
    int input = 0;
    IntStack temp;
    
    //User verification
    System.out.print("Are you sure you want to pop all values off the stack?\n"
            + "[1] - yes\n[2] - No\n---> ");
    if(keyboard.hasNextInt()){
        input = keyboard.nextInt();
    }
    //Kickback to beginning of method
    else{
        System.out.print("Please enter a valid option.\n<Press Enter>\n");
        sc.nextLine();
        stackPopAll(demo);
    }
    if(input == 1){
        
        //Sees if the stack is empty and returns to main menu.
        if(top.isEmpty()){
            System.out.print("Sorry, your stack is already empty.\n<Press Enter>\n");
            sc.nextLine();
        }
        //Pops all values, one by one in a loop until the stack reaches 0.
        else{
            System.out.print("Ok.  The current values being popped are as follows:\n --->  ");
            for(temp = this.top; temp.size() != 0;){
                System.out.print("[" + top.pop() + "]  ");
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
        stackPopAll(demo);
    }
}
/**
 * Method to peek at the top value on the stack and display it.
 * 
 * @param top The top of the stack in use.
 */
public void stackTopPeek(IntStack top){
    
    IntStack temp = this.top;
    Scanner sc = new Scanner(System.in);
    try{
    System.out.print("The top value is currently  [" + temp.peek() + "] !\n<Press Enter>\n");
    sc.nextLine();
    }
    catch(IllegalArgumentException i){
        System.out.print("Sorry, the stack is currently empty.\n<Press Enter>\n");
        sc.nextLine();
    }
}

/**
 * Method to print out the current size of the stack.
 * 
 * @param top Top of the stack in use
 */
public void stackPrintSize(IntStack top){
    
    Scanner sc = new Scanner(System.in);
    IntStack temp = this.top;
    System.out.print("The current size of the stack is  " + temp.size() + "  .\n<Press Enter>\n");
    sc.nextLine();
}

/**
 * Method to determine whether the stack is empty.
 * 
 * If the stack is not empty, this method calls a further method, stackPrintVertNoPop.
 * 
 * @param demo the program with all inputs so far.
 * @param top pointer to the top of the stack
 */
public void vertPrintValid(IntStackDemo demo, IntStack top){
    IntStack temp = this.top;
    Scanner sc = new Scanner(System.in);
    
    if(!temp.isEmpty()){
        demo.stackPrintVertNoPop(top);
    }
    else{
        System.out.print("Sorry, there is no stack to display.\n<Press Enter>\n");
        sc.nextLine();
    }
}

/**
 * Method to print the stack vertically, visually representing, say, a stack of dishes.
 * 
 * Recursive method to pop the stack and print the values, then push those
 * values back on.
 * 
 * @param top pointer to the top of the stack. 
 */
public void stackPrintVertNoPop(IntStack top){
    
    IntStack temp = this.top;
    
    if(temp.isEmpty()){
        return;
    }
    
    int peeker = temp.peek();
    System.out.print("  | Node " + temp.size() + " |\n  |   " + peeker + "   |\n  *********\n");
    temp.pop();
    stackPrintVertNoPop(temp);
    temp.push(peeker);
}
}


