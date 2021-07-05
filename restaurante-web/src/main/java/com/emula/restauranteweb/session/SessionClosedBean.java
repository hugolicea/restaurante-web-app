/**
 * 
 */
package com.emula.restauranteweb.session;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.emula.restauranteweb.utils.ControllersUtil;

/**
 * @author HL 7/01/2021 Clase que permite cerrar la sesion del usuario.
 */
@ManagedBean
@ViewScoped
public class SessionClosedBean implements Serializable {

	private static final long serialVersionUID = 4583907436048325677L;

	/**
	 * Metodo que permite cerrar la sesion del usuario.
	 */
	public void cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		try {
			ControllersUtil.redireccionar("/login.xhtml");
			System.out.println("Cerrando Sesion del usuario");
		} catch (IOException e) {
			ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_FATAL, "FATAL: ",
					"Ocurrio un problema al redireccionar a home, volver a pantalla de inicio");
			e.printStackTrace();
		}
	}
}
