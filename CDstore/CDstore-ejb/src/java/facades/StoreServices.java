/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dal.Artigo;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ejb.Stateless;

/**
 *
 * @author fork 
 */
@WebService(name = "CD-Store-WebServices")
@Stateless()
public class StoreServices
{
    @EJB private StoreSessionBeanRemote ssb = new StoreSessionBean();

    /**
     * Web service operation
     */
    @WebMethod(operationName = "checkStock")
    public Integer checkStock(@WebParam(name = "codigo") String codigo)
    {
        Artigo a = ssb.findArtigo(codigo);

        return a.getStock();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listArtistas")
    public List listArtistas()
    {
        List<String> list = ssb.findAllArtistas();

        return list;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "procurarArtista")
    public String procurarArtista(@WebParam(name = "nome")
    String nome)
    {
        String a = ssb.findArtistaByName(nome);
        
        return a;
    }
}
