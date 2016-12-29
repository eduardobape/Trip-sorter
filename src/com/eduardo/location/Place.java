package com.eduardo.location;

import java.util.Arrays;
import java.util.List;

import com.eduardo.location.Place;

/**
 * Esta clase representa una localización geográfica correspondiente a una localidad
 * @author eduardo
 *
 */
public class Place {
	
	/**
	 * Identificador único para cada localización
	 */
	private String identifier;
	
	/**
	 * Nombre de la localidad
	 */
	private String city;
	
	/**
	 * Nombre del país
	 */
	private String country;
	
	/**
	 * Longitud en coordenadas decimales
	 */
	private double longitude;
	
	/**
	 * Latitud en coordinadas decimales
	 */
	private double latitude;
	
	/**
	 * Construye una localización con identificador 000000, con la cadena vacía como ciudad y país,
	 * y con longitud y latitud 0.0
	 */
	public Place() {
		identifier = "000000";
		city = "";
		country = "";
		longitude = 0.0;
		latitude = 0.0;
	}
	
	/**
	 * Construye una localización con los parámetros indicados
	 * @param identifier Identificador único para cada localización
	 * @param city Ciudad
	 * @param country País
	 */
	public Place(String identifier, String city, String country) {
		this.identifier = identifier;
		this.city = city;
		this.country = country;
	}
	
	/**
	 * Construye una localización con los parámetros indicados
	 * @param identifier Identificador único para cada localización
	 * @param city Ciudad
	 * @param country País
	 * @param longitude Longitud de la localidad
	 * @param latitude Latitud de la localidad
	 */
	public Place(String identifier, String city, String country, double longitude, double latitude) {
		this.identifier = identifier;
		this.city = city;
		this.country = country;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	/**
	 * Permite obtener el identificador único de la localidad
	 * @return El identificador único de la localidad
	 */
	public String getIdentifier() {
		return identifier;
	}
	
	/**
	 * Permite modificar el identificador único de la localidad
	 * @param identifier El identificador único de la localidad
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	/**
	 * Permite obtener la localidad (ciudad, pueblo, villa, aldea, etc) de la localización
	 * @return La localidad correspondiente a la localización
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Permite modificar la localidad correspondiente a la localización
	 * @param city La localidad correspondiente a la localización
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Permite obtener el país correspondiente a la localidad de la localización
	 * @return El país correspondiente a la localidad de la localización
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * Permite modificar el país correspondiente a la localidad de la localización
	 * @param country El país correspondiente a la localidad de la localización
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * Permite obtener la longitud en coordenadas decimales de la localidad de la localización
	 * @return La longitud en coordenadas decimales de la localidad de la localización
	 */
	public double getLongitude() {
		return longitude;
	}
	
	/**
	 * Permite modificar la longitud en coordenadas decimales de la localidad de la localización
	 * @param longitude La longitud en coordenadas decimales de la localidad de la localización
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * Permite obtener la latitud en coordenadas decimales de la localidad de la localización
	 * @return La latitud en coordenadas decimales de la localidad de la localización
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Permite modificar la latitud en coordenadas decimales de la localidad de la localización
	 * @param latitude La latitud en coordenadas decimales de la localidad de la localización
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * Permite obtener los lugares más cercanos a una localidad en un radio en kilómetros indicado por
	 * el parámetro <code>distance</code>
	 * @param distance Radio de búsqueda (en kilómetros)
	 * @return La lista de localidades que se encuentran dentro de un radio de <code>distance</code> kilómetros
	 */
	public List<Place> nearestPlaces(double distance) {
		return Arrays.asList(
				new Place("000001", "Barcelona", "Espa�a", 23.456, 12.345),
				new Place("000002", "Munich", "Alemania", 2.456, 1.345),
				new Place("000003", "Lisboa", "Portugal", 20.456, 10.345));
	}
}
