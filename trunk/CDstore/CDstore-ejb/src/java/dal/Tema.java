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

public class Tema implements Serializable
{

    public Tema()
    {
    }

    public Tema(String codigo, String nome)
    {
        this.codigo = codigo;
        this.nome = nome;
    }

    private String codigo;
    private String nome;
    private java.util.Set ORM_cD = new java.util.HashSet();
    private java.util.Set ORM_dVD = new java.util.HashSet();
    private java.util.Set ORM_ladoA = new java.util.HashSet();
    private java.util.Set ORM_ladoB = new java.util.HashSet();

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

    private void setORM_cD(java.util.Set value)
    {
        this.ORM_cD = value;
    }

    private java.util.Set getORM_cD()
    {
        return ORM_cD;
    }

    private void setORM_dVD(java.util.Set value)
    {
        this.ORM_dVD = value;
    }

    private java.util.Set getORM_dVD()
    {
        return ORM_dVD;
    }

    private void setORM_LadoA(java.util.Set value)
    {
        this.ORM_ladoA = value;
    }

    private java.util.Set getORM_LadoA()
    {
        return ORM_ladoA;
    }

    private void setORM_LadoB(java.util.Set value)
    {
        this.ORM_ladoB = value;
    }

    private java.util.Set getORM_LadoB()
    {
        return ORM_ladoB;
    }

    public String toString()
    {
        return String.valueOf(getCodigo());
    }
}
