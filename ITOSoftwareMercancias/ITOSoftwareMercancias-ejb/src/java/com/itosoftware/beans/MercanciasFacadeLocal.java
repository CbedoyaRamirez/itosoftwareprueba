/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itosoftware.beans;

import com.itosoftware.entities.Mercancias;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Carlos
 */
@Local
public interface MercanciasFacadeLocal {

    void create(Mercancias mercancias);

    void edit(Mercancias mercancias);

    void remove(Mercancias mercancias);

    Mercancias find(Object id);

    List<Mercancias> findAll();

    List<Mercancias> findRange(int[] range);

    int count();
    
}
