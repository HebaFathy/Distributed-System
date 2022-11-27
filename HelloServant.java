/*
 * HelloServant.java
 *
 * Created on March 28, 2007, 2:46 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package server;

import HelloApp.HelloPOA;
import java.sql.*;

/**
 *
 * @author hosam
 */
public class HelloServant extends HelloPOA {
    public String sayHello()
    {
        return "\nHello client!!\n";
       
    }
    
    public String insert(String record)
    {
        
     try { 
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String dataSourceName = "mdbTEST";
        String dbURL = "jdbc:odbc:" + dataSourceName;
        Connection con = DriverManager.getConnection(dbURL, "",""); 
        Statement s = con.createStatement();
        s.execute(record); 
        s.close(); // close the Statement to let the database know we're done with it
        con.close(); // close the Connection to let the database know we're done with it
         }

        catch (Exception e) {
            System.out.println("Error: " + e);
        }

        
        return record;
    }
}

