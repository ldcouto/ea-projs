/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dal.Artigo;
import dal.Artista;
import dal.CD;
import dal.DVD;
import dal.Tema;
import dal.Vinil;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author fork
 */
@RolesAllowed(
{
    "client"
})
@Stateless()
public class StoreSessionBean implements StoreSessionBeanRemote
{

    @Resource
    protected SessionContext ctxSessionContext;
    @PersistenceContext(unitName = "CDStore-ejbPU")
    private EntityManager em;

    @RolesAllowed(
    {
        "client"
    })
    public void createArtigo(Artigo a)
    {
        em.persist(a);
    }

    @RolesAllowed(
    {
        "client"
    })
    public Artigo findArtigo(String codigo)
    {
        return em.find(Artigo.class, codigo);
    }

    @RolesAllowed(
    {
        "client"
    })
    public List<Artigo> findAllArtigos()
    {
        Query q = em.createQuery("SELECT a FROM Artigo a");
        return q.getResultList();
    }

    @RolesAllowed(
    {
        "client"
    })
    public void removeArtigo(Artigo a)
    {
        em.remove(a);
    }

    @RolesAllowed(
    {
        "client"
    })
    public void decreaseStock(Artigo a, Integer amount)
    {
        a = findArtigo(a.getCodigo());

        if (a != null && a.getStock() > amount)
        {
            a.setStock(a.getStock() - amount);
            em.merge(a);
        }
    }

    @RolesAllowed(
    {
        "client"
    })
    public void increaseStock(Artigo a, Integer amount)
    {
        a = findArtigo(a.getCodigo());

        if (a != null)
        {
            a.setStock(a.getStock() + amount);
            em.merge(a);
        }
    }

    @RolesAllowed(
    {
        "client"
    })
    public void createArtista(Artista a)
    {
        em.persist(a);
    }

    @RolesAllowed(
    {
        "client"
    })
    public Artista findArtista(String codigo)
    {
        return em.find(Artista.class, codigo);
    }

    @RolesAllowed(
    {
        "client"
    })
    public List<Artista> findArtistByName(String name)
    {
        Query q = em.createQuery("select a from Artista a where upper(a.nome) like upper(?1)");
        q.setParameter(1, "%" + name + "%");
        return q.getResultList();
    }

    @RolesAllowed(
    {
        "client"
    })
    public List<String> findAllArtistas()
    {
        Query q = em.createQuery("SELECT a.nome FROM Artista a");
        return q.getResultList();
    }

    @RolesAllowed(
    {
        "client"
    })
    public String findArtistaByName(String name)
    {
        Query q = em.createQuery("SELECT a.codigo FROM Artista a WHERE a.nome like ?1");
        q.setParameter(1, name);
        return (String) q.getSingleResult();
    }

    @RolesAllowed(
    {
        "client"
    })
    public List<Artigo> findArtigosArtista(Artista a)
    {
        a = findArtista(a.getCodigo());
        List<Artigo> listaArtigos = new ArrayList<Artigo>();

        if (a != null)
        {
            listaArtigos.addAll(a.getCDs());
            listaArtigos.addAll(a.getDVDs());
            listaArtigos.addAll(a.getVinis());
        }

        return listaArtigos;
    }

    @RolesAllowed(
    {
        "client"
    })
    public void removeArtista(Artista a)
    {
        em.remove(a);
    }

    @RolesAllowed(
    {
        "client"
    })
    public void addArtigo(Artista artista, Artigo artigo)
    {
        artista = findArtista(artista.getCodigo());
        artigo = findArtigo(artigo.getCodigo());

        if (artista != null && artigo != null)
        {
            if (artigo instanceof CD)
            {
                Set<CD> cdSet = artista.getCDs();
                cdSet.add((CD) artigo);
            }
            else if (artigo instanceof DVD)
            {
                Set<DVD> dvdSet = artista.getDVDs();
                dvdSet.add((DVD) artigo);
            }
            else if (artigo instanceof Vinil)
            {
                Set<Vinil> vinilSet = artista.getVinis();
                vinilSet.add((Vinil) artigo);
            }

            em.merge(artista);
        }
    }

    @RolesAllowed(
    {
        "client"
    })
    public void remArtigo(Artista artista, Artigo artigo)
    {
        artista = findArtista(artista.getCodigo());
        artigo = findArtigo(artigo.getCodigo());

        if (artista != null && artigo != null)
        {
            if (artigo instanceof CD)
            {
                Set<CD> cdSet = artista.getCDs();
                cdSet.remove((CD) artigo);
            }
            else if (artigo instanceof DVD)
            {
                Set<DVD> dvdSet = artista.getDVDs();
                dvdSet.remove((DVD) artigo);
            }
            else if (artigo instanceof Vinil)
            {
                Set<Vinil> vinilSet = artista.getVinis();
                vinilSet.remove((Vinil) artigo);
            }

            em.merge(artista);
        }
    }

    @RolesAllowed(
    {
        "client"
    })
    public void createTema(Tema t)
    {
        em.persist(t);
    }

    @RolesAllowed(
    {
        "client"
    })
    public Tema findTema(String codigo)
    {
        return em.find(Tema.class, codigo);
    }

    @RolesAllowed(
    {
        "client"
    })
    public void removeTema(Tema t)
    {
        em.remove(t);
    }
}
