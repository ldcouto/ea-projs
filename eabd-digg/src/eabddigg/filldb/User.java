/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eabddigg.filldb;

/**
 *
 * @author lc
 */

import java.io.FileNotFoundException;
import java.util.Random;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class User {

    String nick;
    String nome;
    String password;



    public User(String nick, String nome, String password) {
        if (nick.length()<=16)
            this.nick = nick;
        else this.nick = nick.substring(0,15);
        if (nome.length()<=100)
            this.nome = nome;
        else this.nome = nome.substring(0,99);
        if (password.length()<=16)
            this.password = password;
        else this.password=password.substring(0, 15);
    }

    public User(){
        this.nick="";
        this.nick="";
        this.password="";
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getNick() {
        return nick;
    }

    public String getNome() {
        return nome;
    }

    public String getPassword() {
        return password;
    }



   public static List<User> getManyUsers(){
            FileReader fin = null;
            ArrayList<User> r = new ArrayList<User>(1200);
            String a = "";
            String b = "";
            String c = "";
        try {
            fin = new FileReader("mats/inputs/uwords.txt");
            Scanner src = new Scanner(fin);
            User temporario = new User();
            int i =1200;
            while (src.hasNext() && i>0) {
                if (src.hasNext()) {
                    a = src.next();
                }
                if (src.hasNext()) {
                    b = src.next();
                }
                if (src.hasNext()) {
                    c = src.next();
                }

                temporario = new User(a, b, c);
                r.add(temporario);
                i--;
            }
            fin.close();
            } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
            return r;
   }
}
