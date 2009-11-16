/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eabddigg;

import connectionhandler.MyConnectionHandler;
import java.sql.Connection;
import java.sql.SQLException;

import eabddigg.dados.*;
import java.sql.PreparedStatement;

/**
 *
 * @author fork
 */
public class Filler {

    static Connection con;
    static PreparedStatement insertUtilizadores;
    static PreparedStatement insertNoticias;
    static PreparedStatement insertVotos;
    static PreparedStatement insertSeguidores;

    static void prepare() {
        //Checking if Driver is registered with DriverManager

        try {

            insertUtilizadores = con.prepareStatement("insert into utilizador (nick,nome,password)" +
                    "values (?,?,?);");

            insertNoticias = con.prepareStatement("insert into noticia (slug,nick,titulo,url,data)" +
                    "values (?,?,?,?,?);");

            insertVotos = con.prepareStatement("insert into voto (slug,nick)" +
                    "values (?,?);");

            insertSeguidores = con.prepareStatement("insert into seguidores (seguidor,seguido)" +
                    "values (?,?);");

        } catch (SQLException se) {
            se.printStackTrace();
            System.exit(1);
        }


    }


    static void insertUser(User user) {

        try {
            insertUtilizadores.setString(1, user.getNick());
            insertUtilizadores.setString(2, user.getNome());
            insertUtilizadores.setString(3, user.getPassword());
            insertUtilizadores.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    static void insertNItem(NItem ni) {

        try {
            insertNoticias.setString(1, ni.getSlug());
            insertNoticias.setString(2, ni.getNick());
            insertNoticias.setString(3, ni.getTitulo());
            insertNoticias.setString(4, ni.getUrl());
            insertNoticias.setDate(5, ni.getDate());
            insertNoticias.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    static void insertVote(String slug, String nick) {

        try {
            insertVotos.setString(1, slug);
            insertVotos.setString(2, nick);
            insertVotos.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    static void insertFollow(String nickSeguidor, String nickSeguido) {

        try {
            insertSeguidores.setString(1, nickSeguidor);
            insertSeguidores.setString(2, nickSeguido);
            insertSeguidores.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void fillBD() {
        System.out.println("Generating dummy data...");
        Sistema sys = new Sistema();
        sys.makeSistema();
        
        // Connect to the DB
        con = MyConnectionHandler.connect();
        prepare();
        //Let's insert the users...
        System.out.println("Inserting users...");
        for (User u : sys.getUsers()) {
            insertUser(u);
        }

        // Let's insert the news...
        System.out.println("Inserting news...");
        for (NItem ni : sys.getNews()) {
            insertNItem(ni);
        }

        // Let's insert the votes
        System.out.println("Inserting votes...");
        for (String slug : sys.getVotes().keySet()) {
            for (String nick : sys.getVotes().get(slug)) {
                insertVote(slug, nick);
            }
        }

        // Let's insert the followers
        System.out.println("Inserting followers...");
        for (String seguido : sys.getLikes().keySet()) {
            for (String seguidor : sys.getLikes().get(seguido)) {
                insertFollow(seguidor, seguido);
            }
        }

        MyConnectionHandler.disconnect(con);


    }
}