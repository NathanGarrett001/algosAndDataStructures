package recursiondemo;
import java.util.*;
/**
 * Main tester program for the recursion class
 * 
 * This demo will call on the functions of the Recursion class and demonstrate 
 * the various recursive methods written.
 * 
 * javadoc - C:\Users\natha\OneDrive\Desktop\Java DK\RecursionDemo\dist\javadoc\index.html
 * 
 * @author Nathan Garrett
 * @version 1.0.0 July 27, 2020
 */
public class RecursionDemo {
    /**
     * Main method for the demo program.  It has the initial user display as
     * well as the main menu output.  The menu options will call the methods 
     * specific to the descriptions.
     * 
     * @param args Main arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);//This is to help me stop the screen from scrolling and let the user press enter before moving on.
        Scanner keyboard = new Scanner(System.in);
        int menuOption;
        
        //Opening menu
        System.out.print("\nThank you for becoming the proud owner of a brand new\n"
                + "Recurse-o-Tron 5000!  Below are the wonderful options\nat your "
                + "very fingertips!\n\n       <Press Enter To Experience True Power>\n");
        sc.nextLine();
        //Main menu.
        do{ 
            System.out.println("            -----*| MAIN MENU |*-----");
            System.out.println("*************************************************");
            System.out.println("*[1] - Do Factorial magic                       *");
            System.out.println("*[2] - Feel the Fibonacci experience            *");
            System.out.println("*[3] - Exponential POWER!                       *");
            System.out.println("*[4] - The Greatest of the Common Divisors      *");
            System.out.println("*[0] - Quit                                     *");
            System.out.println("*************************************************");
            System.out.print("            Go ahead, pick one...\n                ----> ");
            //This verifies that the user enters a valid integer
            if(keyboard.hasNextInt()){
                menuOption = keyboard.nextInt();
            }
            else{
                keyboard.nextLine();
                menuOption = -1;
            }
            switch(menuOption){
                //All calls for other methods are static void and execute their operations fully before coming back to the main menu.
                case 1:
                    factorialDemo();
                    break;
                case 2:
                    fibonacciDemo();
                    break;
                case 3:
                    powerDemo();
                    break;
                case 4:
                    gcdDemo();
                    break;
                case 0:// exit reply
                    System.out.println("Thank you for using the Recurse-O-Tron 5000!\nI hope your experience here was life changing.");
                    break;
                default:
                    System.out.print("Sorry, you must enter a valid menu option from 0 - 4.\n\n"
                            + "                <Press Enter>\n");
                    sc.nextLine();
            }
        }
        while(menuOption != 0 );
        //exits the program
            System.out.println("\n                Buh bye!\n");
            System.exit(0);
    }
    /**
     * Method to execute a factorial function with a single integer
     * 
     * This method will ask the user for a single, positive integer and use the
     * recursive class's factorial method to display the result which will be
     * in sentence form.
     */
    public static void factorialDemo(){
        
        Recursion demo = new Recursion();
        Scanner sc = new Scanner(System.in);
        Scanner keyboard = new Scanner(System.in);
        int input = 0;
        
        System.out.print("What number would you like to make a factorial of?\n"
                + "                ----> ");
        if(keyboard.hasNextInt()){
            input = keyboard.nextInt();
        }
        else{
            System.out.print("Sorry, please enter a valid integer."
                    + "\n                <Press Enter>\n");
            sc.nextLine();
            factorialDemo();
        }
        //The try catch is to see if they put in a positive integer.
        try{
        System.out.print("\nWell Guess what?!  The factorial of " + input + 
                    " is " + demo.factorial(input) + "!\n\n"
                            + "                <Press Enter>\n");
        sc.nextLine();
        }
        catch(IllegalArgumentException i){
            System.out.print("Sorry, your input was less than 0.  Please try again.\n\n"
                    + "                <Press Enter>\n");
            sc.nextLine();
            factorialDemo();
        }
    }   
    /**
     * Method to execute a fibonacci sequence with a single integer input.
     * 
     * This method will get a number from the user and will give the end result
     * of a fibonacci sequence who's length is determined by the user's input.
     * The input must be an integer, and also be positive.
     */
    public static void fibonacciDemo(){
        
        Scanner sc = new Scanner(System.in);
        Scanner keyboard = new Scanner(System.in);
        Recursion demo = new Recursion();
        int input = 0;
        
        System.out.print("\nHow far along the Fibonacci trail would you like to go?"
                + "                                                            "
                + "                                                            "
                + "                                (pssst...Integers only)\n"
                + "                ----> ");
        if(keyboard.hasNextInt()){
            input = keyboard.nextInt();
        }
        else{
            System.out.print("Please enter a valid integer.\n\n"
                    + "                <Press Enter>\n");
            sc.nextLine();
            fibonacciDemo();
        }
        try{
            System.out.print("Let's see... " + input + " steps down equals... "
                    + demo.fibonacci(input) + " !\n\n"
                            + "                <Press Enter>\n");
            sc.nextLine();
        }
        catch(IllegalArgumentException e){
            System.out.print("Sorry, we don't do negative numbers here...\n\n"
                    + "                <Press Enter>\n");
            sc.nextLine();
            fibonacciDemo();
        }
    }
    /**
     * Method to raise a number specified by the user by a certain power, or number
     * also specified.
     * 
     * This method will gather two inputs, both positive integers, and will use
     * the recursive class's power method to raise the first number by the second 
     * number.
     */
    public static void powerDemo(){
        
        Recursion demo = new Recursion();
        Scanner sc = new Scanner(System.in);
        Scanner keyboard = new Scanner(System.in);
        int base = 0, exponent = 0;
        //The next set of lines gathers the two inputs.
        System.out.print("\nOk, now gimme a number.  Positive integers please.\n"
                + "                ----> ");
        if(keyboard.hasNextInt()){
            base = keyboard.nextInt();
        }
        else{
            System.out.print("I said positive integers!\n\n"
                    + "                <Press Enter>\n");
            sc.nextLine();
            powerDemo();
        }
        System.out.print("What power would you like to raise this baby to?\n"
                + "                ----> ");
        if(keyboard.hasNextInt()){
            exponent = keyboard.nextInt();
        }
        else{
            System.out.print("I said positive integers!\n\n"
                    + "                <Press Enter>\n");
            sc.nextLine();
            powerDemo();
        }
        //This try catch attempt is where the recursive object is used and the
        //returned value is displayed in sentence form.
        try{
            System.out.print("\nWith your help, I give you the number " + base +
                    ",\nraised to the power of " + exponent + ",\nwhich equals... "
                    + demo.power(base, exponent) + " !\n\n"
                            + "                <Press Enter>\n");
            sc.nextLine();
        }
        catch(IllegalArgumentException e){
            System.out.print("Sorry, but one of your numbers was below 0.  Please try again :D\n\n"
                    + "                <Press Enter>\n");
            sc.nextLine();
            powerDemo();
        }
    }
    /**
     * Method to determine the greatest common divisor of two given numbers.
     * 
     * This method will first ask the user for two positive integers.  Then it
     * will execute the gcd method in the recursive class with the input given.
     * The result will be displayed in sentence form.
     */
    public static void gcdDemo(){
        
        Recursion demo = new Recursion();
        Scanner sc = new Scanner(System.in);
        Scanner keyboard = new Scanner(System.in);
        int first = 0, second = 0;
        
        System.out.print("\nAlright, now to get this started I need a number.  Positive integers only.\n"
                + "                ----> ");
        if(keyboard.hasNextInt()){
            first = keyboard.nextInt();
        }
        else{
            System.out.print("I said positive integers!\n\n"
                    + "                <Press Enter>\n");
            sc.nextLine();
            gcdDemo();
        }
        System.out.print("And another one...\n"
                + "                ----> ");
        if(keyboard.hasNextInt()){
            second = keyboard.nextInt();
        }
        else{
            System.out.print("I said positive integers!\n\n"
                    + "                <Press Enter>\n");
            sc.nextLine();
            gcdDemo();
        }
        try{
            System.out.print("Alright, so, the Greatest Common Divisor of "
                    + first + " and\n" + second + " is ------> " + 
                    demo.gcd(first, second) + " !\n\n"
                            + "                <Press Enter>\n");
            sc.nextLine();
        }
        catch(IllegalArgumentException e){
            System.out.print("Sorry, it would seem that one of your numbers"
                    + " was negative.  You know we don't do negatives around here...\n\n"
                    + "                <Press Enter>\n");
            sc.nextLine();
            gcdDemo();
        }
    }
}
