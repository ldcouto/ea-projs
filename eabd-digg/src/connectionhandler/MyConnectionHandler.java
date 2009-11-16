/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionhandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fork
 */
public abstract class MyConnectionHandler {

    public static Connection connect(String jdbcUrl, String user, String pass) {

        Connection con;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException cnfe) {
            System.err.println(cnfe.getMessage());
            cnfe.printStackTrace();
            System.exit(1);
        }

        con = null;

        try {
            con = DriverManager.getConnection(jdbcUrl, user, pass);
        } catch (SQLException se) {
            System.err.println(se.getMessage());
            se.printStackTrace();
            System.exit(1);
        }

        return con;
    }

    public static void disconnect(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            System.exit(1);
        }
    }
}