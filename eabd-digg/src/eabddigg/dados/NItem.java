/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eabddigg.dados;

import java.sql.Date;

/**
 *
 * @author lc
 */
public class NItem {
    String nick;
    String slug;
    String titulo;
    String url;
    Date date;

    public NItem(String nick, String slug, String titulo, String url, Date date) {
        if (nick.length()<=16)
            this.nick=nick;
        else this.nick = nick.substring(0,15);
        if (slug.length()<=32)
            this.slug = slug;
        else this.slug=slug.substring(0,31);
        if (titulo.length()<=100)
            this.titulo = titulo;
        else this.titulo=titulo.substring(0,99);
        if(url.length()<=100)
            this.url = url;
        else this.url = url.substring(0,99);
        this.date = date;
    }

    public NItem(){
        this.nick="";
        this.slug="";
        this.titulo="";
        this.url="";
        this.date = new Date(0);
    }

    public Date getDate() {
        return date;
    }

    public String getNick() {
        return nick;
    }

    public String getSlug() {
        return slug;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrl() {
        return url;
    }




}
