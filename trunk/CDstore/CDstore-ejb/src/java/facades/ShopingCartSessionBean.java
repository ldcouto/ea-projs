/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dal.Artigo;
import dal.StoreUser;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.CreateException;
import javax.ejb.Stateful;

/**
 *
 * @author fork
 */
@Stateful
public class ShopingCartSessionBean implements ShopingCartBeanRemote
{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private List<Artigo> products = new ArrayList<Artigo>();
    private StoreUser user;

    /**
     * Get the value of products
     *
     * @return the value of products
     */
    public List getProducts()
    {
        return products;
    }

    /**
     * Set the value of products
     *
     * @param products new value of products
     */
    public void setProducts(List products)
    {
        this.products = products;
    }

    /**
     * Get the value of user
     *
     * @return the value of user
     */
    public StoreUser getUser()
    {
        return user;
    }

    /**
     * Set the value of user
     *
     * @param user new value of user
     */
    public void setUser(StoreUser user)
    {
        this.user = user;
    }



    public ShopingCartBeanRemote createCart(StoreUser user) throws CreateException, RemoteException
    {
        ejbCreateCart(user);
        return new ShopingCartSessionBean();
    }

    private void ejbCreateCart(StoreUser user) throws CreateException
    {
        this.user = user;
    }

    public void addItem(Artigo item)
    {
        products.add(item);
    }

    public void removeItem(Artigo item)
    {
        products.remove(item);
    }
}
