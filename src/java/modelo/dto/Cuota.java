/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Patricio
 */
@Entity
@Table(name = "cuota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuota.findAll", query = "SELECT c FROM Cuota c")
    , @NamedQuery(name = "Cuota.ddl", query = "SELECT c FROM Cuota c WHERE function('DATE_FORMAT',c.mes,'%m-%Y')=function('DATE_FORMAT',:date,'%m-%Y') OR c.tipoCuotaidtipoCuota.idtipoCuota=3")
    , @NamedQuery(name = "Cuota.findByIdcuota", query = "SELECT c FROM Cuota c WHERE c.idcuota = :idcuota")
    , @NamedQuery(name = "Cuota.findByMes", query = "SELECT c FROM Cuota c WHERE c.mes = :mes")})
public class Cuota implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuotaIdcuota")
    private List<Sociocuota> sociocuotaList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcuota")
    private Integer idcuota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mes")
    @Temporal(TemporalType.DATE)
    private Date mes;
    @JoinTable(name = "sociocuota", joinColumns = {
        @JoinColumn(name = "cuota_idcuota", referencedColumnName = "idcuota")}, inverseJoinColumns = {
        @JoinColumn(name = "socio_idsocio", referencedColumnName = "idsocio")
        , @JoinColumn(name = "socio_cupoera_idcupoera", referencedColumnName = "cupoera_idcupoera")})
    @ManyToMany
    private List<Socio> socioList;
    @JoinColumn(name = "tipoCuota_idtipoCuota", referencedColumnName = "idtipoCuota")
    @ManyToOne(optional = false)
    private Tipocuota tipoCuotaidtipoCuota;

    public Cuota() {
    }

    public Cuota(Integer idcuota) {
        this.idcuota = idcuota;
    }

    public Cuota(Integer idcuota, Date mes) {
        this.idcuota = idcuota;
        this.mes = mes;
    }

    public Integer getIdcuota() {
        return idcuota;
    }

    public void setIdcuota(Integer idcuota) {
        this.idcuota = idcuota;
    }

    public Date getMes() {
        return mes;
    }

    public void setMes(Date mes) {
        this.mes = mes;
    }

    @XmlTransient
    public List<Socio> getSocioList() {
        return socioList;
    }

    public void setSocioList(List<Socio> socioList) {
        this.socioList = socioList;
    }

    public Tipocuota getTipoCuotaidtipoCuota() {
        return tipoCuotaidtipoCuota;
    }

    public void setTipoCuotaidtipoCuota(Tipocuota tipoCuotaidtipoCuota) {
        this.tipoCuotaidtipoCuota = tipoCuotaidtipoCuota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcuota != null ? idcuota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuota)) {
            return false;
        }
        Cuota other = (Cuota) object;
        if ((this.idcuota == null && other.idcuota != null) || (this.idcuota != null && !this.idcuota.equals(other.idcuota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tipoCuotaidtipoCuota.toString();
    }

    @XmlTransient
    public List<Sociocuota> getSociocuotaList() {
        return sociocuotaList;
    }

    public void setSociocuotaList(List<Sociocuota> sociocuotaList) {
        this.sociocuotaList = sociocuotaList;
    }

}
