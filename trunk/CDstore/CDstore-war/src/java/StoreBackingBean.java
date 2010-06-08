
import dal.Artista;
import facades.StoreSessionBean;
import facades.StoreSessionBeanRemote;
import java.util.ArrayList;
import javax.ejb.EJB;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ldc
 */
public class StoreBackingBean {
    String artistName;

    ArrayList<Artista> artistas;

    @EJB
    StoreSessionBeanRemote ssb;

    public StoreBackingBean() {
        artistas = new ArrayList<Artista>();
        artistas.add(new Artista("art1", "Prince"));
        
    }

    public ArrayList<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(ArrayList<Artista> artistas) {
        this.artistas = artistas;
    }

    

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }


    public String findArtists() {
        artistas = new ArrayList<Artista>();
   //     artistas = (ArrayList<Artista>) ssb.findAllArtistas();
        artistas = (ArrayList<Artista>) ssb.findArtistByName(artistName);
        return "search";
        }


}
