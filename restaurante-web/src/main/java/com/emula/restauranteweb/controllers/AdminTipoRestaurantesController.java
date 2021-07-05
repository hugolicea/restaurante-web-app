/**
 * 
 */
package com.emula.restauranteweb.controllers;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.emula.restauranteentities.entity.TipoRestaurante;
import com.emula.restauranteservice.services.AdminGeneralService;
import com.emula.restauranteweb.utils.ControllersUtil;

/**
 * @author HL Clase que permite controlar el flujo de la pantalla de
 *         Aministracion de tipo de restaurantes.
 */
@ManagedBean
@ViewScoped
public class AdminTipoRestaurantesController implements Serializable {

	private static final long serialVersionUID = -1930055954489654574L;

	/**
	 * Lista de tipo de restaurantes para mostrar la informacion en el datatable
	 */
	private List<TipoRestaurante> listTipoRestaurantes;

	/**
	 * Objeto para guardar, actualizar y eliminar tipo restaurantes
	 */
	private TipoRestaurante tipoRestaurante;

	/**
	 * Objeto que permite utilizar los servicios de logica de negocio de tipos de
	 * restaurantes.
	 */
	private AdminGeneralService adminGeneralService = new AdminGeneralService();

	@PostConstruct
	public void init() {

		this.inicializarComponentes();
		this.consultar();
	}

	/**
	 * Permite inicializar la informacion de los componentes
	 */
	public void inicializarComponentes() {
		this.tipoRestaurante = new TipoRestaurante();
	}

	/**
	 * Permite consultar la tabla de tipo restaurantes
	 */
	public void consultar() {
		try {
			this.listTipoRestaurantes = adminGeneralService.consultarTipoRestaurantes();
		} catch (SQLException e) {
			ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR: ",
					"Hubo un problema al cargar la informacion. Consultar al area de soporte");
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que permite guardar un tipo de restaurante.
	 */
	public void guardar() {
		System.out.println("Ejecutando acciones para guardar registro...");
		try {
			int guardado = this.adminGeneralService.guardarTipoRestaurante(this.tipoRestaurante);
			if (guardado > 0) {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_INFO, "INFO: ",
						"Se guardo el registro correctamente, tipo restaurante "
								+ this.tipoRestaurante.getDescripcion());
				this.consultar();
				this.inicializarComponentes();
			} else {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR: ",
						"Ocurrio un error al intentar guardar el registro.");

			}
		} catch (SQLException e) {
			ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR: ",
					"Hubo un problema al cargar la informacion. Consultar al area de soporte");
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que permite actualizar un tipo de restaurante.
	 */
	public void actualizar() {
		System.out.println("Ejecutando acciones para actualizar registro...");
		try {
			int actualizado = this.adminGeneralService.actualizarTipoRestaurante(this.tipoRestaurante);
			if (actualizado > 0) {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_INFO, "INFO: ",
						"Se actualizo el registro correctamente,tipo restaurante "
								+ this.tipoRestaurante.getDescripcion());
				this.consultar();
				this.inicializarComponentes();
			} else {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR: ",
						"Ocurrio un error al intentar actualizar el registro.");

			}
		} catch (SQLException e) {
			ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR: ",
					"Hubo un problema al cargar la informacion. Consultar al area de soporte");
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que permite eliminar un tipo de restaurante.
	 */
	public void eliminar() {
		System.out.println("Ejecutando acciones para eliminar registro...");
		try {
			int eliminado = this.adminGeneralService
					.eliminarTipoRestaurante(this.tipoRestaurante.getIdTipoRestaurante());
			if (eliminado > 0) {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_INFO, "INFO: ",
						"Se elimino el registro correctamente,tipo restaurante "
								+ this.tipoRestaurante.getDescripcion());
				this.consultar();
				this.inicializarComponentes();
			} else {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR: ",
						"Ocurrio un error al intentar eliminar el registro.");

			}
		} catch (SQLException e) {
			ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR: ",
					"Hubo un problema al cargar la informacion. Consultar al area de soporte");
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que permite precargar la informacion del tipo de restaurante
	 * seleccionado en el datatable
	 * 
	 * @param tipoRestaurante Objeto a editar
	 */
	public void cargarInfoModal(TipoRestaurante tipoRestaurante) {
		this.tipoRestaurante = tipoRestaurante;
	}

	/**
	 * @return the tipoRestaurante
	 */
	public TipoRestaurante getTipoRestaurante() {
		return tipoRestaurante;
	}

	/**
	 * @param tipoRestaurante the tipoRestaurante to set
	 */
	public void setTipoRestaurante(TipoRestaurante tipoRestaurante) {
		this.tipoRestaurante = tipoRestaurante;
	}

	/**
	 * @return the listTipoRestaurantes
	 */
	public List<TipoRestaurante> getListTipoRestaurantes() {
		return listTipoRestaurantes;
	}

	/**
	 * @param listTipoRestaurantes the listTipoRestaurantes to set
	 */
	public void setListTipoRestaurantes(List<TipoRestaurante> listTipoRestaurantes) {
		this.listTipoRestaurantes = listTipoRestaurantes;
	}

}
