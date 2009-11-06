/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eabddigg.loadtests;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 *
 * @author lc
 */
public class Queries {

    static Connection con; // TODO: remover isto, apenas aqui para não aponder este tipo de erros

    public static String selectRandomUser(){
        StringBuilder sql = new StringBuilder();
        Random r = new Random();
        ResultSet res;
        String nick = new String();

        sql.append("SELECT nick ");
        sql.append("FROM utilizador ");
        sql.append("LIMIT 1 OFFSET " + r.nextInt(8000));
        sql.append(";");
        try {
            Statement st = con.createStatement();
            res = st.executeQuery(sql.toString());
            res.next();

            nick = res.getString(1);

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        } finally {
            return nick;
        }
    }

    public static String selectRandomNews(){
        StringBuilder sql = new StringBuilder();
        Random r = new Random();
        ResultSet res;

        String slug = new String();

        sql.append("SELECT slug ");
        sql.append("FROM noticia ");
        sql.append("LIMIT 1 OFFSET " + r.nextInt(8000));
        sql.append(";");
        try {
            Statement st = con.createStatement();
            res = st.executeQuery(sql.toString());
            res.next();

            slug = res.getString(1);

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        } finally {
            return slug;
        }
    }

    public static void topTenNews(){
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

    public static void topTenFollowers(){
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

    public static void recNews(String userNick){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT slug FROM voto JOIN seguidores ON");
        sb.append(" voto.nick=seguidores.seguido");
        sb.append(" WHERE seguidores.seguidor=");
        sb.append("'"+ userNick +"'");
        sb.append(" AND voto.nick!=");
        sb.append("'"+userNick+"'");
        sb.append(';');
        String sql = sb.toString();

        try {
            Statement st = con.createStatement();
            st.executeQuery(sql);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }


    

    public static void recUsers(String userNick){

    }

    public static void allPostsMadeBy(String userNick){
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

    public static void allPostsLikedBy(String userNick){
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

    public static void allFollowersFrom(String userNick){
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

    public static void loginUser(String userNick){
        StringBuilder sql = new StringBuilder();
        Random r = new Random();

        sql.append("SELECT nick ");
        sql.append("FROM utilizador ");
        sql.append("WHERE nick=" + userNick);
        sql.append(";");
        try {
            Statement st = con.createStatement();
            st.executeQuery(sql.toString());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static  void insertNews(String userNick){
        String titulo;
        String url;
        Date data;
    }

    public static void insertVoto(String newsSlug, String userNick){
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO voto (slug,nick)");
        sql.append("VALUES ("+newsSlug+","+userNick+");");

        try {
            Statement st = con.createStatement();
            st.executeQuery(sql.toString());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
