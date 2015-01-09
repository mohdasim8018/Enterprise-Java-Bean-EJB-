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
public class DocUIFacade extends AbstractFacade<DocUI> implements ejb.entity.DocUIFacadeRemote {
    @PersistenceContext(unitName = "HospitalsInfo-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocUIFacade() {
        super(DocUI.class);
    }
    
}
