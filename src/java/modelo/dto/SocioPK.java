/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Patricio
 */
@Embeddable
public class SocioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idsocio")
    private int idsocio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cupoera_idcupoera")
    private int cupoeraIdcupoera;

    public SocioPK() {
    }

    public SocioPK(int idsocio, int cupoeraIdcupoera) {
        this.idsocio = idsocio;
        this.cupoeraIdcupoera = cupoeraIdcupoera;
    }

    public int getIdsocio() {
        return idsocio;
    }

    public void setIdsocio(int idsocio) {
        this.idsocio = idsocio;
    }

    public int getCupoeraIdcupoera() {
        return cupoeraIdcupoera;
    }

    public void setCupoeraIdcupoera(int cupoeraIdcupoera) {
        this.cupoeraIdcupoera = cupoeraIdcupoera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idsocio;
        hash += (int) cupoeraIdcupoera;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SocioPK)) {
            return false;
        }
        SocioPK other = (SocioPK) object;
        if (this.idsocio != other.idsocio) {
            return false;
        }
        if (this.cupoeraIdcupoera != other.cupoeraIdcupoera) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.dto.SocioPK[ idsocio=" + idsocio + ", cupoeraIdcupoera=" + cupoeraIdcupoera + " ]";
    }
    
}
