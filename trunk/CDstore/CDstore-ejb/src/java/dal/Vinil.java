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

public class Vinil extends dal.Artigo implements Serializable {

    public Vinil() {
    }

    public Vinil(String codigo, String nome, int stock)
    {
        super(codigo, nome, stock);
    }

    private String rotacoes;
    private java.util.Set ORM_artista = new java.util.HashSet();
    private java.util.Set ORM_temasLadoA = new java.util.HashSet();
    private java.util.Set ORM_temasLadoB = new java.util.HashSet();

    public void setRotacoes(String value) {
        this.rotacoes = value;
    }

    public String getRotacoes() {
        return rotacoes;
    }

    private void setORM_Artista(java.util.Set value) {
        this.ORM_artista = value;
    }

    private java.util.Set getORM_Artista() {
        return ORM_artista;
    }

    private void setORM_TemasLadoA(java.util.Set value) {
        this.ORM_temasLadoA = value;
    }

    private java.util.Set getORM_TemasLadoA() {
        return ORM_temasLadoA;
    }

    private void setORM_TemasLadoB(java.util.Set value) {
        this.ORM_temasLadoB = value;
    }

    private java.util.Set getORM_TemasLadoB() {
        return ORM_temasLadoB;
    }

    public String toString() {
        return super.toString();
    }
}
