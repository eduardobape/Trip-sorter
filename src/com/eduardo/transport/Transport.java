package com.eduardo.transport;

import java.time.LocalDateTime;

/**
 * Esta clase abstracta representa a un vehículo físico de un determinado tipo de medio de transporte, 
 * avión, tren, autobús, etc.
 * <p>
 * Esta clase muestra sólo algunos ejemplos de atributos y métodos a modo de prueba.
 * 
 * @author eduardo
 *
 */
public abstract class Transport {

	/**
	 * Compañía de transporte a la que pertenece el vehículo
	 */
	private TransportCompany transportCompany;

	/**
	 * Capacidad de pasajeros del vehículo
	 */
	private int capacity;

	/**
	 * Fabricante del vehículo
	 */
	private Maker maker;
	
	/**
	 * Fecha de compra del vehículo
	 */
	private LocalDateTime purchaseDate;
	
	/**
	 * Fecha de comienzo de puesta en funcionamiento del vehículo
	 */
	private LocalDateTime inUseDate;
	
	/**
	 * Construye un vehículo con los siguientes valores:
	 * <ul>
	 * <li>Transport company: null</li>
	 * <li>Capacity: 0</li>
	 * <li>Vehicle maker: null</li>
	 * <li>Purchase date: hoy</li>
	 * <li>In use date: hoy</li>
	 * </ul>
	 */
	public Transport() {
		transportCompany = null;
		capacity = 0;
		maker = null;
		purchaseDate = LocalDateTime.now();
		inUseDate = LocalDateTime.now();
	}
	
	/**
	 * Construye un vehículo con los datos pasados como parámetros
	 * @param transportCompany Compañía de transporte propietaria del vehículo
	 * @param capacity Capacidad de pasajeros del vehículo
	 * @param maker Fabricante del vehículo
	 * @param purchaseDate Fecha de compra del vehículo
	 * @param inUseDate Fecha de puesta en funcionamiento del vehículo
	 */
	public Transport(TransportCompany transportCompany, int capacity, Maker maker, LocalDateTime purchaseDate,
			LocalDateTime inUseDate) {
		this.transportCompany = transportCompany;
		this.capacity = capacity;
		this.maker = maker;
		this.purchaseDate = purchaseDate;
		this.inUseDate = inUseDate;
	}
	
	/**
	 * Obtiene la compañía de transporte a la que pertenece el vehículo
	 * @return La compañía de transporte a la que pertenece el vehículo
	 */
	public TransportCompany getTransportCompany() {
		return transportCompany;
	}

	/**
	 * Establece la compañía de transporte a la que pertenece el vehículo
	 * @param transportCompany La compañía de transporte a la que pertenece el vehículo
	 */
	public void setTransportCompany(TransportCompany transportCompany) {
		this.transportCompany = transportCompany;
	}

	/**
	 * Obtiene el número de plazas totales para personas que posee el vehículo
	 * @return El número de plazas totales para personas que posee el vehículo
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Permite establecer el número de plazas totales para personas que posee el vehículo
	 * @param capacity El número de plazas totales para personas que posee el vehículo
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Obtiene el fabricante del vehículo
	 * @return El fabricante del vehículo
	 */
	public Maker getMaker() {
		return maker;
	}

	/**
	 * Permite establecer el fabricante del vehículo
	 * @param maker El fabricante del vehículo
	 */
	public void setMaker(Maker maker) {
		this.maker = maker;
	}

	/**
	 * Permite obtener la fecha de compra del vehículo
	 * @return La fecha de compra del vehículo
	 */
	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}

	/**
	 * Permite modificar la fecha de compra del vehículo
	 * @param purchaseDate La fecha de compra del vehículo a modificar
	 */
	public void setPurchaseDate(LocalDateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	/**
	 * Permite obtener la fecha en la que el vehículo comenzó a usarse
	 * @return La fecha en la que el vehículo comenzó a usarse
	 */
	public LocalDateTime getInUseDate() {
		return inUseDate;
	}

	/**
	 * Permite modificar la fecha en la que el vehículo comenzó a usarse
	 * @param inUseDate la fecha a modificar en la que el vehículo comenzó a usarse
	 */
	public void setInUseDate(LocalDateTime inUseDate) {
		this.inUseDate = inUseDate;
	}

	/**
	 * Permite saber si el vehículo está fuera de servicio o apto para el transporte
	 * @return True si el vehículo está fuera de servicio. False en caso contrario
	 */
	public abstract boolean isOutOfOrder();

	/**
	 * Permite saber en qué fecha el vehículo pasará a estar fuera de circulación
	 * @return La fecha en la que el vehículo estará fuera de circulación
	 */
	public abstract LocalDateTime dateOffRoad();
	
	/**
	 * Permite obtener el tipo de vehículo (autobús, avión, tren, etc) en una cadena de texto
	 * @return El tipo de vehículo (autobús, avión, tren, etc)) en una cadena de texto
	 */
	public abstract String getTypeVehicle();

	/**
	 * Obtiene una representación textual de la información del vehículo
	 * @return Representación textual de un resumen de la información del vehículo
	 */
	public String showInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Tipo de veh�culo: ").append(getTypeVehicle()).append("\nCompa��a de transporte: ")
			.append(getTransportCompany().getCompanyName());
		return sb.toString();
	}

}
