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
    static String jdbcUrl;
    static String user;
    static String pass;


    public static void start (String host, String port, String dbname, String user, String pass)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("jdbc:postgresql://");
        sb.append(host);
        sb.append(':');
        sb.append(port);
        sb.append('/');
        sb.append(dbname);
        
        MyConnectionHandler.jdbcUrl=sb.toString();
        MyConnectionHandler.user = user;
        MyConnectionHandler.pass=pass;
    }

    public static Connection connect() {

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