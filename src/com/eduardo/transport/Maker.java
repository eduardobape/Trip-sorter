package com.eduardo.transport;

import java.util.List;

import com.eduardo.location.Place;

/**
 * Esta clase abstracta representa el fabricante de un vehículo.
 * Contiene atributos y métodos a modo de ejemplo.
 * @author eduardo
 *
 */
public abstract class Maker {
	
	/**
	 * Nombre del fabricante
	 */
	private String name;
	
	/**
	 * Localización de la sede del fabricante
	 */
	private Place headquarters;
	
	/**
	 * Construye un fabricante cuyo nombre es la cadena vacía y con su sede igual a null
	 */
	protected Maker() {
		name = "";
		headquarters = null;
	}
	
	/**
	 * Construye un fabricante con los parámetros pasados
	 * @param name Nombre del fabricante
	 * @param headquarters Sede central del fabricante
	 */
	protected Maker(String name, Place headquarters) {
		this.name = name;
		this.headquarters = headquarters;
	}
	
	/**
	 * Permite obtener el nombre del fabricante
	 * @return El nombre del fabricante
	 */
	public String getName() {
		return name;
	}
	/**
	 * Permite modificar el nombre del fabricante
	 * @param name El nombre del fabricante a modificar
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Permite obtener la localización de la sede del fabricante
	 * @return La localización de la sede del fabricante
	 */
	public Place getHeadquarters() {
		return headquarters;
	}
	
	/**
	 * Permite modificar la localización de la sede del fabricante
	 * @param headquarters La localización de la sede del fabricante a modificar
	 */
	public void setHeadquarters(Place headquarters) {
		this.headquarters = headquarters;
	}
	
	 /**
	  * Permite obtener los vehículos que este fabricante fabricó durante el año indicado por el parámetro
	  * <code>year</code>
	  * @param year El año en el que se desea averiguar los coches fabricados por el fabricante
	  * @return La lista de vehículos que el fabricante fabricó durante el año indicado por el parámetro <code>year</code>
	  */
	public abstract List<Transport> getVehiclesByYear(int year);

}
