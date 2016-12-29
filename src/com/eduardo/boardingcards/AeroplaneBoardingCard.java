package com.eduardo.boardingcards;

public class AeroplaneBoardingCard extends BoardingCard {

	private String flightNumber;
	
	/**
	 * Puerta de embarque
	 */
	private String gate;
	
	/**
	 * Código del mostrador donde realizar check-in
	 */
	private String baggageTicketCounter;
	
	public AeroplaneBoardingCard() {
		super();
	}
	
	/**
	 * Construye un objeto de tipo tarjeta de embarque de avión
	 * @param flightNumber Número de vuelo
	 * @param gate Puerta de embarque
	 * @param baggageTicketCounter Código del mostrador donde realizar el check-in
	 */
	public AeroplaneBoardingCard(String flightNumber, String gate, String baggageTicketCounter) {
		super();
		this.flightNumber = flightNumber;
		this.gate = gate;
		this.baggageTicketCounter = baggageTicketCounter;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public AeroplaneBoardingCard setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
		return this;
	}

	/**
	 * Permite obtener la puerta de embarque de la tarjeta de embarque
	 * @return La puerta de embarque de la tarjeta de embarque
	 */
	public String getGate() {
		return gate;
	}

	/**
	 * Permite modificar la puerta de embarque de la tarjeta de embarque
	 * @param gate La puerta de embarque de la tarjeta de embarque a modificar
	 * @return La tarjeta de embarque con la puerta de embarque modificada
	 */
	public AeroplaneBoardingCard setGate(String gate) {
		this.gate = gate;
		return this;
	}

	/**
	 * Permite obtener el código del mostrador de check-in
	 * @return El código del mostrador de check-in
	 */
	public String getBaggageTicketCounter() {
		return baggageTicketCounter;
	}

	/**
	 * Permite modificar el código del mostrador de check-in
	 * @param baggageTicketCounter El código del mostrador de check-in a modificar
	 * @return La tarjeta de embarque con el código del mostrador de check-in modificado
	 */
	public AeroplaneBoardingCard setBaggageTicketCounter(String baggageTicketCounter) {
		this.baggageTicketCounter = baggageTicketCounter;
		return this;
	}

	@Override
	public String showInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("From ").append(getDeparture().getCity()).append(" Airport, take flight ")
			.append(getFlightNumber()).append(" to ").append(getDestination().getCity())
			.append(". ").append(getGate()).append(", seat ").append(getGate())
			.append(".");
		sb = getBaggageTicketCounter() == null
				? sb.append("Baggage will be automatically transferred from your last leg")
				: sb.append("Baggage drop at ticket counter").append(getBaggageTicketCounter());
		sb.append("\n");
		return sb.toString();
	}
	

}
