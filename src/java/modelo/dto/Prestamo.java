/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Patricio
 */
@Entity
@Table(name = "prestamo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamo.findAll", query = "SELECT p FROM Prestamo p")
    , @NamedQuery(name = "Prestamo.findByIdprestamo", query = "SELECT p FROM Prestamo p WHERE p.idprestamo = :idprestamo")
    , @NamedQuery(name = "Prestamo.findByValor", query = "SELECT p FROM Prestamo p WHERE p.valor = :valor")
    , @NamedQuery(name = "Prestamo.findByMes", query = "SELECT p FROM Prestamo p WHERE p.mes = :mes")
    , @NamedQuery(name = "Prestamo.findByPagada", query = "SELECT p FROM Prestamo p WHERE p.pagada = :pagada")})
public class Prestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprestamo")
    private Integer idprestamo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private int valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mes")
    @Temporal(TemporalType.DATE)
    private Date mes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pagada")
    private short pagada;
    @JoinColumns({
        @JoinColumn(name = "socio_idsocio", referencedColumnName = "idsocio")
        , @JoinColumn(name = "socio_cupoera_idcupoera", referencedColumnName = "cupoera_idcupoera")})
    @ManyToOne(optional = false)
    private Socio socio;

    public Prestamo() {
    }

    public Prestamo(Integer idprestamo) {
        this.idprestamo = idprestamo;
    }

    public Prestamo(Integer idprestamo, int valor, Date mes, short pagada) {
        this.idprestamo = idprestamo;
        this.valor = valor;
        this.mes = mes;
        this.pagada = pagada;
    }

    public Integer getIdprestamo() {
        return idprestamo;
    }

    public void setIdprestamo(Integer idprestamo) {
        this.idprestamo = idprestamo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Date getMes() {
        return mes;
    }

    public void setMes(Date mes) {
        this.mes = mes;
    }

    public short getPagada() {
        return pagada;
    }

    public void setPagada(short pagada) {
        this.pagada = pagada;
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
        hash += (idprestamo != null ? idprestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamo)) {
            return false;
        }
        Prestamo other = (Prestamo) object;
        if ((this.idprestamo == null && other.idprestamo != null) || (this.idprestamo != null && !this.idprestamo.equals(other.idprestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.dto.Prestamo[ idprestamo=" + idprestamo + " ]";
    }
    
}
