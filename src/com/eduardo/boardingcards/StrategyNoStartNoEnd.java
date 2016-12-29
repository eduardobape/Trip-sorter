package com.eduardo.boardingcards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * Siguiendo el patrón Strategy para la ordenación de un conjunto de tarjetas de
 * embarque, esta clase representa una estrategia de ordenación concreta. 
 * A partir de una lista de tarjetas de embarque desordenadas, que representan un
 * viaje que tenemos que hacer con diferentes paradas, y en la que no sabemos
 * que tarjeta representa el punto de partida y el fin de nuestro viaje, la
 * estrategia de ordenamiento de este método ordena dichas tarjetas de modo que
 * sepamos en qué orden debemos hacer nuestro viaje y , por tanto, recoger los
 * medios de transporte adecuados en el orden correcto.
 * 
 * @author eduardo
 *
 */
public class StrategyNoStartNoEnd implements TripSorterStrategy {

	/**
	 * Es una tabla con pares (clave-valor) donde la clave es el identificador del lugar de
	 * partida de una tarjeta de embarque, y el valor es el objeto que representa
	 * a dicha tarjeta.
	 * Cabe mencionar que cada lugar de tipo Place tiene un identificador único
	 * Ver método {@link #buildDeparturesDestinationsTables(List)} para comprender su
	 * significado.
	 */
	private HashMap<String, BoardingCard> departuresCards = new HashMap<>();
	
	/**
	 * Es una tabla con pares (clave-valor) donde la clave es el identificador del lugar de
	 * partida de una tarjeta de embarque, y su valor es el objeto que representa 
	 * a dicha tarjeta.
	 * Cabe mencionar que cada lugar de tipo Place tiene un identificador único
	 * Ver método {@link #buildDeparturesDestinationsTables(List)} para comprender su
	 * significado.
	 */
	private HashMap<String, BoardingCard> destinationsCards = new HashMap<>();

	/**
	 * A partir de una lista de tarjetas de embarque desordenadas, que
	 * representan un viaje que tenemos que hacer con diferentes paradas, y en
	 * la que no sabemos que tarjeta representa el punto de partida y fin de
	 * nuestro viaje, la estrategia de ordenamiento de este método ordena dichas
	 * tarjetas de modo que sepamos en qu� orden debemos hacer nuestro viaje y,
	 * por tanto, recoger los medios de transporte adecuados en el orden
	 * correcto.
	 * <p>
	 * IMPORTANTE: este método funciona siempre y cuando el viaje acabe en un lugar
	 * diferente al de inicio, es decir, el lugar de origen de la tarjeta de embarque donde
	 * comienza el viaje no puede figurar como origen o destino en otra tarjeta de embarque
	 * <p>
	 * Coste computacional del m�todo: O(n)
	 */
	@Override
	public List<BoardingCard> sortTrip(List<BoardingCard> boardingCards) {
		/*
		 * Primero, hay que averiguar cual es la tarjeta de embarque en la que comienza
		 * el viaje, y partir de ah� sabremos el itinerario ordenado, ya que
		 * cada tarjeta de embarque contiene el lugar de salida y llegada.
		 * 
		 * Ejemplo:
		 * 
		 * Listado de tarjetas desordenado: 
		 * [(id-tarjeta, lugar salida, lugar llegada), ...] 
		 * [(003, C, D), (002, B, C), (001, A, B), (004, D, E)]
		 * 
		 * Id Tarjeta | Lugar salida | Lugar llegada |
		 * ---------------------------------------- 
		 * 		001 		A 				B 			<-- Tarjeta inicial
		 * 		002 		B 				C 
		 * 		003 		C 				D 
		 * 		004 		D 				E 			<-- Tarjeta inicial
		 * 
		 */
		
		// Construimos los diccionarios o tablas necesarias para realizar las operaciones
		// necesarias para este algoritmo de ordenaci�n
		buildDeparturesDestinationsTables(boardingCards);
		
		// Obtenemos la tarjeta de embarque en la que comienza el viaje
		BoardingCard initialBoardingCard = initialBoardingCard();
		
		List<BoardingCard> sortedBoardingCards = sortBoardingCards(initialBoardingCard);

		return sortedBoardingCards;
	}

