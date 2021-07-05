/**
 * 
 */
package com.emula.restaurantesdata.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emula.restauranteentities.entity.Restaurante;
import com.emula.restauranteentities.entity.TipoRestaurante;
import com.emula.restaurantesdata.connection.ConnectionFactory;
import com.emula.restaurantesdata.dao.RestauranteDAO;

/**
 * @author HL Clase que implementa el CRUD para la BD Restaurante
 *
 */

public class RestauranteDAOImpl implements RestauranteDAO {

	static {
		try {
			ConnectionFactory.conectar();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.err.println("Error de BD: " + e.getMessage());
		}
	}

	@Override
	public int guardar(Restaurante restaurante) throws SQLException {
		String sql = "INSERT INTO restaurante.restaurante(nombre,imagen,slogan,idTipoRestaurante,fechaCreacion,estatus,idMenu) VALUES('"
				+ restaurante.getNombre() + "','" + restaurante.getImagen() + "','" + restaurante.getSlogan() + "',"
				+ restaurante.getTipoRestaurante().getIdTipoRestaurante() + ",'" + restaurante.getFechaCreacion() + "',"
				+ restaurante.isStatus() + "," + restaurante.getMenu().getIdMenu() + ");";

		int ejecutado = ConnectionFactory.ejecutarSQL(sql);
		return ejecutado;
	}

	@Override
	public int actualizar(Restaurante restaurante) throws SQLException {
		String sql = "UPDATE restaurante.restaurante SET nombre = '" + restaurante.getNombre() + "', imagen = '"
				+ restaurante.getImagen() + "', slogan = '" + restaurante.getSlogan() + "', fechaModificacion = '"
				+ restaurante.getFechaModificacion() + "', estatus = " + restaurante.isStatus()
				+ " WHERE idRestaurante = " + restaurante.getIdRestaurante() + ";";
		int ejecutado = ConnectionFactory.ejecutarSQL(sql);
		return ejecutado;
	}

	@Override
	public int eliminar(int idRestaurante) throws SQLException {
		String sql = "DELETE FROM RESTAURANTE.restaurante WHERE idRestaurante=" + idRestaurante + ";";
		int ejecutado = ConnectionFactory.ejecutarSQL(sql);
		return ejecutado;
	}

	@Override
	public List<Restaurante> consultar() throws SQLException {
		String sql = "SELECT r.*, tr.descripcion FROM restaurante.restaurante r inner join restaurante.tipo_restaurante tr on r.idTipoRestaurante=tr.idTipoRestaurante order by r.nombre;";
		ResultSet rs = ConnectionFactory.ejecutarSQLSelect(sql);
		List<Restaurante> listaRestaurantes = new ArrayList<Restaurante>();

		if (rs != null) {
			while (rs.next()) {
				Restaurante rte = new Restaurante();
				rte.setIdRestaurante(rs.getInt("idRestaurante"));
				rte.setNombre(rs.getString("nombre"));
				rte.setImagen(rs.getString("imagen"));
				rte.setSlogan(rs.getString("slogan"));
				rte.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime());
				rte.setFechaModificacion(rs.getTimestamp("fechaModificacion") != null
						? rs.getTimestamp("fechaModificacion").toLocalDateTime()
						: null);
				rte.setStatus(rs.getBoolean("estatus"));
				TipoRestaurante tipoRestaurante = new TipoRestaurante();
				tipoRestaurante.setDescripcion(rs.getString("descripcion"));
				tipoRestaurante.setIdTipoRestaurante(rs.getInt("idTipoRestaurante"));
				rte.setTipoRestaurante(tipoRestaurante);
				listaRestaurantes.add(rte);
			}
		}
		return listaRestaurantes;
	}

	@Override
	public Restaurante consultarPorId(int idRestaurante) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
