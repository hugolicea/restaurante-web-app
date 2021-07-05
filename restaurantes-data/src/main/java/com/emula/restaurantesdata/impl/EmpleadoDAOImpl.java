/**
 * 
 */
package com.emula.restaurantesdata.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.emula.restauranteentities.entity.Empleado;
import com.emula.restauranteentities.entity.Rol;
import com.emula.restaurantesdata.connection.ConnectionFactory;
import com.emula.restaurantesdata.dao.EmpleadoDAO;

/**
 * @author HL Clase que implemanenta CRUD de la entity Empleado
 */
public class EmpleadoDAOImpl implements EmpleadoDAO {

	static {
		try {
			ConnectionFactory.conectar();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.err.println("Error de BD: " + e.getMessage());
		}
	}

	@Override
	public int guardar(Empleado empleado) throws SQLException {
		String sql = "INSERT INTO restaurante.empleado (nombre, primerApellido, segundoApellido, idRol, usuario, password, email, superadmin, superadmingeneral, fechaCreacion, estatus) VALUES ('"
				+ empleado.getNombre() + "', '" + empleado.getPrimerApellido() + "', '" + empleado.getSegundoApellido()
				+ "', " + empleado.getRol().getIdRol() + ", '" + empleado.getUsuario() + "', '" + empleado.getPassword()
				+ "', '" + empleado.getEmail() + "'," + empleado.isSuperadmin() + ", " + empleado.isSuperadmingeneral()
				+ ", '" + empleado.getFechaCreacion() + "', " + empleado.isStatus() + ");";

		int ejecutado = ConnectionFactory.ejecutarSQL(sql);
		return ejecutado;
	}

	@Override
	public int actualizar(Empleado empleado) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar(int idEmpleado) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Empleado> consultar() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado consultarPorId(int idEmpleado) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

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
		Empleado empleado = null;
		String sql = "";
		if (esSuperAdminGeneral) {
			sql = "select e.*,r.nombre as nombrerol from restaurante.empleado e, restaurante.rol r where e.idRol=r.idRol "
					+ "and (e.usuario='" + usuario + "' or e.email='" + usuario + "') and e.password='" + password
					+ "'and e.idSucursal is null;";
		} else {
			// TODO Reemplazar por codigo para usuario administrador sucursal y empleado
		}
		ResultSet rs = ConnectionFactory.ejecutarSQLSelect(sql);

		if (rs != null) {
			if (rs.next()) {
				empleado = new Empleado();
				empleado.setIdEmpleado(rs.getInt("idEmpleado"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setPrimerApellido(rs.getString("primerApellido"));
				empleado.setSegundoApellido(rs.getString("segundoApellido"));
				empleado.setUsuario(rs.getString("usuario"));
				empleado.setPassword(rs.getString("password"));
				empleado.setEmail(rs.getString("email"));
				empleado.setStatus(rs.getBoolean("estatus"));
				empleado.setSuperadmin(rs.getBoolean("superadmin"));
				empleado.setSuperadmingeneral(rs.getBoolean("superadmingeneral"));

				Rol rol = new Rol();
				rol.setIdRol(rs.getInt("idrol"));
				rol.setNombre(rs.getString("nombrerol"));
				empleado.setRol(rol);
			}
		}
		return empleado;
	}
}
