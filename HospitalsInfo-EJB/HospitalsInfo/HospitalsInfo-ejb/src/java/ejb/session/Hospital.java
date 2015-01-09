/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;

/**
 *
 * @author Asim Mohammed
 */
@Stateless
public class Hospital implements HospitalRemote {
    	/*
	 * List of available hospitals
	 * */
    @Override
    public Map<String, String> displayHospitals(){
        Map<String, String> hospList = new HashMap<String, String>();
        hospList.put("UI Hospital", "722 W Maxwell St, Chicago, IL 60607");
        hospList.put("Rush Hospital", "1620 W Harrison St, Chicago, IL");
        hospList.put("Stroger Hospital","1969 W Ogden Ave Chicago, IL 60612");
        return hospList;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
