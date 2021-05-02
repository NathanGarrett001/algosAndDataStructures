/*******************************************************************************
 * 
 *                       Contact
 * 
 * - name  : String
 * - phone : String
 * 
 * *****************************************************************************
 * 
 * + Contact(name : String, phone : String)
 * + setName(String : name) : void
 * + setPhone(String : phone) : void
 * + getName() : String
 * + getPhone() : String
 * + toString() : String
 * 
 ******************************************************************************/
package asimpleaddressbook;


public class Contact {
    
    private String name;
    private String phone;
    

public Contact(String n, String p){
    
}

    
public void setName(String n){
    
    name = n;
    
}
public void setPhone(String p){
    
    phone = p;
    
}
public String getName(){
    
    return name;
    
}
public String getPhone(){
    
    return phone;
    
}
public String toString(){
    
    return "[" + name + ":" + phone + "]";
}

    
}
