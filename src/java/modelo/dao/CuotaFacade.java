/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.dto.Cuota;

/**
 *
 * @author Patricio
 */
@Stateless
public class CuotaFacade extends AbstractFacade<Cuota> {

    @PersistenceContext(unitName = "FondoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuotaFacade() {
        super(Cuota.class);
    }
    Date d=new Date();
    public List<Cuota> ddl(){
        Query q=em.createNamedQuery("Cuota.ddl");
        q.setParameter("date",d);
        return q.getResultList();
    }
}
