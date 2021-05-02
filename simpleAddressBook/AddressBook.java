/*******************************************************************************
 * 
 *                   Address Book
 * 
 * - contacts : List <Contact>
 * 
 * *****************************************************************************
 * 
 * + AddressBook( List : <Contact>)
 * + add(c : Contact) : void
 * + find ( s : String) : List <Contact>
 * + toString() : String
 * 
 ******************************************************************************/
package asimpleaddressbook;

import java.util.ArrayList;
import java.util.*;

public class AddressBook {
    
    
    private ArrayList<Contact> contacts;
    
public AddressBook(){
    
    contacts = new ArrayList<Contact>();
    
}
public void add(Contact c){

    contacts.add(c);   
       
           
}
public ArrayList getList(){
    
    return contacts;
}
public String toString(){
    
    String output = "";
    
    System.out.println("Your entries are:\n");
        
    for(int index = 0; index < contacts.size(); index++){
        
    output = output + contacts.get(index) + "\n";
            }
    return output;
}
public String printElement(int i){
    
    String output = "";
    output = output + contacts.get(i) + "\n";
    
    return output;
}

}
