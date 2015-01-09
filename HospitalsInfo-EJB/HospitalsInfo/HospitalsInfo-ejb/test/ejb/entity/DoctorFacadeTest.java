/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entity;

import com.entity.DoctorFacadeRemote;
import java.util.List;
import javax.naming.InitialContext;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Asim Mohammed
 */
public class DoctorFacadeTest {
    
    public DoctorFacadeTest() {
    }
   
    /**
     * Test of findAll method, of class DoctorFacade.
     * @throws java.lang.Exception
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        InitialContext ctx = new InitialContext();
        DoctorFacadeRemote instance = (DoctorFacadeRemote)ctx.lookup("java:global/HospitalsInfo/HospitalsInfo-ejb/DoctorFacade");
        int expResult = 1;
        List<Doctor> result = instance.findAll();
        int resultSize = result.size();
        assertEquals(expResult, resultSize);
    }    
}
