/**
 * 
 */
package com.emula.restauranteweb.session;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.emula.restauranteentities.entity.Empleado;

/**
 * @author HL Clase de JSF que almacena la informacion del usuario en sesion.
 *
 */
@ManagedBean
@SessionScoped
public class SessionBean implements Serializable {

	private static final long serialVersionUID = 4871533661531716330L;
	/**
	 * Objeto del empleado que inicia la sesion.
	 */
	private Empleado empleado;

	/**
	 * @return the empleado
	 */
	public Empleado getEmpleado() {
		return empleado;
	}

	/**
	 * @param empleado the empleado to set
	 */
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}
