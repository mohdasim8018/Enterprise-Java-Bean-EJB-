/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Asim Mohammed
 */
@Stateless
public class DocRushFacade extends AbstractFacade<DocRush> implements ejb.entity.DocRushFacadeRemote {
    @PersistenceContext(unitName = "HospitalsInfo-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocRushFacade() {
        super(DocRush.class);
    }
    
}
