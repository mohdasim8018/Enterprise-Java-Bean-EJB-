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
public interface DocRushFacadeRemote {

    void create(DocRush docRush);

    void edit(DocRush docRush);

    void remove(DocRush docRush);

    DocRush find(Object id);

    List<DocRush> findAll();

    List<DocRush> findRange(int[] range);

    int count();
    
}
