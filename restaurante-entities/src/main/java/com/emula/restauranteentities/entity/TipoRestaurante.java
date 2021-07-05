/**
 * 
 */
package com.emula.restauranteentities.entity;

import java.util.List;

/**
 * @author HL Clase que representa una entidad Tipo Restaurante en la BD
 *
 */
public class TipoRestaurante extends CommonEntity {
	private Integer idTipoRestaurante;
	private String descripcion;
	private List<Restaurante> listaRestaurante;

	/**
	 * @return the listaRestaurante
	 */
	public List<Restaurante> getListaRestaurante() {
		return listaRestaurante;
	}

	/**
	 * @param listaRestaurante the listaRestaurante to set
	 */
	public void setListaRestaurante(List<Restaurante> listaRestaurante) {
		this.listaRestaurante = listaRestaurante;
	}

	/**
	 * @return the idTipoRestaurante
	 */
	public Integer getIdTipoRestaurante() {
		return idTipoRestaurante;
	}

	/**
	 * @param idTipoRestaurante the idTipoRestaurante to set
	 */
	public void setIdTipoRestaurante(Integer idTipoRestaurante) {
		this.idTipoRestaurante = idTipoRestaurante;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
