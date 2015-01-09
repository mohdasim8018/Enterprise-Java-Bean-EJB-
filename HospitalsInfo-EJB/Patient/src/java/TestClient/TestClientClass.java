/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClient;

import ejb.timeout.TimeoutRemote;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Asim Mohammed
 */
public class TestClientClass {
    public static void main(String[] args) throws NamingException, InterruptedException {
        InitialContext Hospctx = new InitialContext();
        TimeoutRemote HospStub;    
        HospStub = (TimeoutRemote)Hospctx.lookup("java:global/HospitalsInfo/HospitalsInfo-ejb/Timeout");
        HospStub.access();
            
    }
}