	/**
	 * Construye cuatro diccionarios o tablas con pares clave-valor para mapear 
	 * tarjetas de embarque y lugares de origen y destino del viaje.
	 * 
	 * <ul>
	 * <li>
	 * departuresCards: mapeo entre identificador del lugar de origen y la tarjeta de embarque
	 * que tiene como lugar de origen el correspondiente con dicho identificador. 
	 * Ver el atributo de esta clase {@link #departuresCards}
	 * </li>
	 * <li>
	 * destinationsCards: mapeo entre identificador del lugar de destino y la tarjeta de embarque
	 * que tiene como lugar de destino el correspondiente con dicho identificador. 
	 * Ver el atributo de esta clase {@link #destinationsCards}
	 * </li>
	 * </ul>
	 * <p>
	 * Coste computacional de método: O(n)
	 * @param boardingCards Listado de tarjetas de embarque
	 */
	public void buildDeparturesDestinationsTables(List<BoardingCard> boardingCards) {
		for (BoardingCard bcard : boardingCards) {
			departuresCards.put(bcard.getDeparture().getIdentifier(), bcard);
			destinationsCards.put(bcard.getDestination().getIdentifier(), bcard);
		}
	}
	
	/**
	 * Permite obtener la tarjeta de embarque en la que comienza el viaje.
	 * El lugar de origen del viaje no puede ser el lugar del final del viaje.
	 * <p>
	 * Coste computacional de método: O(n)
	 * @return La tarjeta de embarque en la que comienza el viaje, null en caso de
	 * que no se pueda averiguar donde comienza el viaje ya que no se disponen de
	 * todas las tarjetas de embarque necesarias para completar el viaje desde principio a fin.
	 */
	private BoardingCard initialBoardingCard() {
		/*
		 * Para averiguar la tarjeta de embarque correspondiente al inicio del viaje, me baso
		 * en que el lugar de partida no puede aparecer como lugar de destino en ninguna
		 * tarjeta de embarque, teniendo en cuenta que el lugar de origen del viaje no puede
		 * ser el lugar del final del viaje
		 */
		for (Entry<String, BoardingCard> departure : departuresCards.entrySet()) {
			if (!destinationsCards.containsKey(departure.getKey())) {
				return departuresCards.get(departure.getKey());
			}
		}
		return null;
	}
	
	/**
	 * Permite obtener un listado de tarjetas de embarque ordenadas por su orden durante
	 * un viaje, partiendo de una tarjeta de embarque que se usa en el punto de partida
	 * del viaje.
	 * <p>
	 * Coste computacional de método: O(n)
	 * @param initialBoardingCard La tarjeta de embarque usada en el punto de partida del viaje
	 * @return Lista con las tarjetas de embarque ordenadas según las paradas del viaje
	 */
	private List<BoardingCard> sortBoardingCards(BoardingCard initialBoardingCard) {
		/*
		 * Lista en la que se van añadiendo las tarjetas de embarque por orden desde el inicio
		 * hasta el final del viaje
		 */
		List<BoardingCard> sortedBoardingCards = new ArrayList<>();
		
		/*
		 * Recibimos como parámetro de este método la tarjeta usada en el comienzo del viaje
		 * (ya la obtuvimos en el método initialBoardingCard), así que la añadimos en el
		 * primer lugar de la lista de tarjetas ordendas
		 */
		sortedBoardingCards.add(initialBoardingCard);
		
		/*
		 * Al tener la tarjeta de embarque usada en el punto de partida del viaje, ya sabemos
		 * cual es el siguiente destino del viaje ya que es un dato contenido en la propia tarjeta
		 */
		String idNextDestination = initialBoardingCard.getDestination().getIdentifier();
		/*
		 * Como a partir de una tarjeta sabemos el próximo destino del viaje, podemos
		 * buscar que tarjeta tiene como lugar de origen o partida el destino de la tarjeta
		 * anterior, usando la tabla departuresCards donde tenemos un mapeo del identificador
		 * del lugar de origen correspondiente a cada tarjeta.
		 * El destino de una tarjeta usada en un paso previo del viaje, será el lugar de origen
		 * de la tarjeta usada en el pr�ximo paso del viaje.
		 */
		while (departuresCards.containsKey(idNextDestination)) {
			sortedBoardingCards.add(departuresCards.get(idNextDestination));
			idNextDestination = departuresCards.get(idNextDestination).getDestination().getIdentifier();
		}
		return sortedBoardingCards;
	}
}
