/**
 * 
 */
package com.emula.restaurantesdata.dao;

import java.sql.SQLException;
import java.util.List;

import com.emula.restauranteentities.entity.TipoRestaurante;

/**
 * @author HL Interface que representa el CRUD para la tabla TipoRestaurante en
 *         BD.
 *
 */
public interface TipoRestauranteDAO {
	/**
	 * Mentodo que permite guardar registros de tipo restaurantes en la BD.
	 * 
	 * @param tipoRestaurante objeto a guardar
	 * @return 1 o mas en caso de exito | 0 si no se guardo el registro.
	 * @throws SQLException
	 */
	int guardar(TipoRestaurante tipoRestaurante) throws SQLException;

	/**
	 * Mentodo que permite actualizar registros de tipo restaurantes en la BD.
	 * 
	 * @param tipoRestaurante objeto a actualizar
	 * @return 1 o mas en caso de exito | 0 si no se actualizo el registro
	 * @throws SQLException
	 */

	int actualizar(TipoRestaurante tipoRestaurante) throws SQLException;

	/**
	 * Mentodo que permite eliminar registros de tipo restaurantes en la BD.
	 * 
	 * @param idTipoRestaurante id del registro a actualizar.
	 * @return 1 o mas en caso de exito | 0 si no se elimino el registro
	 * @throws SQLException
	 */
	int eliminar(int idTipoRestaurante) throws SQLException;

	/**
	 * Metoto que permite consultar los registros de Tipo de restaurantes
	 * 
	 * @return lista de tipo de restaurantes | null
	 * @throws SQLException
	 */
	List<TipoRestaurante> consultar() throws SQLException;

	/**
	 * Metodo que permite consultar un registro de la BD
	 * 
	 * @param idTipoRestaurante identificado del registro
	 * @return Objeto tipo restaurante | null
	 * @throws SQLException
	 */
	TipoRestaurante consultarPorId(int idTipoRestaurante) throws SQLException;

}
