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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "socio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Socio.findAll", query = "SELECT s FROM Socio s")
    , @NamedQuery(name = "Socio.findByIdsocio", query = "SELECT s FROM Socio s WHERE s.socioPK.idsocio = :idsocio")
    , @NamedQuery(name = "Socio.findByRutsocio", query = "SELECT s FROM Socio s WHERE s.rutsocio = :rutsocio")
    , @NamedQuery(name = "Socio.findByNombre", query = "SELECT s FROM Socio s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Socio.findByApellido", query = "SELECT s FROM Socio s WHERE s.apellido = :apellido")
    , @NamedQuery(name = "Socio.findByTelefonofo", query = "SELECT s FROM Socio s WHERE s.telefonofo = :telefonofo")
    , @NamedQuery(name = "Socio.findByActivo", query = "SELECT s FROM Socio s WHERE s.activo = :activo")
    , @NamedQuery(name = "Socio.findByCupoeraIdcupoera", query = "SELECT s FROM Socio s WHERE s.socioPK.cupoeraIdcupoera = :cupoeraIdcupoera")})
public class Socio implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socio")
    private List<Sociocuota> sociocuotaList;


    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SocioPK socioPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "rutsocio")
    private String rutsocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefonofo")
    private int telefonofo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private short activo;
    @ManyToMany(mappedBy = "socioList")
    private List<Cuota> cuotaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socio")
    private List<Prestamo> prestamoList;
    @JoinColumn(name = "cargo_idcargo", referencedColumnName = "idcargo")
    @ManyToOne
    private Cargo cargoIdcargo;
    @JoinColumn(name = "cupoera_idcupoera", referencedColumnName = "idcupoera", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cupoera cupoera;

    public Socio() {
    }

    public Socio(SocioPK socioPK) {
        this.socioPK = socioPK;
    }

    public Socio(SocioPK socioPK, String rutsocio, String nombre, String apellido, int telefonofo, short activo) {
        this.socioPK = socioPK;
        this.rutsocio = rutsocio;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefonofo = telefonofo;
        this.activo = activo;
    }

    public Socio(int idsocio, int cupoeraIdcupoera) {
        this.socioPK = new SocioPK(idsocio, cupoeraIdcupoera);
    }

    public SocioPK getSocioPK() {
        return socioPK;
    }

    public void setSocioPK(SocioPK socioPK) {
        this.socioPK = socioPK;
    }

    public String getRutsocio() {
        return rutsocio;
    }

    public void setRutsocio(String rutsocio) {
        this.rutsocio = rutsocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefonofo() {
        return telefonofo;
    }

    public void setTelefonofo(int telefonofo) {
        this.telefonofo = telefonofo;
    }

    public short getActivo() {
        return activo;
    }

    public void setActivo(short activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<Cuota> getCuotaList() {
        return cuotaList;
    }

    public void setCuotaList(List<Cuota> cuotaList) {
        this.cuotaList = cuotaList;
    }

    @XmlTransient
    public List<Prestamo> getPrestamoList() {
        return prestamoList;
    }

    public void setPrestamoList(List<Prestamo> prestamoList) {
        this.prestamoList = prestamoList;
    }

    public Cargo getCargoIdcargo() {
        return cargoIdcargo;
    }

    public void setCargoIdcargo(Cargo cargoIdcargo) {
        this.cargoIdcargo = cargoIdcargo;
    }

    public Cupoera getCupoera() {
        return cupoera;
    }

    public void setCupoera(Cupoera cupoera) {
        this.cupoera = cupoera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (socioPK != null ? socioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Socio)) {
            return false;
        }
        Socio other = (Socio) object;
        if ((this.socioPK == null && other.socioPK != null) || (this.socioPK != null && !this.socioPK.equals(other.socioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre+" "+apellido;
    }

    @XmlTransient
    public List<Sociocuota> getSociocuotaList() {
        return sociocuotaList;
    }

    public void setSociocuotaList(List<Sociocuota> sociocuotaList) {
        this.sociocuotaList = sociocuotaList;
    }
    
}
