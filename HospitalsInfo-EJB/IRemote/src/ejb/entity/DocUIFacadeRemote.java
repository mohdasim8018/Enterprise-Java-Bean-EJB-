/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entity;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Asim Mohammed
 */
@Remote
public interface DocUIFacadeRemote {

    void create(DocUI docUI);

    void edit(DocUI docUI);

    void remove(DocUI docUI);

    DocUI find(Object id);

    List<DocUI> findAll();

    List<DocUI> findRange(int[] range);

    int count();
    
}
