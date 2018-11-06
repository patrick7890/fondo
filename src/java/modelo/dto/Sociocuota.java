/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Patricio
 */
@Entity
@Table(name = "sociocuota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sociocuota.findAll", query = "SELECT s FROM Sociocuota s")
    , @NamedQuery(name = "Sociocuota.findBySociocuotaid", query = "SELECT s FROM Sociocuota s WHERE s.sociocuotaid = :sociocuotaid")})
public class Sociocuota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sociocuotaid")
    private Integer sociocuotaid;
    @JoinColumn(name = "cuota_idcuota", referencedColumnName = "idcuota")
    @ManyToOne(optional = false)
    private Cuota cuotaIdcuota;
    @JoinColumns({
        @JoinColumn(name = "socio_idsocio", referencedColumnName = "idsocio")
        , @JoinColumn(name = "socio_cupoera_idcupoera", referencedColumnName = "cupoera_idcupoera")})
    @ManyToOne(optional = false)
    private Socio socio;

    public Sociocuota() {
    }

    public Sociocuota(Integer sociocuotaid) {
        this.sociocuotaid = sociocuotaid;
    }

    public Integer getSociocuotaid() {
        return sociocuotaid;
    }

    public void setSociocuotaid(Integer sociocuotaid) {
        this.sociocuotaid = sociocuotaid;
    }

    public Cuota getCuotaIdcuota() {
        return cuotaIdcuota;
    }

    public void setCuotaIdcuota(Cuota cuotaIdcuota) {
        this.cuotaIdcuota = cuotaIdcuota;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sociocuotaid != null ? sociocuotaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sociocuota)) {
            return false;
        }
        Sociocuota other = (Sociocuota) object;
        if ((this.sociocuotaid == null && other.sociocuotaid != null) || (this.sociocuotaid != null && !this.sociocuotaid.equals(other.sociocuotaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.dto.Sociocuota[ sociocuotaid=" + sociocuotaid + " ]";
    }
    
}
