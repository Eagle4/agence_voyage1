/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import outils.ConnexionBdd;
import outils.TableModel;

/**
 *
 * @author jonathan
 */
@Entity
@Table(name = "CIRCUIT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Circuit.findAll", query = "SELECT c FROM Circuit c"),
    @NamedQuery(name = "Circuit.findById", query = "SELECT c FROM Circuit c WHERE c.id = :id"),
    @NamedQuery(name = "Circuit.findByDescriptif", query = "SELECT c FROM Circuit c WHERE c.descriptif = :descriptif"),
    @NamedQuery(name = "Circuit.findByVilledepart", query = "SELECT c FROM Circuit c WHERE c.villedepart = :villedepart"),
    @NamedQuery(name = "Circuit.findByVillearrive", query = "SELECT c FROM Circuit c WHERE c.villearrive = :villearrive"),
    @NamedQuery(name = "Circuit.findByPaysarrive", query = "SELECT c FROM Circuit c WHERE c.paysarrive = :paysarrive"),
    @NamedQuery(name = "Circuit.findByDatedepart", query = "SELECT c FROM Circuit c WHERE c.datedepart = :datedepart"),
    @NamedQuery(name = "Circuit.findByNbplacedisponible", query = "SELECT c FROM Circuit c WHERE c.nbplacedisponible = :nbplacedisponible"),
    @NamedQuery(name = "Circuit.findByDuree", query = "SELECT c FROM Circuit c WHERE c.duree = :duree"),
    @NamedQuery(name = "Circuit.findByPrix", query = "SELECT c FROM Circuit c WHERE c.prix = :prix")})
public class Circuit implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "DESCRIPTIF")
    private String descriptif;
    @Column(name = "VILLEDEPART")
    private String villedepart;
    @Column(name = "VILLEARRIVE")
    private String villearrive;
    @Column(name = "PAYSARRIVE")
    private String paysarrive;
    @Column(name = "DATEDEPART")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedepart;
    @Column(name = "NBPLACEDISPONIBLE")
    private BigInteger nbplacedisponible;
    @Column(name = "DUREE")
    private BigInteger duree;
    @Column(name = "PRIX")
    private BigInteger prix;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "circuit")
    private Collection<Etape> etapeCollection;
    @OneToMany(mappedBy = "id")
    private Collection<Reserver> reserverCollection;

    public Circuit() {
    }

    public Circuit(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public String getVilledepart() {
        return villedepart;
    }

    public void setVilledepart(String villedepart) {
        this.villedepart = villedepart;
    }

    public String getVillearrive() {
        return villearrive;
    }

    public void setVillearrive(String villearrive) {
        this.villearrive = villearrive;
    }

    public String getPaysarrive() {
        return paysarrive;
    }

    public void setPaysarrive(String paysarrive) {
        this.paysarrive = paysarrive;
    }

    public Date getDatedepart() {
        return datedepart;
    }

    public void setDatedepart(Date datedepart) {
        this.datedepart = datedepart;
    }

    public BigInteger getNbplacedisponible() {
        return nbplacedisponible;
    }

    public void setNbplacedisponible(BigInteger nbplacedisponible) {
        this.nbplacedisponible = nbplacedisponible;
    }

    public BigInteger getDuree() {
        return duree;
    }

    public void setDuree(BigInteger duree) {
        this.duree = duree;
    }

    public BigInteger getPrix() {
        return prix;
    }

    public void setPrix(BigInteger prix) {
        this.prix = prix;
    }

    @XmlTransient
    public Collection<Etape> getEtapeCollection() {
        return etapeCollection;
    }

    public void setEtapeCollection(Collection<Etape> etapeCollection) {
        this.etapeCollection = etapeCollection;
    }

    @XmlTransient
    public Collection<Reserver> getReserverCollection() {
        return reserverCollection;
    }

    public void setReserverCollection(Collection<Reserver> reserverCollection) {
        this.reserverCollection = reserverCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Circuit)) {
            return false;
        }
        Circuit other = (Circuit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tables.Circuit[ id=" + id + " ]";
    }
    


        
        
}
