/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.mdb;

import ejb.session.WelcomeRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Asim Mohammed
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/dest"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MBean implements MessageListener {
    @EJB
    private WelcomeRemote welcome;
    
    public MBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage msg = (TextMessage) message;
            String name = msg.getText();
            System.out.println(welcome.welcome(name));
        } catch (JMSException ex) {
            Logger.getLogger(MBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
