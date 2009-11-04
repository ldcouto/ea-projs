/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eabddigg.loadtests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 *
 * @author lc
 */
public class Queries {

    private Connection con; // TODO: remover isto

    public String selectRandomUser(){
        StringBuilder sql = new StringBuilder();
        Random r = new Random();
        ResultSet res;

        sql.append("SELECT nick ");
        sql.append("FROM utilizador ");
        sql.append("LIMIT 1 OFFSET " + r.nextInt(8000));
        sql.append(";");
        try {
            Statement st = con.createStatement();
            res = st.executeQuery(sql.toString());
            res.next();

            return res.getString(1);

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        } finally {
            return null;
        }
    }

    public void topTenNews(){
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT slug,COUNT(slug) ");
        sql.append("FROM voto ");
        sql.append("GROUP BY slug ");
        sql.append("ORDER BY count DESC ");
        sql.append("LIMIT 10;");

        try {
            Statement st = con.createStatement();
            st.executeQuery(sql.toString());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void topTenFollowers(){
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT seguido,COUNT(seguidor) ");
        sql.append("FROM seguidores ");
        sql.append("GROUP BY seguido ");
        sql.append("ORDER BY count DESC ");
        sql.append("LIMIT 10;");

        try {
            Statement st = con.createStatement();
            st.executeQuery(sql.toString());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void recNews(String userNick){

    }

    public void recUsers(String userNick){

    }

    public void allPostsMadeBy(String userNick){
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT slug ");
        sql.append("FROM noticia");
        sql.append("WHERE nick = " + userNick);
        sql.append(";");

        try {
            Statement st = con.createStatement();
            st.executeQuery(sql.toString());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void allPostsLikedBy(String userNick){
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT slug ");
        sql.append("FROM voto");
        sql.append("WHERE nick = " + userNick);
        sql.append(";");
        
        try {
            Statement st = con.createStatement();
            st.executeQuery(sql.toString());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void allFollowersFrom(String userNick){
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT seguidor ");
        sql.append("FROM seguidores ");
        sql.append("WHERE seguido = " + userNick);
        sql.append(";");

        try {
            Statement st = con.createStatement();
            st.executeQuery(sql.toString());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void loginUser(String userNick){
        // Duvida
    }

    public void insertNews(){

    }

    
}
