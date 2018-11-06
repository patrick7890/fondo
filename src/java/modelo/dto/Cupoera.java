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
@Table(name = "cupoera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cupoera.findAll", query = "SELECT c FROM Cupoera c")
    , @NamedQuery(name = "Cupoera.findByIdcupoera", query = "SELECT c FROM Cupoera c WHERE c.idcupoera = :idcupoera")
    , @NamedQuery(name = "Cupoera.findByFechaInicio", query = "SELECT c FROM Cupoera c WHERE c.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Cupoera.findByFechaTermino", query = "SELECT c FROM Cupoera c WHERE c.fechaTermino = :fechaTermino")
    , @NamedQuery(name = "Cupoera.findByDesembolso", query = "SELECT c FROM Cupoera c WHERE c.desembolso = :desembolso")})
public class Cupoera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcupoera")
    private Integer idcupoera;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_termino")
    @Temporal(TemporalType.DATE)
    private Date fechaTermino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "desembolso")
    private int desembolso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cupoera")
    private List<Socio> socioList;
    @JoinColumn(name = "tipoCuponera_idtipoCuponera", referencedColumnName = "idtipoCuponera")
    @ManyToOne(optional = false)
    private Tipocuponera tipoCuponeraidtipoCuponera;

    public Cupoera() {
    }

    public Cupoera(Integer idcupoera) {
        this.idcupoera = idcupoera;
    }

    public Cupoera(Integer idcupoera, Date fechaInicio, Date fechaTermino, int desembolso) {
        this.idcupoera = idcupoera;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.desembolso = desembolso;
    }

    public Integer getIdcupoera() {
        return idcupoera;
    }

    public void setIdcupoera(Integer idcupoera) {
        this.idcupoera = idcupoera;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public int getDesembolso() {
        return desembolso;
    }

    public void setDesembolso(int desembolso) {
        this.desembolso = desembolso;
    }

    @XmlTransient
    public List<Socio> getSocioList() {
        return socioList;
    }

    public void setSocioList(List<Socio> socioList) {
        this.socioList = socioList;
    }

    public Tipocuponera getTipoCuponeraidtipoCuponera() {
        return tipoCuponeraidtipoCuponera;
    }

    public void setTipoCuponeraidtipoCuponera(Tipocuponera tipoCuponeraidtipoCuponera) {
        this.tipoCuponeraidtipoCuponera = tipoCuponeraidtipoCuponera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcupoera != null ? idcupoera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cupoera)) {
            return false;
        }
        Cupoera other = (Cupoera) object;
        if ((this.idcupoera == null && other.idcupoera != null) || (this.idcupoera != null && !this.idcupoera.equals(other.idcupoera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.dto.Cupoera[ idcupoera=" + idcupoera + " ]";
    }
    
}
