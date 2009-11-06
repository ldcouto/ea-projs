/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eabddigg.loadtests;

import connectionhandler.MyConnectionHandler;
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

    Connection con; // TODO: remover isto, apenas aqui para não aponder este tipo de erros

    public Queries(){
        con = MyConnectionHandler.connect();
    }

    public String selectRandomUser(){
        StringBuilder sql = new StringBuilder();
        Random r = new Random();
        ResultSet res;
        String nick = new String();

        sql.append("SELECT nick ");
        sql.append("FROM utilizador ");
        sql.append("LIMIT 1 OFFSET " + r.nextInt(8000));
        sql.append(";");
        String killme = sql.toString();
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

    public  String selectRandomNews(){
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

    public  void topTenNews(){
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

    public  void topTenFollowers(){
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

    public  void recNews(String userNick){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT slug FROM voto JOIN seguidores ON");
        sb.append(" voto.nick=seguidores.seguido");
        sb.append(" WHERE seguidores.seguidor=");
        sb.append("'"+ userNick +"'");
        sb.append(" AND voto.nick!=");
        sb.append("'"+userNick+"'");
        sb.append(" LIMIT 3;"); // Se calhar precisas de um offset.
        String sql = sb.toString();

        try {
            Statement st = con.createStatement();
            st.executeQuery(sql);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    } 

    public  void recUsers(String userNick){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT filhos.seguido");
        sb.append(" FROM seguidores pais JOIN seguidores filhos ON");
        sb.append(" pais.seguido=filhos.seguidor");
        sb.append(" WHERE pais.seguidor=");
        sb.append("'"+ userNick +"'");
        sb.append(" AND filhos.seguidor!=");
        sb.append("'"+userNick+"'");
        sb.append(" LIMIT 3;"); // Se calhar precisas de um offset.
        String sql = sb.toString();

        try {
            Statement st = con.createStatement();
            st.executeQuery(sql);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

    }

    public  void allPostsMadeBy(String userNick){
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

    public  void allPostsLikedBy(String userNick){
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

    public  void allFollowersOf(String userNick){
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

    public  void loginUser(String userNick){
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

    public  void insertNews(String userNick){
        Random rand = new Random();
        String titulo="'intitle"+rand.nextInt()+"'";
        String url="'inurl"+rand.nextInt()+"'";
        String slug="'irslug"+rand.nextInt()+"'";
        StringBuilder sb = new StringBuilder();
        sb.append("'"+(rand.nextInt(3000)+1970));
        sb.append('-');
        sb.append((rand.nextInt(11)+1));
        sb.append('-');
        sb.append((rand.nextInt(27)+1)+"'");
        String data=sb.toString();

        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO noticia (slug, titulo, url, data, nick)");
        sql.append("VALUES (" +slug+ ","+titulo+","+url+","+data+",'"+userNick+ "');");
 //      --- String killme = sql.toString();

        try {
            Statement st = con.createStatement();
            st.executeUpdate(sql.toString());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public  void insertVoto(String newsSlug, String userNick){
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO voto (slug,nick)");
        sql.append("VALUES ("+"'"+newsSlug+"'"+","+"'"+userNick+"'"+");");
   //     String killme = sql.toString();
        try {
            Statement st = con.createStatement();
            st.executeUpdate(sql.toString());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
