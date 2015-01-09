/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.timeout;

import java.util.concurrent.TimeUnit;
import javax.ejb.AccessTimeout;
import javax.ejb.Singleton;

/**
 *
 * @author Asim Mohammed
 */

@AccessTimeout(value = 3, unit=TimeUnit.SECONDS)
@Singleton
public class Timeout implements TimeoutRemote {
    
    /**
     *
     * @throws InterruptedException
     */
    public void access() throws InterruptedException{
        System.out.println("1");
        Thread.sleep(10000);
    }
}
