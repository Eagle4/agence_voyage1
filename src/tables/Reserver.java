/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jonathan
 */
@Entity
@Table(name = "RESERVER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserver.findAll", query = "SELECT r FROM Reserver r"),
    @NamedQuery(name = "Reserver.findByIdreserv", query = "SELECT r FROM Reserver r WHERE r.idreserv = :idreserv"),
    @NamedQuery(name = "Reserver.findByNbplace", query = "SELECT r FROM Reserver r WHERE r.nbplace = :nbplace"),
    @NamedQuery(name = "Reserver.findByDatereserv", query = "SELECT r FROM Reserver r WHERE r.datereserv = :datereserv")})
public class Reserver implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDRESERV")
    private BigDecimal idreserv;
    @Column(name = "NBPLACE")
    private BigInteger nbplace;
    @Column(name = "DATERESERV")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datereserv;
    @JoinColumn(name = "IDCLIENT", referencedColumnName = "IDCLIENT")
    @ManyToOne
    private Client idclient;
    @JoinColumn(name = "ID", referencedColumnName = "ID")
    @ManyToOne
    private Circuit id;

    public Reserver() {
    }

    public Reserver(BigDecimal idreserv) {
        this.idreserv = idreserv;
    }

    public BigDecimal getIdreserv() {
        return idreserv;
    }

    public void setIdreserv(BigDecimal idreserv) {
        this.idreserv = idreserv;
    }

    public BigInteger getNbplace() {
        return nbplace;
    }

    public void setNbplace(BigInteger nbplace) {
        this.nbplace = nbplace;
    }

    public Date getDatereserv() {
        return datereserv;
    }

    public void setDatereserv(Date datereserv) {
        this.datereserv = datereserv;
    }

    public Client getIdclient() {
        return idclient;
    }

    public void setIdclient(Client idclient) {
        this.idclient = idclient;
    }

    public Circuit getId() {
        return id;
    }

    public void setId(Circuit id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreserv != null ? idreserv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserver)) {
            return false;
        }
        Reserver other = (Reserver) object;
        if ((this.idreserv == null && other.idreserv != null) || (this.idreserv != null && !this.idreserv.equals(other.idreserv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.Reserver[ idreserv=" + idreserv + " ]";
    }
    
}
