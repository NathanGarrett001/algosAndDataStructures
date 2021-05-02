/*
 * @author Nathan Garrett
 * @date 4-17-21
 * HW 4  Socket Programming
 * This is the Server Socket
 */
package echoclient;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.util.*;

public class EchoClient {

    public static void main(String[] args) throws IOException{
        
        Scanner keyboard = new Scanner(System.in);
        String port = null;
        
        System.out.println("Welcome to FTP 9000!");
        System.out.print("Please select a port(just put primary): ");
        
        port = keyboard.nextLine();
        
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        int portNum;
        
        if(port.equalsIgnoreCase("primary") || port.equalsIgnoreCase("")){
            
            portNum = 80;

            String serverHostname = new String ("127.0.0.1");

                if (args.length > 0)
                   serverHostname = args[0];
                System.out.println ("Attemping to connect to host " +
                        serverHostname + " on port " + port + ".");



                try {
                    echoSocket = new Socket(serverHostname,portNum);
                    out = new PrintWriter(echoSocket.getOutputStream(), true);
                    in = new BufferedReader(new InputStreamReader(
                                                echoSocket.getInputStream()));
                } catch (UnknownHostException e) {
                    System.err.println("Don't know about host: " + serverHostname);
                    System.exit(1);
                } catch (IOException e) {
                    System.err.println("Couldn't get I/O for "
                                       + "the connection to: " + serverHostname);
                    System.exit(1);
                }
        }
        else{
            portNum = -1;

            String serverHostname = new String ("127.0.0.1");

                if (args.length > 0)
                    serverHostname = args[0];
                    System.out.println ("Attemping to connect to host " +
                        serverHostname + " on port " + port + ".");

                try {
                    echoSocket = new Socket(serverHostname,portNum);
                    out = new PrintWriter(echoSocket.getOutputStream(), true);
                    in = new BufferedReader(new InputStreamReader(
                                                echoSocket.getInputStream()));
                } catch (UnknownHostException e) {
                    System.err.println("Don't know about host: " + serverHostname);
                    System.exit(1);
                } catch (IOException e) {
                    System.err.println("Couldn't get I/O for "
                                       + "the connection to: " + serverHostname);
                    System.exit(1);
                }
        }
            BufferedReader stdIn = new BufferedReader(
                                       new InputStreamReader(System.in));
            String userInput = null;

            System.out.println("Type EXIT to close.");
            System.out.print ("input: ");

            while ((userInput = stdIn.readLine()) !=  null ) {
                out.println(userInput);
                try{
                    System.out.println("echo: " + in.readLine());

                    if(userInput.equalsIgnoreCase("exit")) 
                    {System.out.println("Socket Closing");break;}


                        String FileName = "C:\\Users\\natha\\OneDrive\\Desktop\\Java DK\\EchoClient\\src\\echoclient\\relay.txt";
                        File MyFile = new File(FileName);
                        int FileSize = (int) MyFile.length();
                        OutputStream outStream =echoSocket.getOutputStream();
                        PrintWriter pr = new PrintWriter(echoSocket.getOutputStream(), true);
                        BufferedInputStream bInStream = new BufferedInputStream(new FileInputStream(MyFile));
                        Scanner fin = new Scanner(echoSocket.getInputStream());

                        out.println(FileName);
                        out.println(FileSize);
                        byte[] filebyte = new byte[FileSize];

                        bInStream.read(filebyte, 0, filebyte.length);
                        outStream.write(filebyte, 0, filebyte.length);
                        System.out.println(fin.nextLine());
                        outStream.flush();  
                }
                catch (Exception e)
                {
                    System.out.println(e);
                    System.out.println("Socket Closed!");
                    break;
                }
                System.out.print ("input: ");  
            }
            out.close();
            in.close();
            stdIn.close();
            echoSocket.close();
    }
}
