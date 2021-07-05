/**
 * 
 */
package com.emula.restaurantesdata.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emula.restauranteentities.entity.TipoRestaurante;
import com.emula.restaurantesdata.connection.ConnectionFactory;
import com.emula.restaurantesdata.dao.TipoRestauranteDAO;

/**
 * @author HL Clase que implementa el CRUD y otros metodos personalizados de
 *         transacciones desde y hacia la BD en la tabla Tipo_Restaurante
 *
 */
public class TipoRestauranteDAOImpl implements TipoRestauranteDAO {

	@Override
	public int guardar(TipoRestaurante tipoRestaurante) throws SQLException {
		String sql = "INSERT INTO RESTAURANTE.tipo_restaurante(descripcion, fechacreacion, estatus) VALUES('"
				+ tipoRestaurante.getDescripcion() + "','" + tipoRestaurante.getFechaCreacion() + "',"
				+ tipoRestaurante.isStatus() + ");";
		int ejecutado = ConnectionFactory.ejecutarSQL(sql);
		return ejecutado;
	}

	@Override
	public int actualizar(TipoRestaurante tipoRestaurante) throws SQLException {
		String sql = "UPDATE RESTAURANTE.tipo_restaurante set descripcion='" + tipoRestaurante.getDescripcion()
				+ "',fechamodificacion='" + tipoRestaurante.getFechaModificacion() + "',estatus="
				+ tipoRestaurante.isStatus() + " WHERE idTipoRestaurante=" + tipoRestaurante.getIdTipoRestaurante()
				+ ";";
		int ejecutado = ConnectionFactory.ejecutarSQL(sql);
		return ejecutado;
	}

	@Override
	public int eliminar(int idTipoRestaurante) throws SQLException {
		String sql = "DELETE FROM RESTAURANTE.tipo_restaurante WHERE idTipoRestaurante=" + idTipoRestaurante + ";";
		int ejecutado = ConnectionFactory.ejecutarSQL(sql);
		return ejecutado;
	}

	@Override
	public List<TipoRestaurante> consultar() throws SQLException {
		String sql = "select * from restaurante.tipo_restaurante;";
		ResultSet rs = ConnectionFactory.ejecutarSQLSelect(sql);
		List<TipoRestaurante> listaTipoRestaurantes = new ArrayList<TipoRestaurante>();
		if (rs != null) {
			while (rs.next()) {
				TipoRestaurante tr = new TipoRestaurante();
				tr.setIdTipoRestaurante(rs.getInt("idTipoRestaurante"));
				tr.setDescripcion(rs.getString("descripcion"));
				tr.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime());
				tr.setFechaModificacion(rs.getTimestamp("fechaModificacion") != null
						? rs.getTimestamp("fechaModificacion").toLocalDateTime()
						: null);
				tr.setStatus(rs.getBoolean("estatus"));
				listaTipoRestaurantes.add(tr);
			}
		}
		return listaTipoRestaurantes;
	}

	@Override
	public TipoRestaurante consultarPorId(int idTipoRestaurante) throws SQLException {
		String sql = "select * from restaurante.tipo_restaurante WHERE idTipoRestaurante=" + idTipoRestaurante + ";";
		ResultSet rs = ConnectionFactory.ejecutarSQLSelect(sql);
		TipoRestaurante tr = null;
		if (rs != null) {
			if (rs.next()) {
				tr = new TipoRestaurante();
				tr.setIdTipoRestaurante(rs.getInt("idTipoRestaurante"));
				tr.setDescripcion(rs.getString("descripcion"));
				tr.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime());
				tr.setFechaModificacion(rs.getTimestamp("fechaModificacion") != null
						? rs.getTimestamp("fechaModificacion").toLocalDateTime()
						: null);
				tr.setStatus(rs.getBoolean("estatus"));
			}
		}
		return tr;
	}

}
