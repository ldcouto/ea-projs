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

public class CD extends dal.Artigo implements Serializable {

    public CD() {
    }

    public CD(String codigo, String nome, int stock)
    {
        super(codigo, nome, stock);
    }

    private String tipo;
    private java.util.Set ORM_autor = new java.util.HashSet();
    private java.util.Set ORM_temas = new java.util.HashSet();

    public void setTipo(String value) {
        this.tipo = value;
    }

    public String getTipo() {
        return tipo;
    }

    private void setORM_Autor(java.util.Set value) {
        this.ORM_autor = value;
    }

    private java.util.Set getORM_Autor() {
        return ORM_autor;
    }

    private void setORM_Temas(java.util.Set value) {
        this.ORM_temas = value;
    }

    private java.util.Set getORM_Temas() {
        return ORM_temas;
    }

    public String toString() {
        return super.toString();
    }
}
