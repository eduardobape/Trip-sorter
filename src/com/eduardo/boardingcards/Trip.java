package com.eduardo.boardingcards;

import java.util.List;

/**
 * Representa un viaje realizado con una serie de tarjetas de embarque o de viaje
 * @author eduardo
 *
 */
public class Trip {
	
	/**
	 * Tarjetas de embarque o de viaje para usar durante el viaje y llegar de un punto a otro
	 */
	private List<BoardingCard> boardingCards;
	
	private TripSorterStrategy orderingStrategy;
		
	/**
	 * Construye un objeto de tipo viaje
	 * @param boardingCards La lista de tarjeta de viaje o embarque para usar en cada una de 
	 * las paradas del viaje
	 */
	public Trip(List<BoardingCard> boardingCards) {
		this.boardingCards = boardingCards;
	}
	
	public void setOrderingTravelStrategy(TripSorterStrategy orderingStrategy) {
		this.orderingStrategy = orderingStrategy;
	}
	
	public List<BoardingCard> sortTrip(List<BoardingCard> boardingCards) {
		this.boardingCards = orderingStrategy.sortTrip(boardingCards);
		return boardingCards;
	}
	
	/**
	 * Permite obtener una cadena de texto que indica la informaci�n contenida en cada una
	 * de las tarjetas de embarque o de viaje a usar durante el viaje
	 * @return Una cadena de texto que indica la informaci�n contenida en cada una
	 * de las tarjetas de embarque o de viaje a usar durante el viaje
	 */
	public String showInfoTravel() {
		StringBuffer sb = new StringBuffer();
		for (BoardingCard bcard : boardingCards) {
			sb.append(bcard.showInfo());
		}
		sb.append("You have arrived at your final destination.");
		return sb.toString();
	}
}
