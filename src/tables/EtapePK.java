/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author jonathan
 */
@Embeddable
public class EtapePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ORDRE")
    private BigInteger ordre;
    @Basic(optional = false)
    @Column(name = "ID")
    private BigInteger id;

    public EtapePK() {
    }

    public EtapePK(BigInteger ordre, BigInteger id) {
        this.ordre = ordre;
        this.id = id;
    }

    public BigInteger getOrdre() {
        return ordre;
    }

    public void setOrdre(BigInteger ordre) {
        this.ordre = ordre;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordre != null ? ordre.hashCode() : 0);
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtapePK)) {
            return false;
        }
        EtapePK other = (EtapePK) object;
        if ((this.ordre == null && other.ordre != null) || (this.ordre != null && !this.ordre.equals(other.ordre))) {
            return false;
        }
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.EtapePK[ ordre=" + ordre + ", id=" + id + " ]";
    }
    
}
