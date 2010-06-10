/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facades;

import dal.Artigo;
import dal.StoreUser;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.Remote;

/**
 *
 * @author fork
 */
@Remote
public interface ShopingCartBeanRemote {

    public void setUser(dal.StoreUser user);

    public dal.StoreUser getUser();

    public void setProducts(java.util.List products);

    public java.util.List getProducts();

    ShopingCartBeanRemote createCart(StoreUser user) throws CreateException, RemoteException;

    void addItem(Artigo item);

    void removeItem(Artigo item);
    
}
