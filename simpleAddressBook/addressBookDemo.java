/*******************************************************************************
 *                          A Simple Address Book
 * 
 * @author  Nathan Garrett
 * @date    02/15/2020
 * 
 * Goal:
 * To create a program that allows a user to add names and phone numbers to an
 * empty address book in the form of an array list.  The program does not save
 * any data.
 * 
 * Algorithm
 * 
 * 1.  Main Method
 *      call method "mainMenu"
 * 
 * 2.  Method 1, mainMenu
 *      Call Scanner for keyboard.
 *      Create String called input.
 *      Display a panel with 4 options.  ADD, FIND, PRINT, and QUIT.  The 5th 
 *      option is "INVALID" for incorrect inputs.
 *      Input to Upper case and start a switch case conditional statement.
 *      IF input .equals ADD
 *      Call method 2, "addContact"
 * 
 *      IF input .equals FIND
 *      Call method 3, "findContact"
 * 
 *      IF input .equals PRINT
 *      Prints the total arrayList thus far
 * 
 *      IF input .equals QUIT
 *      Call method 5, "quitDisplay"
 * 
 *      IF input !.equals any of the four options
 *      Display invalid command then call method 1, "mainMenu"
 * 
 * 3.  Method 2, addContact
 *      Call Scanner for Keyboard
 *      Create two Strings, name and address.
 *      Display small "add" header, then prompt the user for the name, then the
 *      address.
 *      Once user inputs, then call the "Contact" class and feed the values to
 *      it,
 *      Then open the Address Book class and add the Contact to the array list.
 *      Display the strings and confirm that info has been added.
 *      Call Method 1, mainMenu.
 * 
 * 4.  Method 3, findContact
 *      Create Scanner for the keyboard
 *      Create a String for input
 *      Display a small header, "Find"
 *      Prompt user for input to find.
 *      compare input with regex to the Address Book class
 *      find and display the contents of the elements that match search term.
 *      Next Line
 *      Call method 1, mainMenu
 * 
 * 6.  Method 5, quit
 *      Display a goodbye message
 *      System.exit(0).
 * 
 * 7.  Class Contact
 *      Class holds value to be fed into the Address Book class
 * 
 * 8.  Class Address Book
 *      Class is an array list that holds instances of the Contact class
 *      within each element.  Starts with zero slots and increases as more 
 *      contacts are added.The toString displays all the contents of the 
 *      array list.  
 */
package asimpleaddressbook;

import java.util.*;

public class ASimpleAddressBook {

 
    
    public static void main(String[] args) {
        AddressBook book = new AddressBook();                                   //Initializes the address book
        mainMenu(book);                                                         //calls fr the main menu
    
    }
    public static void mainMenu(AddressBook book){                                  
        
        Scanner keyboard = new Scanner(System.in);                              //Keyboard initialization
        String input;
        
        
        System.out.print(                                                       //display readout
        "  ~~Address Book 9000~~  \n" + 
        "+-----------------------+\n" + 
        "                         \n" +
        "ADD    Adds a contact    \n" +
        "FIND   Finds a contact   \n" +
        "PRINT  Prints a contact  \n" +
        "+-----------------------+\n" +
        "                         \n" + 
        "Please enter an option   \n" +
        "----->");
        
        input = keyboard.nextLine();                                            //Input holding and pushing it to upper case
        input = input.toUpperCase();
        
        switch(input){                                                          //switch case for the 4 different options
            
            case "ADD":
                addContact(book);                                               //calls the add contact method
                break;
            case "FIND":                                                        //calls the find method
                findContact(book);
                break;
            case "PRINT":                                                       // prints all the contents of the arrayList
                String display = book.toString();                                   
                System.out.println(display);
                keyboard.nextLine();
                mainMenu(book);
                break;
            case "QUIT":                                                        // calls the quit method
                quit();
                break;
            default:                                                            // error verification
                System.out.println("Error: Invalid command");
                mainMenu(book);                                                 // repeats the menu
        }
        
        
    }
    public static void addContact(AddressBook book){
        
        Scanner keyboard = new Scanner(System.in);
        String name, phone;                                                     // Initilizing the keyboard, name and phone variables, as well as making a regex check for phone number entry.
        String regex = "[\\d]{3}[-][\\d]{3}[-][\\d]{4}";
        
        System.out.print("----> ADD CONTACT\n\n" +                              // display output
                           " NAME         ---> ");
        name = keyboard.nextLine();                                             // input for name
        
        System.out.print(" PHONE NUMBER ---> ");                                        
        phone = keyboard.nextLine();                                            // input for phone
        
        while(!phone.matches(regex)){                                           //validation that checks for the user to enter a 10 digit phone number with no special characters using regex
            System.out.println("Invalid entry.  Please enter a ten digit phone"
                    + " number with dashes.  ex, ###-###-####.");
            phone = keyboard.nextLine();
        }
        
        
        Contact contact = new Contact(name, phone);                             //Initializing the contact class
        contact.setName(name);
        contact.setPhone(phone);
        
        
        book.add(contact);                                                      // adding to the book, which is an array list.
        
        System.out.println("[" + name + " : " + phone + "] has been added.");   // verify to the user that it is added.
        keyboard.nextLine();
        
        mainMenu(book);                                                         // loop the main menu, carrying the updated address book
        
    }
    public static void findContact(AddressBook book){
        
        ArrayList<Contact> clone = new ArrayList<Contact>();                    //Creates a clone of the address book for size referencing
        clone = book.getList();
        Scanner keyboard = new Scanner(System.in);                              // keyboard again
        String input;                                                           // holds the search term
        
        System.out.print("----->FIND\n" +                                       //display
                           "---WHAT---> ");
        input = keyboard.nextLine();
        
        int listLength = clone.size();                                          //giving a list length so I can go through each object
        
        for(int i = 0; i < listLength; i ++){                                   // loop for that
            
            if(book.printElement(i).contains(input)){                           // this asks if anything in the element matches the search term.  I had to add a method that printed out each individual object for scanning
                String display = book.printElement(i);          
                System.out.println(display);                                    // displays the contents of the element or elements that matches
            }
            
        }
        keyboard.nextLine();                                                    // so you can stop and look at it.
        mainMenu(book);                                                         // back to main!

    }
    public static void quit(){                                                  // Quits the program with a display
        
        System.out.println("Have a nice day!");
        System.exit(0);
    }   
}
