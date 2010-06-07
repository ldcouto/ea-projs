/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dal.Artigo;
import dal.Artista;
import dal.Tema;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jorge
 */
@Local
public interface StoreSessionBeanRemote
{

    public void createArtigo(String codigo, String nome, Integer stock);

    public Artigo findArtigo(String codigo);

    public List<Artigo> findAllArtigos();

    public void removeArtigo(Artigo a);

    public void decreaseStock(Artigo a, Integer amount);

    public void increaseStock(Artigo a, Integer amount);

    public void createArtista(String codigo, String nome);

    public Artista findArtista(String codigo);

    public List<Artista> findAllArtistas();

    public List<Artigo> findArtigosArtista(Artista a);

    public void removeArtista(Artista a);

    public void addArtigo(Artista artista, Artigo artigo);

    public void remArtigo(Artista artista, Artigo artigo);

    public void createTema(String codigo, String nome);

    public Tema findTema(String codigo);

    public void removeTema(Tema t);
}
