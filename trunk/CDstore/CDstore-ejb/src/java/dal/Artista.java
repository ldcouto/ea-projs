/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */
/**
 * Licensee: Tiago Veloso
 * License Type: Evaluation
 */
package dal;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

public class Artista implements Serializable
{

    private String codigo;
    private String nome;
    private Set<CD> ORM_cds = new HashSet<CD>();
    private Set<DVD> ORM_dvds = new HashSet<DVD>();
    private Set<Vinil> ORM_vinis = new HashSet<Vinil>();

    public Artista()
    {
    }

    public Artista(String codigo, String nome)
    {
        this.codigo = codigo;
        this.nome = nome;
    }



    @Override
    public boolean equals(Object aObj)
    {
        if (aObj == this)
        {
            return true;
        }
        if (!(aObj instanceof Artista))
        {
            return false;
        }
        Artista artista = (Artista) aObj;
        if ((getCodigo() != null && !getCodigo().equals(artista.getCodigo())) || (getCodigo() == null && artista.getCodigo() != null))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hashcode = 0;
        hashcode = hashcode + (getCodigo() == null ? 0 : getCodigo().hashCode());
        return hashcode;
    }

    public void setNome(String value)
    {
        this.nome = value;
    }

    public String getNome()
    {
        return nome;
    }

    public void setCodigo(String value)
    {
        this.codigo = value;
    }

    public String getCodigo()
    {
        return codigo;
    }

    public String getORMID()
    {
        return getCodigo();
    }

    public void setORM_CDs(Set<CD> value)
    {
        this.ORM_cds = value;
    }

    public Set<CD> getORM_CDs()
    {
        return ORM_cds;
    }

    public void setORM_dVDs(Set<DVD> value)
    {
        this.ORM_dvds = value;
    }

    public Set<DVD> getORM_dVDs()
    {
        return ORM_dvds;
    }

    public void setORM_Vinis(Set<Vinil> value)
    {
        this.ORM_vinis = value;
    }

    public Set<Vinil> getORM_Vinis()
    {
        return ORM_vinis;
    }

    public String toString()
    {
        return String.valueOf(getCodigo());
    }
}
