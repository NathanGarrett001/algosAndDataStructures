
package sortingprogram;
import java.util.*;
/**
 * Program to demonstrate ability to make, manipulate, and sort arrays with 
 * primitive data types.
 * 
 * This program  will start off with an intro and menu screen.  You must create
 * an array of a certain size first before being able to select any other
 * options.  Once one has been created, you can fill the values sequentially 
 * from 0 to whatever size array the user chooses - 1.  The maximum array size 
 * is 1000 for now just to keep the user from overloading the system.  You can
 * also fill the elements with random, non unique values.  Another option is to 
 * shuffle the existing values.  And finally there are two sorting options.
 * One is a merge sort, and the other is the highly inefficient bubble sort.
 * Both can order the values ascending, or descending.
 * 
 * @author Nathan Garrett
 * @version 1.0.0 August 11, 2020
 */
public class SortingProgram {
    /**
     * Main method for main menu output.
     * 
     * @param args every.single.one of em...
     */
    public static void main(String[] args) {
       
        Scanner keyboard = new Scanner(System.in);
        int menuOption, maxSize = 1000, arraySize = 0;
        int[] array = null;
        int iterations = 0;
        
        // Intro
        System.out.print("Hello and welcome to the number sorter 8000!\n");
        System.out.print("In this program, you will create an array and test its\n");
        System.out.print("sorting properties.");
        pressEnter();
        //Main menu loop
        do{
            System.out.println("            -----*| MAIN MENU |*-----");
            System.out.println("*************************************************");
            System.out.println("*[1] - Choose size of array                     *");
            System.out.println("*[2] - Sequential array fill                    *");
            System.out.println("*[3] - Random array fill                        *");
            System.out.println("*[4] - Shuffle array                            *");
            System.out.println("*[5] - Print array contents                     *");
            System.out.println("*[6] - Merge Sort the array                     *");
            System.out.println("*[7] - Bubble Sort the array");
            System.out.println("*[0] - Quit                                     *");
            System.out.println("*************************************************");
            System.out.print("              Pick an option, any option!\n                    ----> ");
            //Input validation
            if(keyboard.hasNextInt()){
                menuOption = keyboard.nextInt();
            }
            else{
                keyboard.nextLine();
                menuOption = -1;
            }
            //validator for if the user created an array or not.
            if(arraySize == 0 && menuOption > 1){
            System.out.print("Please give a size for the array first!");
            pressEnter();
            continue;
        }
            switch(menuOption){
                case 1:
                    arraySize = sizeSelector();
                    array = new int[arraySize];
                    break;
                case 2:
                    sequArrayFill(array, arraySize);
                    break;
                case 3:
                    randoFill(array, arraySize);
                    break;
                case 4:
                    iterations = 0;
                    shuffleArray(array, arraySize);
                    break;
                case 5:
                    printArray(array, arraySize);
                    break;
                case 6: //The case for 6 houses some short dialogue asking whether the user wants to sort ascending or descending.
                    int mSortInput = -1;
                    while(mSortInput != 0){
                        System.out.print("Now we shall begin the magic of the MERGE SORT\n");
                        System.out.print("This took forever to get right, but here goes!\n"
                            + "would you like it to be sorted in\n[1] - Ascending\n[2] - Descending\n[0] - Go Back\n----> ");
                        if(keyboard.hasNextInt()){
                            mSortInput = keyboard.nextInt();
                            if(mSortInput == 1){
                                System.out.print("Ok, I will now sort the array in ascending order.");
                                pressEnter();
                                array = mergeSortAscend(array, arraySize);
                                iterations = log2(arraySize);
                                System.out.print("This method used " + iterations + " recursive iterations.");
                                pressEnter();
                                break;
                            }
                            else if(mSortInput == 2){
                                System.out.print("Ok, I will now sort the array in descending order.\n");
                                array = mergeSortDescend(array, arraySize);
                                iterations = log2(arraySize);
                                System.out.print("This method used " + iterations + " recursive iterations.");
                                pressEnter();
                                break;
                            }
                            else if(mSortInput == 0){
                                System.out.print("Ok, I will now go back to the menu.");
                                pressEnter();
                            }
                        }
                        else{
                            System.out.println("Please enter a valid option");
                        }
                    }
                    break;   
                case 7: //Case 7 houses some dialogue as well to determine how the sort will take place
                    int bubbleInput = -1;
                    while(bubbleInput != 0){
                        System.out.print("I will now bubble sort your array, but would you like it in\n"
                            + "[1] - Ascending order\n[2] - Descending order\n[0] - Quit\n----> ");
                        if(keyboard.hasNextInt()){
                            bubbleInput = keyboard.nextInt();
                            if(bubbleInput == 1){
                                System.out.print("Ok, I will now sort the array in ascending order.");
                                pressEnter();
                                array = bubbleSortAscend(array, arraySize);
                                break;
                            }
                            else if(bubbleInput == 2){
                                System.out.print("Ok, I will now sort the array in descending order.");
                                pressEnter();
                                array = bubbleSortDescend(array, arraySize);
                                break;
                            }
                            else if(bubbleInput == 0){
                                System.out.print("Ok, I will now go back to the menu.");
                                pressEnter();
                            }
                        }
                        else{
                            System.out.println("Please enter a valid option");
                            keyboard.next();
                        }
                    }
                    break;
                case 0:
                    System.out.println("Thank you for messing with MY array");
                    break;
                default:
                    System.out.println("You'll need to put in a valid option if you want to continue...");
                    pressEnter();
                    break;
            }
        }
        while(menuOption != 0);
            //exits the program
            System.out.println("\n                Goodbye!!\n");
            System.exit(0);
    }
    /**
     * Method for array size selection
     * 
     * @return the array size to be assigned to the array.
     */
    public static int sizeSelector(){
        int arraySize = 1;
        Scanner keyboard = new Scanner(System.in);
        boolean isValid = false;
        
        //validation menu for selecting a size.
        while(isValid == false){
            System.out.print("How many elements would you like in your array?  Only numbers between 1 to 1000 please.\n----> ");
            if(keyboard.hasNextInt()){
                int input = keyboard.nextInt();
                if(input >= 1 && input <= 1000){
                    System.out.println("Thank you.  You chose an array size of " + input + " to\n"
                            + "do super dooper scientific experiments on.");
                    pressEnter();
                    arraySize = input;
                    isValid = true;
                }
                else{
                    System.out.print("Please pick a number within range.");
                    pressEnter();
                }
            }
            else{
                System.out.print("Please pick a valid integer.");
                keyboard.next();
                pressEnter();
            }
        }
        return arraySize;
    }
    /**
     * Method to fill an array with sequential values, starting from zero
     * 
     * @param array  The array being used
     * @param arraySize The size of the array
     * @return the filled array
     */
    public static int[] sequArrayFill(int[] array, int arraySize){
        
        System.out.print("Alrighty, now I will fill in the elements of the array in\n"
                + "sequence, starting from array 0, with value 0.");
        for(int i = 0; i < arraySize; i ++){
            array[i] = i;
        }
        pressEnter();
        return array;
    }
    /**
     * Method to fill an array with non unique random integers
     * 
     * @param array the array being used
     * @param arraySize The size of the in-use array
     * @return the filled array
     */
    public static int[] randoFill(int[] array, int arraySize){
        
        int randNum;
        Random rand = new Random();
  
        System.out.print("So you don't like things all nice and organized?  Ok then, let's\n"
                + "mix it up with random numbers instead!");
        for(int i = 0; i < arraySize; i ++){
            randNum = rand.nextInt(arraySize - 0) + 0;
            array[i] = randNum;
        }
        pressEnter();
        return array;
    }
    /**
     * Method to shuffle existing values in an array
     * 
     * @param array the array being used
     * @param arraySize The size of the array
     * @return The shuffled array
     */
    public static int[] shuffleArray(int[] array, int arraySize){
        
        Random rand = new Random();
        int change;
        
        System.out.print("For this option, I will shuffle around the values in\n"
                + "your array, using the current values.");
        pressEnter();
        
        rand.nextInt();
        for(int i = 0; i < arraySize; i++){
            change = i + rand.nextInt(arraySize - i);
            swapVals(array, i, change);
        }
        return array;
    }
    /**
     * Method to swap values during the shuffle method
     * 
     * @param array array being used
     * @param i the element currently being swapped
     * @param change the value of the element i is being swapped with
     */
    public static void swapVals(int[] array, int i, int change){
        
        int dupe = array[i];
        array[i] = array[change];
        array[change] = dupe;
    }
    /**
     * Method to print the array's values.
     * 
     * @param array Array being used
     * @param arraySize The size of the in use array
     */
    public static void printArray(int[] array, int arraySize){
        
        Scanner keyboard = new Scanner(System.in);
        int input = 0;
        int spacer = 1;
        boolean goAhead = true;
        System.out.print("I will now print out your array.  If it gets too big, I\n"
                + "will go to the next line");
        pressEnter();
        //Validator to see if the user really wants all the elements displayed if it's longer than a page.
        if(arraySize > 40){
            while(input != 1 && input != 2){
                System.out.print("Your current array is over 40 elements, which would\n"
                    + "stretch off the screen if I didn't format it.  Would you\n"
                    + "like to continue?\n[1] - Yes\n[2] - No\n----> ");
                if(keyboard.hasNextInt()){
                    input = keyboard.nextInt();
                    if(input == 1){
                        System.out.print("Ok then, moving on...");
                        pressEnter();
                        break;
                    }
                    else if(input == 2){
                        System.out.print("Going back to the main menu then...");
                        goAhead = false;
                        break;
                    }
                    else{
                        System.out.println("Please enter a valid integer.");
                    }
                }
                else{
                    System.out.println("Please enter a valid response...");
                }
            }
        }
        //The next lines do the actual printing in a for loop
        if(goAhead == true){
            System.out.print("Going from left to right, then next line.\n");
            System.out.print("--------------------------------->\n");
            for(int i = 0; i < arraySize; i++){
                if(spacer == 39){
                    System.out.print("\n");
                    spacer = 1;
                }
                System.out.print(" [" + array[i] + "] ");
                spacer++;
            }
            System.out.println("\n");
            System.out.print("Aaaaand there ya go!");
            }
        pressEnter();
    }
    /**
     * Method to split up an array into smaller pieces for a merge sort in ascending order.
     * 
     * @param array array being used
     * @param arraySize Size of in-use array
     * @return the sorted array
     */
    public static int[] mergeSortAscend(int[] array, int arraySize){            //This is the method that breaks down the array into smaller element arrays, then sends them to the sorting method.
            
            if(arraySize < 2){ //returns the original array if it's 1 or smaller.
                return array;
            }
            int low = 0;
            int mid = arraySize /2;                                             //Find the middle for splitting
            int[] firstHalf = Arrays.copyOfRange(array, low, mid);              //Split the first half and copy.  I found a neat command to do this (copyOfRange).
            firstHalf = mergeSortAscend(firstHalf, mid);//Split further
            int[] secondHalf = Arrays.copyOfRange(array, mid, arraySize);       //Same with the second half
            secondHalf = mergeSortAscend(secondHalf, arraySize - mid);           //Split second further
            array = mergeAscend(firstHalf, secondHalf, mid, arraySize - mid);    //Sends all the broken down arrays to get sorted and merged back together.
        
            //returns the sorted array
            return array;
        }  
    /**
     * Method for swapping and re merging of the values in the correct order.  For ascending order.
     * 
     * @param first First element of the two element array broken down
     * @param second and the second element
     * @param a value of the first element
     * @param b value of the second element
     * @return the sorted two part array, ready to me re merged 
     */
    public static int[] mergeAscend(int[] first, int[] second, int a, int b){   //this method sorts all the broken down arrays.
        
        int[] helper = new int[a + b];                                          //Inititalizing a helper array for swapping and copying
      
        int low = 0;                                                            //helper ints for sorting
        int med = 0;
        int high = 0;
        
        while(med < a && high < b){                                             //Basically, if the first element is bigger than the second, the values get swapped.
            if( first[med] < second[high])                                      //If not then they get straight copied to the helper array and returned
                helper[low++] = first[med++];                                   //After one set is organized, it increments and works on the next one, etc, until there are no more left.
            else
                helper[low++] = second[high++];
            }
        while(med < a)                                                      
            helper[low++] = first[med++];
        while(high < b)
            helper[low++] = second[high++];
        return helper;                                                          //returns the helper array, which is the sorted one.
    }
    /**
     * Method to break down the array into smaller pieces for swapping in descending order
     * @param array the array being used
     * @param arraySize The size of the array
     * @return the sorted array
     */
    public static int[] mergeSortDescend(int[] array, int arraySize){
            
            if(arraySize < 2){ //returns the original array if it's 1 or smaller.
                return array;
            }
            int low = 0;
            int mid = arraySize /2; //Find the middle for splitting
            int[] firstHalf = Arrays.copyOfRange(array, low, mid); //Split the first half and copy.  I found a neat command to do this (copyOfRange).
            firstHalf = mergeSortDescend(firstHalf, mid);//Split further
            int[] secondHalf = Arrays.copyOfRange(array, mid, arraySize);//Same with the second half
            secondHalf = mergeSortDescend(secondHalf, arraySize - mid);  //Split second further
            array = mergeDescend(firstHalf, secondHalf, mid, arraySize - mid);  //Sends all the broken down arrays to get sorted and merged back together.
        
            //returns the sorted array
            return array;
        }
    /**
     * Method for descending order swapping of pieced array
     * @param first The first element
     * @param second The second element
     * @param a The first value in element 1
     * @param b The first value in element 2
     * @return the two piece array with the correct order
     */    
    public static int[] mergeDescend(int[] first, int[] second, int a, int b){//this method sorts all the broken down arrays.
        
        int[] helper = new int[a + b];                                //Inititalizing a helper array for swapping and copying
      
        int low = 0;                                                        //helper ints for sorting
        int med = 0;
        int high = 0;
        
        while(med < a && high < b){                                         //Basically, if the first element is bigger than the second, the values get swapped.
            if( first[med] > second[high])                                  //If not then they get straight copied to the helper array and returned
                helper[low++] = first[med++];                               //After one set is organized, it increments and works on the next one, etc, until there are no more left.
            else
                helper[low++] = second[high++];
            }
        while(med < a)                                                      
            helper[low++] = first[med++];
        while(high < b)
            helper[low++] = second[high++];
        return helper;                                                      //returns the helper array, which is the sorted one.
    }
    /**
     * Method to sort an array in ascending order using a bubble sort algorithm
     * 
     * @param array The array being used
     * @param arraySize The size of the array
     * @return The sorted array
     */
    public static int[] bubbleSortAscend(int[] array, int arraySize){
          
        int iterations = 0;
        boolean sorted = false;
        int dupe;
    
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    dupe = array[i];
                    array[i] = array[i+1];
                    array[i+1] = dupe;
                    sorted = false;
                    iterations ++;
                }
            }
        }
        //Iteration counter
        System.out.println("This method went through " + iterations + " bubble-like iterations");
        pressEnter();
        return array;
    }
    /**
     * Bubble sort method again, but this time it's in descending order
     * 
     * @param array Array being used
     * @param arraySize Size of the array
     * @return the sorted array
     */
    public static int[] bubbleSortDescend(int[] array, int arraySize){
       
        int iterations = 0;
        boolean sorted = false;
        int dupe;
    
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i+1]) {
                    dupe = array[i];
                    array[i] = array[i+1];
                    array[i+1] = dupe;
                    sorted = false;
                    iterations ++;
                }
            }
        }
        //Iteration counter
        System.out.println("This method went through " + iterations + " bubble-like iterations");
        pressEnter(); 
        return array;
    }
    /**
     * Method to stop scrolling and ask for user input to continue.
     */
    public static void pressEnter(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\n                <Press Enter>\n");
        sc.nextLine();
    }
    /**
     * Method to indirectly calculate log2(n) in java.
     * 
     * This method calculates the number of iterations in a merge sort.
     * @param n number
     * @return result of the calculation
     */
    public static int log2(int n){ 
        // calculate log2 N indirectly 
        // using log() method 
        int result = (int)(Math.log(n) / Math.log(2));
        return result; 
    }  
}
