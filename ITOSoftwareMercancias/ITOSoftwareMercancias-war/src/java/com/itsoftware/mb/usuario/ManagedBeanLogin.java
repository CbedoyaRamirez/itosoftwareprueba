package com.itsoftware.mb.usuario;

import com.itosoftware.beans.UsuariosFacadeLocal;
import com.itosoftware.entities.Usuarios;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Carlos
 */
@ManagedBean(name = "beanLogin")
@RequestScoped
public class ManagedBeanLogin {

    Integer id;
    String contrasena;

    @EJB
    private UsuariosFacadeLocal usuariosFacade;

    public ManagedBeanLogin() {
    }

    public void verificarExistenciaUsuario() {
        try {
            Usuarios usuario = new Usuarios();
            Usuarios usuarioResponse = new Usuarios();
            usuario.setId(id);
            usuarioResponse = usuariosFacade.find(id);
            if (usuarioResponse.getContrasena().equals(contrasena)) {
                mostrarMensaje();
            } else {
                mostrarMensajeClienteNoExiste();
            }
        } catch (Exception e) {
            mostrarMensajeError();
        }
    }

    private void mostrarMensaje() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dlg').show()");
    }

    private void mostrarMensajeClienteNoExiste() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('clienteNoExiste').show()");
    }

    private void mostrarMensajeError() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('error').show()");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
