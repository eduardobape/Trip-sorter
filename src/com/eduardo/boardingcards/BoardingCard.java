package com.eduardo.boardingcards;

import java.time.LocalDateTime;

import com.eduardo.location.Place;
import com.eduardo.transport.Transport;
import com.eduardo.transport.TransportCompany;

/**
 * Clase que representa una tarjeta de embarque genérica para cualquier tipo de transporte.
 * <p>
 * Esta clase contiene atributos y métodos de ejemplo que podrían considerarse
 * comunes a cualquier tarjeta de embarque de cualquier tipo de transporte. Dado
 * que la clase BaordingCard podría llegar a contener muchos atributos, muchos
 * de los cuales podr�an ser otros objetos complejos, como un vehículo, un
 * aeropuerto, una estación de trenes o autobuses, la persona propietaria de la
 * tarjeta de embarque, etc; podría optarse por aplicar el patrón Builder para
 * construir objetos de tipo BoardingCard, pero dado que este tipo de objetos
 * necesitan ser instanciados con parámetros especificados en el momento de la
 * ejecución, he optado a modo de solución provisional, por hacer que los
 * métodos de esta clase que modifican los valores de sus atributos, devuelvan
 * this, es decir, el propio objeto que llama al método. De este modo, podremos
 * encadenar llamadas a diferentes métodos set, y evitar tener varios
 * constructores sobrecargados.
 * 
 * {@code
 * BoardingCard bcard = new AerolineBoardingCard();
 * bcard.setSeat("234").setDenied(true).setValid(false);
 * 
 * La forma tradicional con métodos set sería la siguiente:
 * BoardingCard bcard = new AerolineBoardingCard();
 * bcard.setSeat("234");
 * bcard.setDenied(true);
 * bcard.setValid(false);
 * }
 * 
 * @author eduardo
 *
 */
public abstract class BoardingCard {

	/**
	 * Identificador �nico para cada tarjeta de embarque
	 */
	private String identifier;
	
	/**
	 * Lugar de salida
	 */
	private Place departure;
	
	/**
	 * Lugar de llegada
	 */
	private Place destination;
	
	/**
	 * Veh�culo en el que se realiza el viaje
	 */
	private Transport transport;

	/**
	 * Número de asiento en el que el viajero viaja. Podría ser null si el
	 * vehículo no posee asientos, o no hay asientos asignados
	 */
	private String seat;

	/**
	 * Fecha de salida del viaje
	 */
	private LocalDateTime departureDate;

	/**
	 * Fecha de llegada del viaje
	 */
	private LocalDateTime arrivalDate;

	/**
	 * Compañía de transporte
	 */
	private TransportCompany transportCompany;

	/**
	 * Datos del propietario de la tarjeta de embarque. Ver la clase
	 * {@link BoardingCardOwner}
	 */
	private BoardingCardOwner owner;

	/**
	 * Indica si la tarjeta de embarque ha sido rechazada o no
	 */
	private Boolean denied;

	/**
	 * Indica si la tarjeta de embarque es válida o no
	 */
	private Boolean valid;

	// M�s atributos ...

	/**
	 * Construye una tarjeta de embarque son los siguientes datos:
	 * <ul>
	 * <li>Identifier: 000000</li>
	 * <li>Transport company: null</li>
	 * <li>Travel: null</li>
	 * <li>Client: null</li>
	 * <li>Denied: false</li>
	 * <li>Valid: false</li>
	 * </ul>
	 */
	protected BoardingCard() {
		identifier = "000000";
		transport = null;
		seat = "";
		departureDate = LocalDateTime.now();
		arrivalDate = LocalDateTime.now();
		transportCompany = null;
		owner = null;
		denied = false;
		valid = false;
	}

	/**
	 * Construye una tarjeta de embarque con los datos pasados como parámetros
	 * al constructor
	 * 
	 * @param identifier
	 *            Identificador �nico para cada tarjeta de embarque
	 * @param seat
	 *            Número de asiento en el que el viajero viaja. Podría ser null
	 *            si el vehículo no posee asientos, o no hay asiento asignados
	 * @param departureDate
	 *            Fecha de salida
	 * @param arrivalDate
	 *            Fecha de llegada
	 * @param client
	 *            Propietario de la tarjeta de embarque
	 * @param transportCompany
	 * 			  Compañía de transporte
	 */
	protected BoardingCard(String identifier, String seat, LocalDateTime departureDate, LocalDateTime arrivalDate,
			BoardingCardOwner client, TransportCompany transportCompany) {
		this.identifier = identifier;
		this.seat = seat;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.owner = client;
		this.transportCompany = transportCompany;
		denied = false;
		valid = false;
	}

	/**
	 * Permite obtener el identificador único de cada tarjeta de embarque
	 * 
	 * @return El identificador �nico de cada tarjeta de embarque
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * Permite modificar el identificador único de cada tarjeta de embarque
	 * 
	 * @param identifier
	 *            El identificador �nico de cada tarjeta de embarque a modificar
	 * @return El objeto modificado de tipo BoardingCard
	 */
	public BoardingCard setIdentifier(String identifier) {
		this.identifier = identifier;
		return this;
	}
	
	/**
	 * Permite obtener el lugar de salida que figura en la tarjeta de embarque
	 * @return El lugar de salida que figura en la tarjeta de embarque
	 */
	public Place getDeparture() {
		return departure;
	}
	
	/**
	 * Permite modificar el lugar de salida que figura en la tarjeta de embarque
	 * @param departure El lugar de salida que figura en la tarjeta de embarque
	 * @return La tarjeta de embarque con el lugar de salida modificado
	 */
	public BoardingCard setDeparture(Place departure) {
		this.departure = departure;
		return this;
	}
	
