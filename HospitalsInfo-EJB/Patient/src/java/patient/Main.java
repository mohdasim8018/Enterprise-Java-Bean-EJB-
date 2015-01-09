/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient;

import com.entity.DoctorFacadeRemote;
import ejb.entity.DocRush;
import ejb.entity.DocRushFacadeRemote;
import ejb.entity.DocUI;
import ejb.entity.DocUIFacadeRemote;
import ejb.entity.Doctor;
import ejb.session.HospitalRemote;
import ejb.timeout.TimeoutRemote;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Asim Mohammed
 */
public class Main {
    @Resource(mappedName = "jms/dest")
    private static Queue dest;
    @Resource(mappedName = "jms/queue")
    private static ConnectionFactory queue;
    private String choice;

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getChoice() {
        return choice;
    }

    /**
     * @param args the command line arguments
     * @throws javax.naming.NamingException
     * @throws javax.jms.JMSException
     */
    public static void main(String[] args) throws NamingException, JMSException, InterruptedException {
        // TODO code application logic here
        Main obj = new Main();
        InitialContext Hospctx = new InitialContext();
        HospitalRemote HospStub;
        HospStub = (HospitalRemote)Hospctx.lookup("java:global/HospitalsInfo/HospitalsInfo-ejb/Hospital");
        InitialContext DocCtx = new InitialContext();
        DoctorFacadeRemote DocStub;
        DocStub = (DoctorFacadeRemote)DocCtx.lookup("java:global/HospitalsInfo/HospitalsInfo-ejb/DoctorFacade");
        InitialContext DocRushCtx = new InitialContext();
        DocRushFacadeRemote DocRushStub;
        DocRushStub = (DocRushFacadeRemote)DocRushCtx.lookup("java:global/HospitalsInfo/HospitalsInfo-ejb/DocRushFacade");
        InitialContext DocUICtx = new InitialContext();
        DocUIFacadeRemote DocUIStub;
        DocUIStub = (DocUIFacadeRemote)DocUICtx.lookup("java:global/HospitalsInfo/HospitalsInfo-ejb/DocUIFacade");
        
        
        /*
        *   Records insertion in the DOCRUSH table
        */
        DocRush obj1 = new DocRush();
        obj1.setName("Chase Secrest");
        obj1.setSpeciality("Cardiology");
        DocRushStub.create(obj1);
        obj1.setName("Arnette Cockrum");
        obj1.setSpeciality("Neurology");
        DocRushStub.create(obj1);
        obj1.setName("Aisha Nuss");
        obj1.setSpeciality("Orthopedics");
        DocRushStub.create(obj1);
        
        /*
        *   Records insertion in the DOCUI table
        */
        DocUI obj2 = new DocUI();
        obj2.setName("Clorinda Blankenbaker");
        obj2.setSpeciality("Neurology");
        DocUIStub.create(obj2);
        obj2.setName("Dewitt Kelemen");
        obj2.setSpeciality("Orthopedics");
        DocUIStub.create(obj2);
        obj2.setName("Teresita Spence");
        obj2.setSpeciality("Psychiatry");
        DocUIStub.create(obj2);
        
        /*
        *   Records insertion in the DOC table
        */
        Doctor obj3 = new Doctor();
        obj3.setName("Chase Secrest");
        obj3.setSpeciality("Cardiology");
        DocStub.create(obj3);
        obj3.setName("Arnette Cockrum");
        obj3.setSpeciality("Neurology");
        DocStub.create(obj3);
        obj3.setName("Aisha Nuss");
        obj3.setSpeciality("Orthopedics");
        DocStub.create(obj3);
    
        System.out.println("Please Enter your name: \n");
        Scanner userInputJMS = new Scanner(System.in);
        String username = userInputJMS.next();
        obj.sendJMSMessageToDest(username);
        
        Map<String, String> hosps= HospStub.displayHospitals();
	while (true){
            System.out.println("\t Hospital Name \t\t Address");
            System.out.println("\t ------------- \t\t -------");
	    	
            for(Map.Entry<String,String> entry : hosps.entrySet()) {
       		System.out.printf("\t%-20s \t%-20s %n", entry.getKey(), entry.getValue());
		System.out.println();
            }
            
            while(true) {
                System.out.println("Enter '1' for Doctors"+"\n"+ "Enter '2' for timeout\n"+
                        "Enter '3' to 'Exit Application'");
		Scanner userInput = new Scanner(System.in);
            	String docInsuran = userInput.next();
            	
            	if (docInsuran.equals("1")){
                    while(true){	
                        System.out.println("Enter '1' for 'Stroger' doctors Info \nEnter '2' for 'Rush' "
                            + "doctors Info\nEnter '3' for 'UI Hospital' doctors Info\n"
                            + "Enter '4' to 'Return to previous menu' \n" + "Enter '5' to 'Exit Application'\n");
                        String docChoice = userInput.next();
                        obj.setChoice(docChoice);
        		
                        if (docChoice.equals("4")){
                            break;
                        }
        	
                        if (docChoice.equals("5")){
                            System.exit(0);
                        }
    		
                        /*
                         * Checks patient's choice:
                        * If 1, Stroger associated doctors info is being requested 
                        * If 2, Rush associated doctors info is being requested 
                        * If 3, UI associated doctors info is being requested  
                        * */
                   
                        if ((obj.getChoice()).equals("1")){
                            List<Doctor> l = DocStub.findAll();
                            System.out.println("List of Doctors:");
                            System.out.println("\t Doctor Name \t\t\t Speciality");
                            System.out.println("\t ----------- \t\t\t ------------");
                            for(Doctor b:l){
                                System.out.printf("\t%-30s %-30s %n", b.getName(), b.getSpeciality());
                                System.out.println();
                            }
                        }
                        else if ((obj.getChoice()).equals("2")){
                            List<DocRush> l1 = DocRushStub.findAll();
                            System.out.println("List of Doctors:");
                            System.out.println("\t Doctor Name \t\t\t Speciality");
                            System.out.println("\t ----------- \t\t\t ------------");
                            for(DocRush b:l1){
                                System.out.printf("\t%-30s %-30s %n", b.getName(), b.getSpeciality());
                                System.out.println();
                            }
                        }
                        else if((obj.getChoice()).equals("3")){
                            List<DocUI> l2 = DocUIStub.findAll();
                            System.out.println("List of Doctors:");
                            System.out.println("\t Doctor Name \t\t\t Speciality");
                            System.out.println("\t ----------- \t\t\t ------------");
                            for(DocUI b:l2){
                                System.out.printf("\t%-30s %-30s %n", b.getName(), b.getSpeciality());
                                System.out.println();   
                            }
                        }
                        else{
                            System.out.println("Please enter a valid input");
                        }
                    }
                }	
            	    
                else if(docInsuran.equals("2")){
                    InitialContext timectx;
                    timectx = new InitialContext();
                    TimeoutRemote timeStub;    
                    timeStub = (TimeoutRemote)timectx.lookup("java:global/HospitalsInfo/HospitalsInfo-ejb/Timeout");
                    timeStub.access();
                }
                
                else if (docInsuran.equals("3")){
                    System.exit(0);
                }
                
                
                else {
                    System.err.println("Please enter a valid input");
                }
            }		
        }
    }

    private Message createJMSMessageForjmsDest(Session session, Object messageData) throws JMSException {
        // TODO create and populate message to send
        TextMessage tm = session.createTextMessage();
        tm.setText(messageData.toString());
        return tm;
    }

    private void sendJMSMessageToDest(Object messageData) throws JMSException {
        Connection connection = null;
        Session session = null;
        try {
            connection = queue.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(dest);
            messageProducer.send(createJMSMessageForjmsDest(session, messageData));
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", e);
                }
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
