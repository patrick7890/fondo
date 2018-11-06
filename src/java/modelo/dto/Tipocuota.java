/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Patricio
 */
@Entity
@Table(name = "tipocuota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipocuota.findAll", query = "SELECT t FROM Tipocuota t")
    , @NamedQuery(name = "Tipocuota.findByIdtipoCuota", query = "SELECT t FROM Tipocuota t WHERE t.idtipoCuota = :idtipoCuota")
    , @NamedQuery(name = "Tipocuota.findByTipo", query = "SELECT t FROM Tipocuota t WHERE t.tipo = :tipo")
    , @NamedQuery(name = "Tipocuota.findByValor", query = "SELECT t FROM Tipocuota t WHERE t.valor = :valor")})
public class Tipocuota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipoCuota")
    private Integer idtipoCuota;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private int valor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoCuotaidtipoCuota")
    private List<Cuota> cuotaList;

    public Tipocuota() {
    }

    public Tipocuota(Integer idtipoCuota) {
        this.idtipoCuota = idtipoCuota;
    }

    public Tipocuota(Integer idtipoCuota, String tipo, int valor) {
        this.idtipoCuota = idtipoCuota;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Integer getIdtipoCuota() {
        return idtipoCuota;
    }

    public void setIdtipoCuota(Integer idtipoCuota) {
        this.idtipoCuota = idtipoCuota;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @XmlTransient
    public List<Cuota> getCuotaList() {
        return cuotaList;
    }

    public void setCuotaList(List<Cuota> cuotaList) {
        this.cuotaList = cuotaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoCuota != null ? idtipoCuota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipocuota)) {
            return false;
        }
        Tipocuota other = (Tipocuota) object;
        if ((this.idtipoCuota == null && other.idtipoCuota != null) || (this.idtipoCuota != null && !this.idtipoCuota.equals(other.idtipoCuota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tipo;
    }
    
}
