/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import ejb.entity.Doctor;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Asim Mohammed
 */
@Remote
public interface DoctorFacadeRemote {

    void create(Doctor doctor);

    void edit(Doctor doctor);

    void remove(Doctor doctor);

    Doctor find(Object id);

    List<Doctor> findAll();

    List<Doctor> findRange(int[] range);

    int count();
    
}
