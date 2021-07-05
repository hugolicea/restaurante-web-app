/**
 * 
 */
package com.emula.restauranteweb.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.emula.restauranteentities.entity.Empleado;
import com.emula.restauranteservice.services.LoginService;
import com.emula.restauranteweb.session.SessionBean;
import com.emula.restauranteweb.utils.ControllersUtil;

/**
 * @author HL Clase Bean de JSF que se comunica con la pantalla Login.XHTML
 *         NOTA: Siempre agregar @ManagedBean para ligar con una pantalla XHTML
 */
@ManagedBean
@javax.faces.bean.ViewScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 3523036419838535950L;
	private String userName;
	private String password;

	/**
	 * Atributo para indicar si el usuario es adminstrador general.
	 */
	private boolean esSuperAdminGeneral;

	/**
	 * Objeto que mantiene la informacion en sesion del aplicativo.
	 */
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;

	/**
	 * Objerto para obtener la informacion de la logica de negocio del login.
	 */
	private LoginService loginService = new LoginService();

	public void entrar() {
		System.out.println(this.userName);
		System.out.println(this.password);

		try {
			Empleado empleado = this.loginService.consultarPorUsuarioPassword(this.userName, this.password,
					esSuperAdminGeneral);

			if (empleado != null) {
				if (empleado.isStatus()) {
					if (empleado.isSuperadmingeneral()) {
						ControllersUtil.redireccionar("/adminrestaurantes.jsf");
					}
					this.sessionBean.setEmpleado(empleado);
				} else {
					ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR:",
							"Usuario no habilidato en el sistema.");
				}
			} else {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR:",
						"Usuario y/o contrasena son incorrectos.");
			}
		} catch (SQLException e) {
			ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR:",
					"Hubo un problema al procesesar tu solicitud, intenta nuevamente o consulte al equipo de soporte.");
			e.printStackTrace();
		} catch (IOException e) {
			ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR:",
					"Hubo un problema al acceder a la pantalla de inicio, consulte al equipo de soporte.");
			e.printStackTrace();
		}
	}

	/**
	 * @return the esSuperAdminGeneral
	 */
	public boolean isEsSuperAdminGeneral() {
		return esSuperAdminGeneral;
	}

	/**
	 * @param esSuperAdminGeneral the esSuperAdminGeneral to set
	 */
	public void setEsSuperAdminGeneral(boolean esSuperAdminGeneral) {
		this.esSuperAdminGeneral = esSuperAdminGeneral;
	}

	/**
	 * @return the sessionBean
	 */
	public SessionBean getSessionBean() {
		return sessionBean;
	}

	/**
	 * @param sessionBean the sessionBean to set
	 */
	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