	/**
	 * Permite obtener el lugar de destino que figura en la tarjeta de embarque
	 * @return El lugar de destino que figura en la tarjeta de embarque
	 */
	public Place getDestination() {
		return destination;
	}
	
	/**
	 * Permite modificar el lugar de destino que figura en la tarjeta de embarque
	 * @param destination El lugar de destino que figura en la tarjeta de embarque
	 * @return La tarjeta de embarque con el lugar de destino modificado
	 */
	public BoardingCard setDestination(Place destination) {
		this.destination = destination;
		return this;
	}
	
	/**
	 * Permite obtener la compañía de transporte emisora de la tarjeta de
	 * embarque
	 * 
	 * @return La compañía de transporte emisora de la tarjeta de embarque
	 */
	public TransportCompany getTransportCompany() {
		return transportCompany;
	}

	/**
	 * Permite modificar la compañía de transporte emisora de la tarjeta de
	 * embarque
	 * 
	 * @param transportCompany
	 *            La compañía de transporte emisora de la tarjeta de embarque a
	 *            modificar
	 * @return El objeto modificado de tipo BoardingCard
	 * 
	 */
	public BoardingCard setTransportCompany(TransportCompany transportCompany) {
		this.transportCompany = transportCompany;
		return this;
	}

	/**
	 * Permite obtener el vehículo correspondiente a la tarjeta de embarque
	 * 
	 * @return El vehículo�culo correspondiente a la tarjeta de embarque
	 */
	public Transport getTransport() {
		return transport;
	}

	/**
	 * Permite modificar el veh�vehículo correspondiente a la tarjeta de embarque
	 * 
	 * @param transport
	 *            El vehículo�culo correspondiente a la tarjeta de embarque a
	 *            modificar
	 * @return El objeto modificado de tipo BoardingCard
	 */
	public BoardingCard setTransport(Transport transport) {
		this.transport = transport;
		return this;
	}

	/**
	 * Permite obtener el número de asiento donde se sentará el viajero. Puede
	 * tener el valor null si no hay asientos asignados o si el vehículo no
	 * tiene asientos
	 * 
	 * @return El número de asiento donde se sentará el viajero
	 */
	public String getSeat() {
		return seat;
	}

	/**
	 * Permite modificar el número de asiento donde se sentará el viajero
	 * 
	 * @param seat
	 *            El número de asiento a modificar donde se sentará el viajero
	 * @return El objeto modificado de tipo BoardingCard
	 */
	public BoardingCard setSeat(String seat) {
		this.seat = seat;
		return this;
	}

	/**
	 * Permite obtener la fecha de salida del viaje
	 * 
	 * @return La fecha de salida del viaje
	 */
	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	/**
	 * Permite modificar la fecha de salida del viaje
	 * 
	 * @param departureDate
	 *            La fecha de salida del viaje
	 * @return El objeto modificado de tipo BoardingCard
	 */
	public BoardingCard setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
		return this;
	}

	/**
	 * Permite obtener la fecha de llegada del viaje
	 * 
	 * @return La fecha de llegada del viaje. Puede tener valor null si no se
	 *         sabe la fecha de llegada
	 */
	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * Permite modificar la fecha de llegada del viaje
	 * 
	 * @param arrivalDate
	 *            La fecha de llegada a modificar del viaje. Puede tener valor
	 *            null si se quiere especificar que no se conoce la fecha de
	 *            llegada
	 * @return El objeto modificado de tipo BoardingCard
	 */
	public BoardingCard setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
		return this;
	}

	/**
	 * Permite obtener el propietario de la tarjeta de embarque
	 * 
	 * @return El propietario de la tarjeta de embarque
	 */
	public BoardingCardOwner getClient() {
		return owner;
	}

	/**
	 * Permite modificar el propietario de la tarjeta de embarque
	 * 
	 * @param client
	 *            el propietario de la tarjeta de embarque a modificar
	 * @return El objeto modificado de tipo BoardingCard
	 */
	public BoardingCard setClient(BoardingCardOwner client) {
		this.owner = client;
		return this;
	}

	/**
	 * Permite saber si la tarjeta de embarque está denegada
	 * 
	 * @return Devuelve true si la tarjeta de embarque est� denegada, false en
	 *         caso contrario
	 */
	public Boolean getDenied() {
		return denied;
	}

	/**
	 * Permite denegar o no una tarjeta de embarque
	 * 
	 * @param denied
	 *            Puede tener el valor true si se desea denegar la tarjeta de
	 *            embarque, y false en caso de querer dejarla en estado no
	 *            denegada
	 * @return El objeto modificado de tipo BoardingCard
	 */
	public BoardingCard setDenied(Boolean denied) {
		this.denied = denied;
		return this;
	}

	/**
	 * Permite saber si la tarjeta de embarque es válida
	 * 
	 * @return Devuelve true si la tarjeta es válida, false si es inv�lida
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * Permite validar o invalidar una tarjeta de embarque
	 * 
	 * @param valid
	 *            Puede tener el valor true si se desea validar la tarjeta de
	 *            embarque, y false en caso de querer invalidarla
	 * @return El objeto modificado de tipo BoardingCard
	 */
	public BoardingCard setValid(Boolean valid) {
		this.valid = valid;
		return this;
	}
	
	/**
	 * Permite obtener la información contenida en una tarjeta de embarque.
	 * Dependiendo del tipo de transporte, la información mostrada será diferente.
	 * @return La información contenida en una tarjeta de embarque.
	 */
	public abstract String showInfo();

}
