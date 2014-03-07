/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jonathan
 */
@Entity
@Table(name = "LIEUXAVISITER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lieuxavisiter.findAll", query = "SELECT l FROM Lieuxavisiter l"),
    @NamedQuery(name = "Lieuxavisiter.findByNomlieu", query = "SELECT l FROM Lieuxavisiter l WHERE l.lieuxavisiterPK.nomlieu = :nomlieu"),
    @NamedQuery(name = "Lieuxavisiter.findByVille", query = "SELECT l FROM Lieuxavisiter l WHERE l.lieuxavisiterPK.ville = :ville"),
    @NamedQuery(name = "Lieuxavisiter.findByPays", query = "SELECT l FROM Lieuxavisiter l WHERE l.pays = :pays"),
    @NamedQuery(name = "Lieuxavisiter.findByDescriptif", query = "SELECT l FROM Lieuxavisiter l WHERE l.descriptif = :descriptif"),
    @NamedQuery(name = "Lieuxavisiter.findByPrix", query = "SELECT l FROM Lieuxavisiter l WHERE l.prix = :prix")})
public class Lieuxavisiter implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LieuxavisiterPK lieuxavisiterPK;
    @Column(name = "PAYS")
    private String pays;
    @Column(name = "DESCRIPTIF")
    private String descriptif;
    @Column(name = "PRIX")
    private BigInteger prix;
    @OneToOne(mappedBy = "lieuxavisiter")
    private Etape etape;

    public Lieuxavisiter() {
    }

    public Lieuxavisiter(LieuxavisiterPK lieuxavisiterPK) {
        this.lieuxavisiterPK = lieuxavisiterPK;
    }

    public Lieuxavisiter(String nomlieu, String ville) {
        this.lieuxavisiterPK = new LieuxavisiterPK(nomlieu, ville);
    }

    public LieuxavisiterPK getLieuxavisiterPK() {
        return lieuxavisiterPK;
    }

    public void setLieuxavisiterPK(LieuxavisiterPK lieuxavisiterPK) {
        this.lieuxavisiterPK = lieuxavisiterPK;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public BigInteger getPrix() {
        return prix;
    }

    public void setPrix(BigInteger prix) {
        this.prix = prix;
    }

    public Etape getEtape() {
        return etape;
    }

    public void setEtape(Etape etape) {
        this.etape = etape;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lieuxavisiterPK != null ? lieuxavisiterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lieuxavisiter)) {
            return false;
        }
        Lieuxavisiter other = (Lieuxavisiter) object;
        if ((this.lieuxavisiterPK == null && other.lieuxavisiterPK != null) || (this.lieuxavisiterPK != null && !this.lieuxavisiterPK.equals(other.lieuxavisiterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.Lieuxavisiter[ lieuxavisiterPK=" + lieuxavisiterPK + " ]";
    }
    
}
