
import dal.Artigo;
import dal.Artista;
import facades.ShoppingCartBeanRemote;
import facades.StoreSessionBean;
import facades.StoreSessionBeanRemote;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ldc
 */
public class StoreBackingBean
{

    String artistName;
    ArrayList<Artista> artistas;
    private String itemCode;

    @EJB
    StoreSessionBeanRemote ssb;
    @EJB
    ShoppingCartBeanRemote scb;

    public StoreBackingBean()
    {
        artistas = new ArrayList<Artista>();
        artistas.add(new Artista("art1", "Prince"));

    }

    public String getItemCode()
    {
        return itemCode;
    }

    public void setItemCode(String itemCode)
    {
        this.itemCode = itemCode;
    }

    public ArrayList<Artista> getArtistas()
    {
        return artistas;
    }

    public void setArtistas(ArrayList<Artista> artistas)
    {
        this.artistas = artistas;
    }

    public String getArtistName()
    {
        return artistName;
    }

    public void setArtistName(String artistName)
    {
        this.artistName = artistName;
    }

    public String findArtists()
    {
        artistas = new ArrayList<Artista>();
        //     artistas = (ArrayList<Artista>) ssb.findAllArtistas();
        artistas = (ArrayList<Artista>) ssb.findArtistByName(artistName);
        return "search";
    }

    public String addItemToCart()
    {
        Artigo a = ssb.findArtigo(itemCode);
        scb.addItem(a);
        return "showCart";
    }

    public List<Artigo> getCartContents()
    {
        return scb.getProducts();
    }
}
