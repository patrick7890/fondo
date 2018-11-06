/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.dto.Sociocuota;

/**
 *
 * @author Patricio
 */
@Stateless
public class SociocuotaFacade extends AbstractFacade<Sociocuota> {

    @PersistenceContext(unitName = "FondoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SociocuotaFacade() {
        super(Sociocuota.class);
    }
    
}
