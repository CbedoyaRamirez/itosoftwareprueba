package com.itsoftware.mb.usuario;

import com.itosoftware.beans.UsuariosFacadeLocal;
import com.itosoftware.entities.Usuarios;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Carlos
 */
@ManagedBean(name = "beanUsuario")
@RequestScoped
public class ManagedBeanUsuario {

    Integer id;
    String nombres;
    String apellidos;
    Integer numeroID;
    String contrasena;
    Integer tipoUsuario;

    @EJB
    private UsuariosFacadeLocal usuarioFacade;

    public void crearUsuario() {
        try {
            Usuarios usuario = new Usuarios();
            usuario.setId(id);
            usuario.setContrasena(contrasena);
            usuario.setPerfilId(tipoUsuario);
            usuario.setPersonaId(numeroID);
            usuario.setUsuario(nombres + " " + apellidos);
            usuarioFacade.create(usuario);
            mostrarMensaje();
        } catch (Exception e) {
            mostrarMensajeError();
        }

    }

    public ManagedBeanUsuario() {
    }

    private void mostrarMensaje() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dlg').show()");
    }

    private void mostrarMensajeError() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('error').show()");
    }

    public void enviarForm() {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("/creacionUsuario.xhtml");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    /**
     * SECCION DE GETTER Y SETTER
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getNumeroID() {
        return numeroID;
    }

    public void setNumeroID(Integer numeroID) {
        this.numeroID = numeroID;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}
