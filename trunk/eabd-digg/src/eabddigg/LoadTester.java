/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eabddigg;

import eabddigg.dados.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fork
 */
public class LoadTester {

    private static Connection con;


    static public void connect() {
        //Checking if Driver is registered with DriverManager

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Couldn't find the driver!");
            cnfe.printStackTrace();
            System.exit(1);
        }

        con = null;

        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/digg",
                    "tester", "tester");
        } catch (SQLException se) {
            se.printStackTrace();
            System.exit(1);
        }
    }

    static public void disconnect() {
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    static public void someQueries()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ");
        sb.append("utilizador ");
        sb.append("limit 100;");

        Statement miniQuery;
        ResultSet aux= null;
        ArrayList<User> users = new ArrayList<User>();
        try {
            miniQuery = con.createStatement();
            String query = sb.toString();
            aux = miniQuery.executeQuery(query);
            while (aux.next())
            {
                User u = new User();
                u.setNick(aux.getString("nick"));
                u.setNick(aux.getString("nome"));
                u.setNick(aux.getString("password"));
                users.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadTester.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (aux == null)
            return;
        System.out.println("Apanhei " + users.size()+" utilizadores.");
    }

    public static void main(String[] args)
    {
        connect();



        disconnect();
    }   

}
