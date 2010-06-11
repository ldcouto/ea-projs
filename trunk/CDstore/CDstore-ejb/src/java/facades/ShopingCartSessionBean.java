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
import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.CreateException;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;

/**
 *
 * @author fork
 */

@Stateful()
public class ShopingCartSessionBean implements ShoppingCartBeanRemote
{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private List<Artigo> products = new ArrayList<Artigo>();
    private StoreUser user;

    @RolesAllowed(
    {
        "client"
    })
    public List getProducts()
    {
        return products;
    }

    public void setProducts(List products)
    {
        this.products = products;
    }

    @RolesAllowed(
    {
        "client"
    })
    public StoreUser getUser()
    {
        return user;
    }

    public void setUser(StoreUser user)
    {
        this.user = user;
    }

    public ShoppingCartBeanRemote createCart(StoreUser user) throws CreateException, RemoteException
    {
        ejbCreateCart(user);
        return new ShopingCartSessionBean();
    }

    private void ejbCreateCart(StoreUser user) throws CreateException
    {
        this.user = user;
    }

    @RolesAllowed(
    {
        "client"
    })
    public void addItem(Artigo item)
    {
        products.add(item);
    }

    @RolesAllowed(
    {
        "client"
    })
    public void removeItem(Artigo item)
    {
        products.remove(item);
    }
}
