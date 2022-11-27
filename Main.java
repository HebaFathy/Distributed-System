/*
 * Main.java
 *
 * Created on March 27, 2007, 2:44 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package client;




import HelloApp.Hello;
import HelloApp.HelloOperations;
import HelloApp.HelloHelper;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;



/**
 * @author hosam
 */

public class Main {
    String  id , name , dep;
    
    public static void main(String[] args)
    
    {
        
        try{
            
            String id =JOptionPane.showInputDialog(" ENTER YOUR ID ");
            String name=JOptionPane.showInputDialog(" ENTER YOUR NAME ");
            String dep=JOptionPane.showInputDialog(" ENTER YOUR DEP ");
            //String record ="INSERT INTO mufic VALUES ('11111','ahmed','it')";
            String record ="INSERT INTO mufic VALUES ('"+id+"','"+name+"','"+dep+"')";
            
            // create and initialize the ORB
            
            ORB orb = ORB.init(args, null);
            
            
            // Prompt for a stringified IOR and convert it into a CORBA object
            String s = readLine("Enter server IOR: ");
            org.omg.CORBA.Object objRef = orb.string_to_object(s);
                 
            
            // Narrow that CORBA object to a Hello service reference
            Hello helloRef = HelloHelper.narrow(objRef);
            
            // call the Hello server object and print results
            
             String hello=helloRef.insert(record);
           
            System.out.println(hello);
            
        } catch (Exception e) {
            System.out.println("ERROR : " + e) ;
            e.printStackTrace(System.out);
        }
    }
    
    /*
     * Prompt for and read a line of user input from System.in
     */
    public static String readLine(String prompt) {
        //  print the given prompt
        System.out.println(prompt);
        
        //  open up standard input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String value = null;
        
        //  read data from the user; i/o errors are fatal.
        try {
            value = br.readLine().trim();
        } catch (IOException ioe) {
            System.out.println("IO error trying to read data for \"" + prompt + "\"");
            System.exit(1);
        }
        
        return value;
    }
    
    
    
}

