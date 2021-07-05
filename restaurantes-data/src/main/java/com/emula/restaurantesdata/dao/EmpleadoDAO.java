/**
 * 
 */
package com.emula.restaurantesdata.dao;

import java.sql.SQLException;
import java.util.List;

import com.emula.restauranteentities.entity.Empleado;

/**
 * @author HL Interface que proporciona el CRUD para las transacciones hacia la
 *         BD en la tabla empleado
 *
 */
public interface EmpleadoDAO {

	/**
	 * Metodo que permite guardar registros de restaurantes en la BD.
	 * 
	 * @param Restaurante objeto a guardar
	 * @return 1 o mas en caso de exito | 0 si no se guardo el registro.
	 * @throws SQLException
	 */
	int guardar(Empleado empleado) throws SQLException;

	/**
	 * Mentodo que permite actualizar registros de restaurantes en la BD.
	 * 
	 * @param Restaurante objeto a actualizar
	 * @return 1 o mas en caso de exito | 0 si no se actualizo el registro
	 * @throws SQLException
	 */

	int actualizar(Empleado empleado) throws SQLException;

	/**
	 * Mentodo que permite eliminar registros de restaurantes en la BD.
	 * 
	 * @param idRestaurante id del registro a actualizar.
	 * @return 1 o mas en caso de exito | 0 si no se elimino el registro
	 * @throws SQLException
	 */
	int eliminar(int idEmpleado) throws SQLException;

	/**
	 * Metoto que permite consultar los registros de Tipo de restaurantes
	 * 
	 * @return lista de restaurantes | null
	 * @throws SQLException
	 */
	List<Empleado> consultar() throws SQLException;

	/**
	 * Metodo que permite consultar un registro de la BD
	 * 
	 * @param idRestaurante identificado del registro
	 * @return Objeto tipo restaurante | null
	 * @throws SQLException
	 */
	Empleado consultarPorId(int idEmpleado) throws SQLException;

}
