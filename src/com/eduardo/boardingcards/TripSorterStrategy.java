package com.eduardo.boardingcards;

import java.util.List;

/**
 * Esta clase representa la clase padre para cualquier estrategia de ordenación de un conjunto de tarjetas
 * de embarque.
 * Esta clase forma parte del patrón Strategy para tener diferentes algoritmos de ordenación de tarjetas
 * de embarque, pero de forma dinámica y extensible
 * @author eduardo
 *
 */

public interface TripSorterStrategy {
	
	public List<BoardingCard> sortTrip(List<BoardingCard> boardingCards);
}
