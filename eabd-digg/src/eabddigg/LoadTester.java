/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eabddigg;

import java.sql.Connection;

/**
 *
 * @author fork
 */
public class LoadTester {

    private static Connection con;
/*
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
                    "fork", "senuti");
        } catch (SQLException se) {
            se.printStackTrace();
            System.exit(1);
        }
    }
*/
    public static void main(String[] args)
    {

    }

}
