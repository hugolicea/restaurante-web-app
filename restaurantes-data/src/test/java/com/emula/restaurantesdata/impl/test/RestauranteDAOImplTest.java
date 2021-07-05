/**
 * 
 */
package com.emula.restaurantesdata.impl.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.emula.restauranteentities.entity.Menu;
import com.emula.restauranteentities.entity.Restaurante;
import com.emula.restauranteentities.entity.TipoRestaurante;
import com.emula.restaurantesdata.impl.RestauranteDAOImpl;

/**
 * @author HL
 *
 */
class RestauranteDAOImplTest {

	/**
	 * Test method for
	 * {@link com.emula.restaurantedata.impl.RestauranteDAOImpl#guardar(com.emula.restaurantedata.entity.Restaurante)}.
	 */
	@Test
	void testGuardar() {
		RestauranteDAOImpl restauranteDAOImpl = new RestauranteDAOImpl();
		Restaurante restaurante = new Restaurante();
		TipoRestaurante tipoRestaurante = new TipoRestaurante();
		Menu menu = new Menu();

		restaurante.setNombre("El Mexicano");
		restaurante.setImagen("imagen1.png");
		restaurante.setStatus(true);
		restaurante.setSlogan("Si senor");
		restaurante.setFechaCreacion(LocalDateTime.now());
		tipoRestaurante.setIdTipoRestaurante(17);
		restaurante.setTipoRestaurante(tipoRestaurante);
		menu.setIdMenu(3);
		restaurante.setMenu(menu);

		try {
			int guardado = restauranteDAOImpl.guardar(restaurante);
			assertTrue(guardado > 0);
			System.out.println("Registro guardado exitosamente");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link com.emula.restaurantedata.impl.RestauranteDAOImpl#actualizar(com.emula.restaurantedata.entity.Restaurante)}.
	 */
	@Test
	void testActualizar() {
		RestauranteDAOImpl restauranteDAOImpl = new RestauranteDAOImpl();
		Restaurante restaurante = new Restaurante();
		restaurante.setIdRestaurante(14);
		restaurante.setNombre("El mexicano chido");
		restaurante.setImagen("imagen2.png");
		restaurante.setSlogan("El mero chido");
		restaurante.setFechaModificacion(LocalDateTime.now());
		restaurante.setStatus(true);

		try {
			int actualizado = restauranteDAOImpl.actualizar(restaurante);
			assertTrue(actualizado > 0);
			System.out.println("Registro actualizado exitosamente");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	/**
	 * Test method for
	 * {@link com.emula.restaurantedata.impl.RestauranteDAOImpl#eliminar(int)}.
	 */
	@Test
	void testEliminar() {
		RestauranteDAOImpl restauranteDAOImpl = new RestauranteDAOImpl();
		int idRestaurante = 15;
		try {
			int eliminado = restauranteDAOImpl.eliminar(idRestaurante);
			assertTrue(eliminado > 0);
			System.out.println("El registro fue eliminado exitosamente");
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link com.emula.restaurantedata.impl.RestauranteDAOImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
		RestauranteDAOImpl restauranteDAOImpl = new RestauranteDAOImpl();
		try {
			List<Restaurante> listaRestaurantes = restauranteDAOImpl.consultar();
			assertTrue(listaRestaurantes.size() >= 0);
			for (Restaurante restaurante : listaRestaurantes) {
				System.out.println("IdRestaurante: " + restaurante.getIdRestaurante());
				System.out.println("Nombre: " + restaurante.getNombre());
				System.out.println("Imagen: " + restaurante.getImagen());
				System.out.println("Slogan: " + restaurante.getSlogan());
				System.out.println("FechaCreacion: " + restaurante.getFechaCreacion());
				System.out.println("FechaModificacion: " + restaurante.getFechaModificacion());
				System.out.println("Status: " + restaurante.isStatus());
			}
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link com.emula.restaurantedata.impl.RestauranteDAOImpl#consultarPorId(int)}.
	 */
	@Test
	void testConsultarPorId() {
		fail("Not yet implemented");
	}

}
