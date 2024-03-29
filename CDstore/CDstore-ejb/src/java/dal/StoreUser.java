/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author fork
 */
@Entity
public class StoreUser implements Serializable
{

    private static final long serialVersionUID = 1L;

    public StoreUser()
    {
    }

    public StoreUser(String id, String password)
    {
        this.id = id;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String password;

    @ManyToOne
    private StoreGroup usergroup;

    /**
     * Get the value of group
     *
     * @return the value of group
     */
    public StoreGroup getUsergroup()
    {
        return usergroup;
    }

    /**
     * Set the value of group
     *
     * @param group new value of group
     */
    public void setUsergroup(StoreGroup group)
    {
        this.usergroup = group;
    }


    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StoreUser))
        {
            return false;
        }
        StoreUser other = (StoreUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "dal.User[id=" + id + "]";
    }
}
