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
    private Set<CD> cds = new HashSet<CD>();
    private Set<DVD> dvds = new HashSet<DVD>();
    private Set<Vinil> vinis = new HashSet<Vinil>();

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

    public void setCDs(Set<CD> value)
    {
        this.cds = value;
    }

    public Set<CD> getCDs()
    {
        return cds;
    }

    public void setDVDs(Set<DVD> value)
    {
        this.dvds = value;
    }

    public Set<DVD> getDVDs()
    {
        return dvds;
    }

    public void setVinis(Set<Vinil> value)
    {
        this.vinis = value;
    }

    public Set<Vinil> getVinis()
    {
        return vinis;
    }

    public String toString()
    {
        return String.valueOf(getCodigo());
    }
}
