package com.eduardo.transport;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.eduardo.location.Place;

public abstract class TransportCompany {
	
	/**
	 * Nombre de la compañía
	 */
	private String nameCompany;
	
	/**
	 * Año de fundación de la compañía
	 */
	
	private LocalDateTime foundationYear;
	
	/**
	 * Número de empleados de la compañía
	 */
	private int numOfEmployees;
	
	/**
	 * Localización de la sede central de la compañía
	 */
	private Place headquarters;
	
	
	/**
	 * Constructor sin parámetros que construye una compañía de transporte con un nombre con la cadena vacía,
	 * como fecha de fundación hoy, con cero empleados y con localización de su sede con valor null
	 */
	protected TransportCompany() {
		nameCompany = "";
		foundationYear = LocalDateTime.now();
		numOfEmployees = 0;
		headquarters = null;
	}
	
	/**
	 * Constructor
	 * @param nameCompany Nombre de la compañía
	 * @param foundationYear Año de fundaci�n de la compañía
	 * @param numOfEmployees Número de empleados de la compañía
	 * @param headquarters Localización de la sede central de la compañía
	 */
	protected TransportCompany(String nameCompany, LocalDateTime foundationYear, int numOfEmployees, Place headquarters) {
		this.nameCompany = nameCompany;
		this.foundationYear = foundationYear;
		this.numOfEmployees = numOfEmployees;
		this.headquarters = headquarters;
	}

	/**
	 * Permite obtener el nombre de la compañía
	 * @return El nombre de la compañía
	 */
	protected String getCompanyName() {
		return nameCompany;
	}
	
	/**
	 * Permite modificar el nombre de la compañía
	 * @param nameCompany El nombre de la compañía a modificar
	 */
	protected void setCompanyName(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	/**
	 * Permite obtener el año de fundación de la compañía
	 * @return El año de fundación de la compañía
	 */
	protected LocalDateTime getFoundationYear() {
		return foundationYear;
	}

	/**
	 * Permite modificar año de fundación de la compañía
	 * @param foundationYear El año de fundación de la compañía a modificar
	 */
	protected void setFoundationYear(LocalDateTime foundationYear) {
		this.foundationYear = foundationYear;
	}

	/**
	 * Permite obtener el número de empleados de la compañía
	 * @return El número de empleados de la compañía
	 */
	protected int getNumEmployees() {
		return numOfEmployees;
	}
	
	/**
	 * Permite modificar el número de empleados de la compañía
	 * @param numOfEmployees El número de empleados de la compañía
	 */
	protected void setNumEmployees(int numOfEmployees) {
		this.numOfEmployees = numOfEmployees;
	}
	
	/**
	 * Permite obtener la localización de la sede de la compañía
	 * @return La localización de la sede de la compañía
	 */
	protected Place getHeadQuarters() {
		return headquarters;
	}

	/**
	 * Permite modificar la localización de la sede de la compañía
	 * @param headquarters La localización de la sede de la compañía a modificar
	 */
	protected void setHeadQuarters(Place headquarters) {
		this.headquarters = headquarters;
	}

	/**
	 * Muestra información textual de la compañía
	 * @return Cadena de texto que contiene un resumen de la información de la compañía
	 */
	protected String showInfo() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy");
		StringBuilder sb = new StringBuilder();
		sb.append("La compañía ").append(getCompanyName()).append(" fue fundada en ")
			.append(getFoundationYear().format(format));
		return sb.toString();
	}
	
}
