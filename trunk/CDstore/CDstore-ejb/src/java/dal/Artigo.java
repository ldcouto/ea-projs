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

public class Artigo implements Serializable
{

    public Artigo()
    {
    }

    public Artigo(String codigo, String nome, int stock)
    {
        this.codigo = codigo;
        this.nome = nome;
        this.stock = stock;
    }

    @Override
    public boolean equals(Object aObj)
    {
        if (aObj == this)
        {
            return true;
        }
        if (!(aObj instanceof Artigo))
        {
            return false;
        }
        Artigo artigos = (Artigo) aObj;
        if ((getCodigo() != null && !getCodigo().equals(artigos.getCodigo())) || (getCodigo() == null && artigos.getCodigo() != null))
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

    public static Artigo createArtigos()
    {
        return new dal.Artigo();
    }
    private String codigo;
    private String nome;
    private int stock;

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

    public void setStock(int value)
    {
        this.stock = value;
    }

    public int getStock()
    {
        return stock;
    }

    public String toString()
    {
        return String.valueOf(getCodigo());
    }
}
