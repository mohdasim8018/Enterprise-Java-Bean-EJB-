/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session;

import java.util.Map;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.InitialContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Asim Mohammed
 */
public class HospitalTest {
    
    public HospitalTest() {
    }

    /**
     * Test of displayHospitals method, of class Hospital.
     * @throws java.lang.Exception
     */
    @Test
    public void testDisplayHospitals() throws Exception {
        System.out.println("displayHospitals");
        InitialContext ctx = new InitialContext();
        HospitalRemote instance;
        instance = (HospitalRemote)ctx.lookup("java:global/HospitalsInfo/HospitalsInfo-ejb/Hospital");
        int expResult = 3;
        Map<String, String> result = instance.displayHospitals();
        int resultSize = result.size();
        assertEquals(expResult, resultSize);
    }
    
}
