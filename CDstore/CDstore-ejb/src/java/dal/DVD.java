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

public class DVD extends dal.Artigo implements Serializable {

    public DVD() {
    }
    private String local;
    private java.util.Set ORM_artista = new java.util.HashSet();
    private java.util.Set ORM_temas = new java.util.HashSet();

    public void setLocal(String value) {
        this.local = value;
    }

    public String getLocal() {
        return local;
    }

    private void setORM_Artista(java.util.Set value) {
        this.ORM_artista = value;
    }

    private java.util.Set getORM_Artista() {
        return ORM_artista;
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
