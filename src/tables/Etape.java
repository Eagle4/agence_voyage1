/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jonathan
 */
@Entity
@Table(name = "ETAPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etape.findAll", query = "SELECT e FROM Etape e"),
    @NamedQuery(name = "Etape.findByOrdre", query = "SELECT e FROM Etape e WHERE e.etapePK.ordre = :ordre"),
    @NamedQuery(name = "Etape.findByPays", query = "SELECT e FROM Etape e WHERE e.pays = :pays"),
    @NamedQuery(name = "Etape.findByDateetape", query = "SELECT e FROM Etape e WHERE e.dateetape = :dateetape"),
    @NamedQuery(name = "Etape.findByDuree", query = "SELECT e FROM Etape e WHERE e.duree = :duree"),
    @NamedQuery(name = "Etape.findById", query = "SELECT e FROM Etape e WHERE e.etapePK.id = :id")})
public class Etape implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EtapePK etapePK;
    @Column(name = "PAYS")
    private String pays;
    @Column(name = "DATEETAPE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateetape;
    @Column(name = "DUREE")
    private BigInteger duree;
    @JoinColumns({
        @JoinColumn(name = "NOMLIEU", referencedColumnName = "NOMLIEU"),
        @JoinColumn(name = "VILLE", referencedColumnName = "VILLE")})
    @OneToOne
    private Lieuxavisiter lieuxavisiter;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Circuit circuit;

    public Etape() {
    }

    public Etape(EtapePK etapePK) {
        this.etapePK = etapePK;
    }

    public Etape(BigInteger ordre, BigInteger id) {
        this.etapePK = new EtapePK(ordre, id);
    }

    public EtapePK getEtapePK() {
        return etapePK;
    }

    public void setEtapePK(EtapePK etapePK) {
        this.etapePK = etapePK;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Date getDateetape() {
        return dateetape;
    }

    public void setDateetape(Date dateetape) {
        this.dateetape = dateetape;
    }

    public BigInteger getDuree() {
        return duree;
    }

    public void setDuree(BigInteger duree) {
        this.duree = duree;
    }

    public Lieuxavisiter getLieuxavisiter() {
        return lieuxavisiter;
    }

    public void setLieuxavisiter(Lieuxavisiter lieuxavisiter) {
        this.lieuxavisiter = lieuxavisiter;
    }

    public Circuit getCircuit() {
        return circuit;
    }

    public void setCircuit(Circuit circuit) {
        this.circuit = circuit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (etapePK != null ? etapePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etape)) {
            return false;
        }
        Etape other = (Etape) object;
        if ((this.etapePK == null && other.etapePK != null) || (this.etapePK != null && !this.etapePK.equals(other.etapePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.Etape[ etapePK=" + etapePK + " ]";
    }
    
}
