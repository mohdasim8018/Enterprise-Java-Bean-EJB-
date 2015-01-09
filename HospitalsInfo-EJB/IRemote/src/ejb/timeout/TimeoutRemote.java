/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.timeout;

import javax.ejb.Remote;

/**
 *
 * @author Asim Mohammed
 */
@Remote
public interface TimeoutRemote {

    public void access() throws InterruptedException;
    
}
