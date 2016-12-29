package com.eduardo.transport;

import java.time.LocalDateTime;

/**
 * Clase que representa el vehículo o medio de transporte de tipo autobús
 * @author eduardo
 *
 */
public class Bus extends Transport {
	
	@Override
	public boolean isOutOfOrder() {
		return false;
	}

	@Override
	public LocalDateTime dateOffRoad() {
		return LocalDateTime.now().plusYears(5);
	}
	
	@Override
	public String getTypeVehicle() {
		return "Bus";
	}
}
