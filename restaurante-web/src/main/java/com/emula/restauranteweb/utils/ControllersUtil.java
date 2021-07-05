package com.emula.restauranteweb.utils;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * 
 * @author HL Clase que permite utilizar metodos generales para el
 *         funcionamiento de los controladores
 */
public class ControllersUtil {

	/**
	 * Metodo que permite navegar entre pantalla del aplicativo
	 * 
	 * @param pagina a redireccionar
	 * @throws IOException Excepcion generada en caso de no encontrar la pagina.
	 */
	public static void redireccionar(String pagina) throws IOException {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		String contextPath = externalContext.getRequestContextPath();
		externalContext.redirect(contextPath.concat(pagina));
	}

	/**
	 * Metodo que permite mostrar un mensaje personalizado al usuario.
	 * 
	 * @param severity Tipo de mensaje.
	 * @param summary  Titulo de la ventana.
	 * @param detail   Descripcion para mostrar al usuario.
	 */
	public static void mostrarMensaje(Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
	}

}
