package bstdemo;
import java.util.*;
/**
 * Main tester program for the IntBTNode class.  
 * 
 * This program will test the various functions of a Binary tree data structure
 * created by the IntBTNode class.
 * 
 * @author Nathan Garrett
 * @version 1.0.0 August 3, 2020
 */
public class BSTDemo {  
    //the root node for the tree being initialized.
    IntBTNode root;
    public static void main(String[] args) {
        
        BSTDemo tree = new BSTDemo();
        Scanner keyboard = new Scanner(System.in);
        int menuOption;
        boolean treeExists = false;
        //Opening menu
        System.out.print("\n   Welcome to the Binary Tree experience.  We assure\n "
                       + "  your cooperation and input will be useful in our\n "
                       + "  genetic exp*%&%$^##%$#^$&^$%INTERACTIVE AND FUN PROGRAM.\n "
                       + "\n\n       <Press enter to proceed, subject>\n");
        keyboard.nextLine();
        //Main menu.
        do{ 
            System.out.println("            -----*| MAIN MENU |*-----");
            System.out.println("*************************************************");
            System.out.println("*[1] - Initialize a Tree                        *");
            System.out.println("*[2] - Insert Value into Tree                   *");
            System.out.println("*[3] - In-Order Print                           *");
            System.out.println("*[4] - Pre-Order Print                          *");
            System.out.println("*[5] - Post-Order Print                         *");
            System.out.println("*[6] - In-Order Print with Depth Indentation    *");
            System.out.println("*[0] - Exit Ze' Program                         *");
            System.out.println("*************************************************");
            System.out.print("                   Tree Away...\n                    ----> ");
            //This verifies that the user enters a valid integer
            if(keyboard.hasNextInt()){
                menuOption = keyboard.nextInt();
            }
            else{
                keyboard.nextLine();
                menuOption = -1;
            }
            //This is to check whether the user has initialized their tree first before moving on.
            if(!treeExists && menuOption > 1){
                System.out.print("\n       Please initialize your tree first!\n");
                pressEnter();
                continue;
            } 
            switch(menuOption){
                //All calls for other methods are static void and execute their operations fully before coming back to the main menu.
                case 1:
                    tree.initializer(tree);
                    treeExists = true;
                    break;
                case 2:
                    tree.insertStart(tree);
                    break;
                case 3:
                    tree.inOrderPrint(tree);
                    break;
                case 4:
                    tree.preOrderPrint(tree);
                    break;
                case 5:
                    tree.postOrderPrint(tree);
                    break;
                case 6:
                    tree.inPrintIndent(tree);
                    break;
                case 0:// exit reply
                    System.out.println("\nThank you for running the totally innocent, NOT genetic experiment\n "
                            + "related binary tree maker.  Have a wonderful day.");
                    break;
                default:
                    System.out.print("Sorry, you must enter a valid menu option from 0 - 6.\n");
                    keyboard.next();
                    pressEnter();
                    break;
            }
        }
        //Exit program.
        while(menuOption != 0 );
        //exits the program
            System.out.println("\n                [EXPERIMENT END]\n");
            System.exit(0);
    }
    /**
     * Method to initialize an empty tree.
     * 
     * @param tree Tree being used.
     */
    public void initializer(BSTDemo tree){
        
        root = new IntBTNode();
        root = null;
        System.out.print("\nI will now initialize a new tree.  Enjoy your tree. \n");
        pressEnter();
    }
    /**
     * Method to accept a new value for a new node to be created
     * 
     * This method is primarily a validator for the correct input to be fed into
     * the insert method.
     * 
     * @param tree current tree being used.
     */
    public void insertStart(BSTDemo tree){
        
        Scanner keyboard = new Scanner(System.in);
        int input;
        
        System.out.print("What Integer value would you like to add to your tree?\n"
                + "Only values between 0 - 99 inclusive will be accepted.\n ---> ");
        if(keyboard.hasNextInt()){
            input = keyboard.nextInt();
            
            if(input >= 0 && input <= 99){
                    insert(input);
                    System.out.print("\nYour value of " + input + " will be added to the tree.\n");
                    pressEnter();       
            }
            else{
                System.out.print("Please enter a number within the given range... that was just given!\n");
                pressEnter();
                insertStart(tree);
            }
        }
        else{
            System.out.print("Sorry, please enter a valid integer data type.\n");
            pressEnter();
            insertStart(tree);
        }
    }
    /**
     * Method to start an insert algorithm from the root node.
     * 
     * This method will initiate a call to the recursive method in charge of 
     * inserting a new node in the tree.  If the root is null, this method will
     * assign the value given to the root instead.
     * 
     * @param data Input data from the user.  Should be between 0 - 99 inclusive.
     */
    public void insert(int data){
        
        if(root == null){
            root = new IntBTNode(data);
        }
        else{
            insertNode(root, new IntBTNode(data));
        }
    }
    /**
     * Recursive method to place a new node in the tree.
     * 
     * This method will find the appropriate place in the tree to put the new
     * node with an int data type.
     * 
     * @param current  The current node in the search
     * @param newNode The new node to be placed
     * @return current - return the new root with the new value added.
     */
    public IntBTNode insertNode(IntBTNode current, IntBTNode newNode){
        
        if(newNode.getData() < current.getData()){
            if(current.getLeft() == null){
                current.setLeft(newNode);
            }
            else{
                insertNode(current.getLeft(), newNode);
            }
        }
        if(newNode.getData() > current.getData()){
            if(current.getRight() == null){
                current.setRight(newNode);
            }
            else{
                insertNode(current.getRight(), newNode);
            }
        }
        else{
            return current;
        }
        return current;
    }
    /**
     * Method to print out the current tree in an in-order traversal.
     * 
     * This method will print all the values of the nodes from left to right in
     * an in-order traversal of the tree.
     * 
     * @param tree The current tree being used
     */
    public void inOrderPrint(BSTDemo tree){
        
        System.out.print("This method will print the values of your tree in an\n"
                       + "in-order traversal\n");
        pressEnter();
        System.out.print("So, I will now go from left to right, and display\n"
                         + "all the nodes with their data values in the brackets.\n"
                         + "\n ---> ");
        root.inOrderPrint();
        System.out.print("\n");
        pressEnter();
    }
    /**
     * Method to print out the current tree's values from left to right, in a
     * pre-order traversal.
     * 
     * This method will ouput the values of the nodes, from left to right, in
     * the pre-order traversal.
     * 
     * @param tree current tree being used. 
     */
    public void preOrderPrint(BSTDemo tree){
        System.out.print("This method will print the values of your tree in a\n"
                       + "pre-order traversal\n");
        pressEnter();
        System.out.print("So, I will now go from left to right, and display\n"
                         + "all the nodes with their data values in the brackets.\n"
                         + "\n ---> ");
        root.preorderPrint();
        System.out.print("\n");
        pressEnter();
    }
    /**
     * Method to print the current tree's values in a post-order traversal.
     * 
     * This method will print out the values of each node from left to right, in
     * order of a post- order traversal.
     * 
     * @param tree The current tree being used
     */
    public void postOrderPrint(BSTDemo tree){
        
        System.out.print("This method will print the values of your tree in a\n"
                       + "post-order traversal.");
        pressEnter();
        System.out.print("So, I will now go from left to right, and display\n" + 
                         "all the nodes with their data value in the brackets.\n"
                       + "\n ---> ");
        root.postorderPrint();
        System.out.print("\n");
        pressEnter();
    }
    /**
     * Method to print the tree, with depth indentations.
     * 
     * This method will print out the tree with in-order traversal.  When a layer
     * of depth is achieved, the method will also indent the appropriate numbers.
     * 
     * @param tree The current tree
     */
    public void inPrintIndent(BSTDemo tree){
        
        System.out.print("This method will print the values of your tree in an\n"
                         + "in-order traversal with indentations to show the\n"
                         + "depth of the node in the tree.\n");
        pressEnter();
        System.out.print("So, I will now display all the nodes with their data\n"
                       + "value in the brackets.\n"
                       + "\n***************************");
        System.out.print("\n");
        root.print(0);
        pressEnter();
    }
    /**
     * Method to pause the screen and let the user press enter before moving on.
     */
    public static void pressEnter(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\n                <Press Enter>\n");
        sc.nextLine();
    }
}
