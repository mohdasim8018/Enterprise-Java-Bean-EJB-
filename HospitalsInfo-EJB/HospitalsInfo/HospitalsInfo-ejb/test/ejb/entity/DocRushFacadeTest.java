/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entity;

import java.util.List;
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
public class DocRushFacadeTest {
    
    public DocRushFacadeTest() {
    }
    
    /**
     * Test of findAll method, of class DocRushFacade.
     * @throws java.lang.Exception
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        InitialContext ctx = new InitialContext();
        DocRushFacadeRemote instance;
        instance = (DocRushFacadeRemote)ctx.lookup("java:global/HospitalsInfo/HospitalsInfo-ejb/DocRushFacade");
        int expResult = 1;
        List<DocRush> result = instance.findAll();
        int resultSize = result.size();
        assertEquals(expResult, resultSize);
    }
}
