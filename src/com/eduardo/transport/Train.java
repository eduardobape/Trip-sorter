package com.eduardo.transport;

import java.time.LocalDateTime;

/**
 * Clase que representa el vehículo o medio de transporte de tipo tren
 * @author eduardo
 *
 */
public class Train extends Transport {
	
	private String trainNumber;
	
	public Train(String trainNumber) {
		super();
		this.trainNumber = trainNumber;
	}
	
	/**
	 * Permite obtener el número del tren
	 * @return El número del tren
	 */
	public String getTrainNumber() {
		return trainNumber;
	}

	/**
	 * Permite modificar el número del tren
	 * @param trainNumber El número del tren a modificar
	 */
	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}
	
	
	@Override
	public boolean isOutOfOrder() {
		return false;
	}

	@Override
	public LocalDateTime dateOffRoad() {
		return LocalDateTime.now().plusYears(10);
	}

	@Override
	public String getTypeVehicle() {
		return "Train";
	}	
}
