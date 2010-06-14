
import dal.Artigo;
import dal.Artista;
import facades.ShoppingCartBeanRemote;
import facades.StoreSessionBeanRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.faces.context.FacesContext;

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
    ArrayList<Artigo> artigos;
    String user;
    String pass;
    String itemCode;
    @EJB
    StoreSessionBeanRemote ssb;
    @EJB
    ShoppingCartBeanRemote scb;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public ArrayList<Artigo> getArtigos() {
        return artigos;
    }

    public void setArtigos(ArrayList<Artigo> artigos) {
        this.artigos = artigos;
    }

    public ArrayList<Artista> getArtistas() {
        return artistas;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
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

    public String showDetails() {
        FacesContext fc = FacesContext.getCurrentInstance();
        String param = fc.getExternalContext().getRequestParameterMap().get("nomeArtista");

        Artista a = ssb.findArtista(param);

        artistName = a.getNome();
        artigos = (ArrayList<Artigo>) ssb.findArtigosArtista(a);

        return "discosArtista";
    }

    public String findArtists() {
        artistas = new ArrayList<Artista>();
        //     artistas = (ArrayList<Artista>) ssb.findAllArtistas();
        artistas = (ArrayList<Artista>) ssb.findArtistByName(artistName);
        return "search";
    }

    public String addItemToCart() {
        FacesContext fc = FacesContext.getCurrentInstance();
        String param = fc.getExternalContext().getRequestParameterMap().get("codDisco");

        Artigo a = null;

        for (Artigo ia : artigos) {
            if (ia.getCodigo().equals(param)) {
                a = ia;
                break;
            }
        }
        scb.addItem(a);
        return "showCart";
    }

    public String removeItem() {
        FacesContext fc = FacesContext.getCurrentInstance();
        String param = fc.getExternalContext().getRequestParameterMap().get("codDisco");

        Artigo a = null;

        Iterator itr = scb.getProducts().iterator();

        while (itr.hasNext()) {
            Artigo ia = (Artigo) itr.next();
            if (ia.getCodigo().equals(param)) {
                a = ia;
                itr.remove();
                break;
            }
        }
        return "itemRemoved";
    }

    public List<Artigo> getCartContents() {
        return scb.getProducts();
    }
}
