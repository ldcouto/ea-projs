/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eabddigg.dados;

/**
 *
 * @author lc
 */
public class Vote {
    String slug;
    String nick;

    public Vote(String slug, String nick) {
        this.slug = slug;
        this.nick = nick;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }



}
