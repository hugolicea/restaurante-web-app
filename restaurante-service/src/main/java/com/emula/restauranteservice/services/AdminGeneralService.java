/**
 * 
 */
package com.emula.restauranteservice.services;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import com.emula.restauranteentities.entity.Menu;
import com.emula.restauranteentities.entity.Restaurante;
import com.emula.restauranteentities.entity.TipoRestaurante;
import com.emula.restaurantesdata.impl.RestauranteDAOImpl;
import com.emula.restaurantesdata.impl.TipoRestauranteDAOImpl;

/**
 * @author HL Clase de servicios que se encarga de realizar la logica de
 *         negocios para la administracion de restaurantes para el administrador
 *         general.
 */
public class AdminGeneralService {

	private TipoRestauranteDAOImpl tipoRestauranteDAOImpl = new TipoRestauranteDAOImpl();
	private RestauranteDAOImpl restauranteDAOImpl = new RestauranteDAOImpl();

	/**
	 * Metodo que permite consultar un listado de tipo de restaurantes.
	 * 
	 * @return Lista de tipo de Restaurantes
	 * @throws SQLException Excepcion en caso de error al ejecutar la consulta SQL.
	 */
	public List<TipoRestaurante> consultarTipoRestaurantes() throws SQLException {
		return this.tipoRestauranteDAOImpl.consultar();
	}

	/**
	 * Metodo que permite guardar un registro de tipo restaurantes
	 * 
	 * @param tipoRestaurante Objeto de tipo de restaurate a guardar.
	 * @return 1 en caso de exito o 0 en caso de error.
	 * @throws SQLException Execpcion en caso de error al ejecutar la sentencia SQL.
	 */
	public int guardarTipoRestaurante(TipoRestaurante tipoRestaurante) throws SQLException {

		tipoRestaurante.setFechaCreacion(LocalDateTime.now());
		tipoRestaurante.setStatus(true);
		return this.tipoRestauranteDAOImpl.guardar(tipoRestaurante);
	}

	/**
	 * Metodo que permite actualizar un registro de tipo restaurantes
	 * 
	 * @param tipoRestaurante Objeto de tipo de restaurate a actualizazr.
	 * @return 1 en caso de exito o 0 en caso de error.
	 * @throws SQLException Execpcion en caso de error al ejecutar la sentencia SQL.
	 */
	public int actualizarTipoRestaurante(TipoRestaurante tipoRestaurante) throws SQLException {

		tipoRestaurante.setFechaModificacion(LocalDateTime.now());
		return this.tipoRestauranteDAOImpl.actualizar(tipoRestaurante);
	}

	/**
	 * Metodo que permite eliminar un registro de la tabla tipo restaurante
	 * 
	 * @param idTipoRestaurante id del restaurante a eliminar.
	 * @return 1 en caso de exito | 0 en caso de error
	 * @throws SQLException Excepcion de caso de error al ejecutar la sentecia SQL
	 */
	public int eliminarTipoRestaurante(int idTipoRestaurante) throws SQLException {
		return this.tipoRestauranteDAOImpl.eliminar(idTipoRestaurante);
	}

	/**
	 * Metodo que permite consultar un listado de restaurantes
	 * 
	 * @return lista de restaurantes.
	 * @throws SQLException Execpcion en caso de error al ejecutar la sentencia SQL.
	 */
	public List<Restaurante> consultarRestaurantes() throws SQLException {
		return this.restauranteDAOImpl.consultar();
	}

	/**
	 * Metodo que permite guardar un restaurante.
	 * 
	 * @param Restaurante Objeto a registrar.
	 * @return 1 en caso de exito | 0 en caso de error
	 * @throws SQLException Excepcion de caso de error al ejecutar la sentecia SQL
	 */
	public int guardarRestaurante(Restaurante restaurante) throws SQLException {
		restaurante.setFechaCreacion(LocalDateTime.now());
		restaurante.setStatus(true);
		Menu menu = new Menu();
		menu.setIdMenu(3);
		restaurante.setMenu(menu);

		return this.restauranteDAOImpl.guardar(restaurante);
	}

	/**
	 * Metodo que permite actualizar un registro restaurante
	 * 
	 * @param Restaurante Objeto restaurate a actualizazr.
	 * @return 1 en caso de exito o 0 en caso de error.
	 * @throws SQLException Execpcion en caso de error al ejecutar la sentencia SQL.
	 */
	public int actualizarRestaurante(Restaurante restaurante) throws SQLException {
		restaurante.setFechaModificacion(LocalDateTime.now());
		return this.restauranteDAOImpl.actualizar(restaurante);
	}

	/**
	 * Metodo que permite eliminar un registro de la tabla restaurante
	 * 
	 * @param idRestaurante id del restaurante a eliminar.
	 * @return 1 en caso de exito | 0 en caso de error
	 * @throws SQLException Excepcion de caso de error al ejecutar la sentecia SQL
	 */
	public int eliminarRestaurante(int idRestaurante) throws SQLException {
		return this.restauranteDAOImpl.eliminar(idRestaurante);
	}

}
