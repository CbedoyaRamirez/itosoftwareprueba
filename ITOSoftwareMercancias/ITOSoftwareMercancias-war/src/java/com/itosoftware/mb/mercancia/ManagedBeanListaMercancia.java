package com.itosoftware.mb.mercancia;

import com.itosoftware.beans.MercanciasFacadeLocal;
import com.itosoftware.entities.Mercancias;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Carlos
 */
@ManagedBean(name = "beanListaMercancia")
@RequestScoped
public class ManagedBeanListaMercancia {

    @EJB
    private MercanciasFacadeLocal mercanciasFacade;
    
    public ManagedBeanListaMercancia() {
    }
    
    public List<Mercancias> getMercancias(){
        return mercanciasFacade.findAll();
    }
    
}
