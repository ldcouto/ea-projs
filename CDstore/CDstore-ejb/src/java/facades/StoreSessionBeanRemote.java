/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dal.Artigo;
import dal.Artista;
import dal.Tema;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jorge
 */
@Remote
public interface StoreSessionBeanRemote
{

    public void createArtigo(Artigo a);

    public Artigo findArtigo(String codigo);

    public List<Artigo> findAllArtigos();

    public void removeArtigo(Artigo a);

    public void decreaseStock(Artigo a, Integer amount);

    public void increaseStock(Artigo a, Integer amount);

    public void createArtista(Artista a);

    public Artista findArtista(String codigo);

    public List<String> findAllArtistas();

    public String findArtistaByName(String name);

    public List<Artigo> findArtigosArtista(Artista a);

    public void removeArtista(Artista a);

    public void addArtigo(Artista artista, Artigo artigo);

    public void remArtigo(Artista artista, Artigo artigo);

    public void createTema(Tema t);

    public Tema findTema(String codigo);

    public void removeTema(Tema t);

    List<Artista> findArtistByName(String name);
}
