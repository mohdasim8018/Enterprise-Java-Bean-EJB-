/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session;

import javax.ejb.Stateful;

/**
 *
 * @author Asim Mohammed
 */
@Stateful
public class Welcome implements WelcomeRemote {

    /**
     * String to hold welcome message for the user/patient
     */
    public String Wmessage;

    public String getWmessage() {
        return Wmessage;
    }

    /**
     *
     * @param Wmessage
     */
    public void setWmessage(String Wmessage) {
        this.Wmessage = Wmessage;
    }
    
    /**
     * Prepare welcome message
     * @param name
     * @return
     */
    @Override
    public String welcome(String name){
        this.Wmessage = "User "+name+" is running on the system";
        this.setWmessage(Wmessage);
        return Wmessage;
    }
    
}
