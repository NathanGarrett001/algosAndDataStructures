package recursiondemo;
import java.util.*;
/**
 * Main class for various recursive methods.
 * 
 * This class will first be used as an assignment, but afterwards it will house
 * all learned recursive methods over the years and serve as a quick solution if
 * any further assignments or work that need a basic recursion.  All methods will
 * be assigned the name directly associated to the action the method executes.
 * 
 * @author Nathan Garrett
 * @version 1.0.0 July 27, 2020
 */
public class Recursion {
    
    //These variables are used as single use variables on all the methods so far
    private int n;
    private int x;
    private int y;
    
    /**
     * Constructor for the Recursion class.
     * 
     * Initializes all variables at zero.
     */
    public Recursion(){

        this.n = 0;
        this.x = 0;
        this.y = 0; 
    }
    /**
     * Method to execute a factorial function
     * 
     * This method takes in a single integer input and executes a factorial 
     * recursive function based on the number given.  If n is less than zero, 
     * then it will call the exceptionIE method to kick back a custom exception
     * error.
     * 
     * @param n User input
     * @return the integer result of the factorial function
     */
    public static int factorial(int n){
        
        if(n < 0)
            exceptionIE("number");
        if( n != 0 )
            return n * factorial(n - 1);
        else
            return 1;
    }    
    /**
     * Method to execute a fibonacci sequence.
     * 
     * This method will accept an integer argument, and run a recursive statement
     * that will generate a fibonacci sequence as long as the user specifies. This
     * method will not display every number, it will only return the end integer
     * result.  This method and all the others as well will have a call to the
     * exceptionIE method to kick back a custom exception error.
     * 
     * @param n Integer input
     * @return The end result integer at the end of the sequence.
     */
    public static int fibonacci(int n){
        
        if(n < 0)
            exceptionIE("number");
        if(n <= 1)
            return n;    
        return fibonacci(n-1) + fibonacci(n-2);
    } 
    /**
     * Method to raise the first integer to the second integer's power.
     * 
     * This method will take two positive integers and run a recursive function
     * that will take x and raise it to the y power.  If either input is less
     * than zero, then it will call exceptionIE method.
     * 
     * @param x user's first input
     * @param y user's second input
     * @return The result integer answer from the function.
     */
    public static int power(int x, int y){
        
        if(x < 0 )
            exceptionIE("base number");
        if(y < 0 )
            exceptionIE("exponent");
        if(y != 0)
            return(x * power(x, y-1));
        else
            return 1;
    } 
    /**
     * Method to determine the GCD of two numbers.
     * 
     * This method will run a recursive search that will determine the biggest 
     * divisible number between the two inputs where there is a zero remainder.
     * That number will be returned.  Will execute exceptionIE if either input is
     * less than zero.
     * 
     * @param x user's first input
     * @param y user's second input
     * @return the result integer of the recursive search function.
     */
    public static int gcd(int x, int y){
        
        if(x < 0 )
            exceptionIE("first number");
        if(y < 0 )
            exceptionIE("second number");
        if(y != 0)
            return gcd(y, x % y);
        else
            return x;
    }
    /**
     * Method to display an IllegalArgumentException.
     * 
     * This method was me playing around with command consolidation on later,
     * longer programs.  It displays a custom IllegalArgumentException message
     * depending on the String argument.  Methods above will use this when an 
     * exception occurs.
     * 
     * @param x String argument, a word.
     * @exception IllegalArgumentException message to display that a certain number is below zero, and unusable.
     */
    public static void exceptionIE(String x){
        throw new IllegalArgumentException("Your " + x + " is below 0.");
    }
}