/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author jonathan
 */
@Embeddable
public class LieuxavisiterPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "NOMLIEU")
    private String nomlieu;
    @Basic(optional = false)
    @Column(name = "VILLE")
    private String ville;

    public LieuxavisiterPK() {
    }

    public LieuxavisiterPK(String nomlieu, String ville) {
        this.nomlieu = nomlieu;
        this.ville = ville;
    }

    public String getNomlieu() {
        return nomlieu;
    }

    public void setNomlieu(String nomlieu) {
        this.nomlieu = nomlieu;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomlieu != null ? nomlieu.hashCode() : 0);
        hash += (ville != null ? ville.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LieuxavisiterPK)) {
            return false;
        }
        LieuxavisiterPK other = (LieuxavisiterPK) object;
        if ((this.nomlieu == null && other.nomlieu != null) || (this.nomlieu != null && !this.nomlieu.equals(other.nomlieu))) {
            return false;
        }
        if ((this.ville == null && other.ville != null) || (this.ville != null && !this.ville.equals(other.ville))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.LieuxavisiterPK[ nomlieu=" + nomlieu + ", ville=" + ville + " ]";
    }
    
}
