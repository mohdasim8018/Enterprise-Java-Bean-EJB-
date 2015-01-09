/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entity;

import com.entity.DoctorFacadeRemote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Asim Mohammed
 */
@Stateless
public class DoctorFacade extends AbstractFacade<Doctor> implements DoctorFacadeRemote {
    @PersistenceContext(unitName = "HospitalsInfo-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DoctorFacade() {
        super(Doctor.class);
    }

    @Override
    public void create(Doctor entity) {
        getEntityManager().persist(entity);
    }
    
    
	
	
 
}
