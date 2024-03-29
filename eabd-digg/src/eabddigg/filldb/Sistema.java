/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eabddigg.filldb;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lc
 */
public class Sistema {
    List<User> users=new ArrayList<User>(12000);
    List<NItem> news=new ArrayList<NItem>(300000);
    // Mapa noticias ->users que gostaram
    Map<String,ArrayList<String>> votes = new HashMap<String,ArrayList<String>>(300000);
    // Mapa seguido->seguidores
    Map<String,ArrayList<String>> likes= new HashMap<String,ArrayList<String>>(12000);
    int userCount=0;


    public Sistema(){
    }

    public List<NItem> getNews() {
        return news;
    }

    public Map<String, ArrayList<String>> getLikes() {
        return likes;
    }

    public int getUserCount() {
        return userCount;
    }

    public List<User> getUsers() {
        return users;
    }

    public Map<String, ArrayList<String>> getVotes() {
        return votes;
    }

    public void setVotes(Map<String, ArrayList<String>> votes) {
        this.votes = votes;
    }



    public void makeSistema(){
        this.makeUsers();
        this.makeNews();
        this.makeLikers();
    }

    public long getTotalLikers(){
        long r =0;
        for (String s : likes.keySet())
            r+=likes.get(s).size();
        return r;
    }

    public long getTotalVotes(){
        long r =0;
        for (String s : votes.keySet())
            r+=votes.get(s).size();
        return r;
    }

    private void makeUsers(){
        this.users = User.getManyUsers();
        userCount=users.size();
    }

    private void makeNews(){
        Random r = new Random();
        String slug="", title="", nick="", url="";

            FileReader fin = null;
        try {
            fin = new FileReader("mats/inputs/nwords.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
            Scanner src = new Scanner(fin);


        // Let's add the big spammers first
        for (int i=0; i<300;i++){
            nick = this.getRandomUsername();
            for (int j=0; j<50+r.nextInt(10);j++){
                if (src.hasNext())
                    slug=src.next();
                if (src.hasNext())
                    title=src.next();
                if (src.hasNext())
                    url=src.next();
                long aux = 0 + r.nextInt(10000000);
                this.makeNewsItem(nick, slug, title, url, new Date(aux));
           }
        }

        // Now let's add the quiet guys
        for (User u : this.users){
            nick = u.nick;
            for (int j=0; j<1+r.nextInt(10);j++){
                if (src.hasNext())
                    slug=src.next();
                if (src.hasNext())
                    title=src.next();
                if (src.hasNext())
                    url=src.next();
               long aux = 0 + r.nextInt(10000000);
               this.makeNewsItem(nick, slug, title, url, new Date(aux));
           }
        }
        
    }

    private void makeLikers(){
        Random r = new Random();
        for (User u : users) {
            ArrayList<String> gostadores = new ArrayList<String>();
            for (int i=0;i<5+r.nextInt(10);i++)
                gostadores.add(this.getRandomUsername());
            likes.put(u.nick, gostadores);
        }
    }

    private String getRandomUsername(){
        Random r = new Random();

        return users.get(r.nextInt(userCount)).nick;
    }

    private void makeNewsItem(String nick, String slug, String title, String url, Date date) {
        NItem ni = new NItem(nick, slug, title, url, date);

        // Let's get some fans
        Random rand = new Random();
        ArrayList<String> aux = new ArrayList<String>();

        for(int i=0;i<(10+rand.nextInt(90));i++)
            aux.add(this.getRandomUsername());

        votes.put(slug, aux);
        news.add(ni);
    }
     
}
