/**
 * 
 */
package com.emula.restauranteservice.services;

import java.io.Serializable;
import java.sql.SQLException;

import com.emula.restauranteentities.entity.Empleado;
import com.emula.restaurantesdata.impl.EmpleadoDAOImpl;

/**
 * @author HL Clase que realiza la logica de negocio para la funcionalidad de la
 *         pantalla de login
 *
 */
public class LoginService implements Serializable {

	private static final long serialVersionUID = -1357489571932761802L;
	/**
	 * Objeto para obtener los resultados de las transacciones a la BD para la tabla
	 * empleado.
	 */
	private EmpleadoDAOImpl empleadoDAOImpl = new EmpleadoDAOImpl();

	/**
	 * Metodo que permite consultar un empleado desde el login con su informacion y
	 * perfil de sistema
	 * 
	 * @param usuario
	 * @param password
	 * @param esSuperAdminGeneral para verificar si el usuario es administrador
	 *                            general
	 * @return objeto con usuario logeado
	 * @throws SQLException
	 */
	public Empleado consultarPorUsuarioPassword(String usuario, String password, boolean esSuperAdminGeneral)
			throws SQLException {
		return this.empleadoDAOImpl.consultarPorUsuarioPassword(usuario, password, esSuperAdminGeneral);
	}

}
