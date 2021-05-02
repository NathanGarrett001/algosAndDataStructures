/*
 * @author Nathan Garrett
 * @date 4-17-21
 * HW 4  Socket Programming
 * This is the Server Socket
 */
package echoserver;
import java.net.*; 
import java.io.*; 
import java.util.*;

public class EchoServer {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
    ServerSocket serverSocket = null; 

    try { 
         serverSocket = new ServerSocket(80); 
        } 
    catch (IOException e) 
        { 
         System.err.println("Could not listen on port: 12345."); 
         System.exit(1); 
        } 

    Socket clientSocket = null; 
    System.out.println ("Waiting for connection.....");

    try { 
         clientSocket = serverSocket.accept(); 
        } 
    catch (IOException e) 
        { 
         System.err.println("Accept failed."); 
         System.exit(1); 
        } 

    System.out.println ("Connection successful");
    System.out.println ("Waiting for input.....");

    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), 
                                      true); 
    BufferedReader in = new BufferedReader( 
            new InputStreamReader( clientSocket.getInputStream())); 

    String inputLine; 
    boolean done = false;
    while((inputLine = in.readLine()) != null) 
        { 
        System.out.println ("Server: " + inputLine); 
        out.println(inputLine); 
         
        Scanner fin = new Scanner(clientSocket.getInputStream());
        InputStream is = clientSocket.getInputStream();
        PrintWriter pr = new PrintWriter(clientSocket.getOutputStream(), true);
        
        Random rand = new Random();
        
        String FileName = in.readLine();
        System.out.println("Incoming File: " + FileName);
        
        int FileSize = Integer.parseInt(in.readLine());
        FileOutputStream fos = new FileOutputStream("C:\\Users\\natha\\OneDrive\\Desktop\\Java DK\\EchoServer\\src\\echoserver\\SERVER" + rand.nextInt() + ".txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte[] filebyte = new byte[FileSize];

        int file = is.read(filebyte, 0, filebyte.length);
        bos.write(filebyte, 0, file);
        
        System.out.println("Size: " + FileSize + "Byte");
        if(FileSize == file)System.out.println("File is verified");
        else System.out.println("ERROR File corrupted. File Recieved " + file + " Byte");
        pr.println("File Received.");
        bos.close();
        

         if (inputLine.equalsIgnoreCase("exit")) 
             break; 
        } 
        

    out.close(); 
    in.close(); 
    clientSocket.close(); 
    serverSocket.close(); 
   } 
}