package com.eduardo.transport;

import java.time.LocalDateTime;

/**
 * Clase que representa el vehículo o medio de transporte de tipo avión
 * @author eduardo
 *
 */
public class Aeroplane extends Transport {
	
	@Override
	public boolean isOutOfOrder() {
		return false;
	}

	@Override
	public LocalDateTime dateOffRoad() {
		return LocalDateTime.now().plusYears(7);
	}

	@Override
	public String getTypeVehicle() {
		return "Aeroplane";
	}
}
