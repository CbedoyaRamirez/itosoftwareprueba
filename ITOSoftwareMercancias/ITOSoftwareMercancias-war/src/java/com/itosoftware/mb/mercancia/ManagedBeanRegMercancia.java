package com.itosoftware.mb.mercancia;

import com.itosoftware.beans.MercanciasFacadeLocal;
import com.itosoftware.entities.Mercancias;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Carlos
 */
@ManagedBean(name = "beanRegMercancia")
@RequestScoped
public class ManagedBeanRegMercancia {

    @EJB
    private MercanciasFacadeLocal mercanciaFacade;
    
    private Integer id;
    private String nombreProducto;
    private String ciudadDestino;
    private String direccion;
    private Date fechaSalida;
    private Integer precio;
    private String estadoEnvio;
    private Integer destinatarioId;
    private Integer usuarioRegistroId;   
    
    public ManagedBeanRegMercancia() {
    }
    
    public void crearMercancia(){
        Mercancias mercancia =  new Mercancias();
        mercancia.setCiudadDestino(ciudadDestino);
        mercancia.setDestinatarioId(destinatarioId);
        mercancia.setDireccion(direccion);
        mercancia.setEstadoEnvio(estadoEnvio);
        mercancia.setFechaSalida(fechaSalida); // este campo es de tipo TIME en la base de datos entregada, por ese motivo no escribe la fecha
        mercancia.setId(id);
        mercancia.setNombreProducto(nombreProducto);
        mercancia.setPrecio(precio);
        mercancia.setUsuarioRegistroId(usuarioRegistroId);
        mercanciaFacade.create(mercancia);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(String estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public Integer getDestinatarioId() {
        return destinatarioId;
    }

    public void setDestinatarioId(Integer destinatarioId) {
        this.destinatarioId = destinatarioId;
    }

    public Integer getUsuarioRegistroId() {
        return usuarioRegistroId;
    }

    public void setUsuarioRegistroId(Integer usuarioRegistroId) {
        this.usuarioRegistroId = usuarioRegistroId;
    }
    
    
    
}
