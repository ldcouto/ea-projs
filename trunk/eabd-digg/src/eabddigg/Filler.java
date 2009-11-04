/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eabddigg;

import java.sql.Connection;
import java.sql.DriverManager;
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

    static public void connect()
    {
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

    static void disconect()
    {
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    static void insertUser(User user)
    {

        try {
            insertUtilizadores.setString(1, user.getNick());
            insertUtilizadores.setString(2, user.getNome());
            insertUtilizadores.setString(3, user.getPassword());
            insertUtilizadores.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    static void insertNItem(NItem ni)
    {

        try {
            insertNoticias.setString(1, ni.getSlug());
            insertNoticias.setString(2, ni.getNick());
            insertNoticias.setString(3, ni.getTitulo());
            insertNoticias.setString(4,ni.getUrl());
            insertNoticias.setDate(5, ni.getDate());
            insertNoticias.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    static void insertVote(String slug, String nick)
    {

        try {
            insertVotos.setString(1, slug);
            insertVotos.setString(2, nick);
            insertVotos.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    static void insertFollow(String nickSeguidor, String nickSeguido)
    {

        try {
            insertSeguidores.setString(1, nickSeguidor);
            insertSeguidores.setString(2, nickSeguido);
            insertSeguidores.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /*
    static void insertNoticia(NItem item)
    {
        StringBuilder sql = new StringBuilder();
        String query;

        sql.append("insert into noticias (slug,nick,titulo,url,data)");
        sql.append("values");
        sql.append("( " + item.slug);
        sql.append(", " + item.nick);
        sql.append(", " + item.titulo);
        sql.append(", " + item.url);
        sql.append(", " + item.data + " );"); //TODO: Verificar data

        query = sql.toString();

        try {
            insertNoticias = con.createStatement();
            insertNoticias.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    static void insertVotes(String slug)
    {
        StringBuilder sql = new StringBuilder();
        String query;

        List<String> listVoters = votersMap.get(slug);

        for(String elem : listVoters) {
            sql.append("insert into voto (slug,nick)");
            sql.append("values");
            sql.append("( " + slug);
            sql.append(", " + elem + " );");

            query = sql.toString();

            try {
                insertVotos = con.createStatement();
                insertVotos.executeUpdate(query);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    static void insertFollowers(String nick)
    {
        StringBuilder sql = new StringBuilder();
        String query;

        List<String> listFollowers = followersMap.get(nick);

        for (String elem : listFollowers) {
            sql.append("insert into voto (seguidor,seguido)");
            sql.append("values");
            sql.append("( " + elem);
            sql.append(", " + nick + " );");

            query = sql.toString();

            try {
                insertVotos = con.createStatement();
                insertVotos.executeUpdate(query);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    */

    /**
     * @param args the command line arguments
     */

    public void fillBD(Sistema sys){
        sys.makeSistema();

        // Connect to the DB
        connect();
        //Let's insert the users...
        for(User u : sys.getUsers())
            insertUser(u);

        // Let's insert the news...
        for (NItem ni : sys.getNews())
            insertNItem(ni);

        // Let's insert the votes
        for (String slug :sys.getVotes().keySet())
            for (String nick : sys.getVotes().get(slug))
                insertVote(slug, nick);

       // Let's insert the followers
       for (String seguido : sys.getLikes().keySet())
           for (String seguidor : sys.getLikes().get(seguido))
               insertFollow(seguidor, seguido);


    }

}
