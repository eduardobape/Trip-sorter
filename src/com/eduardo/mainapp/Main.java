package com.eduardo.mainapp;

import java.util.Arrays;
import java.util.List;

import com.eduardo.boardingcards.AeroplaneBoardingCard;
import com.eduardo.boardingcards.AeroplaneBoardingCardFactory;
import com.eduardo.boardingcards.BoardingCard;
import com.eduardo.boardingcards.BusBoardingCard;
import com.eduardo.boardingcards.BusBoardingCardFactory;
import com.eduardo.boardingcards.BoardingCardFactory;
import com.eduardo.boardingcards.StrategyNoStartNoEnd;
import com.eduardo.boardingcards.TrainBoardingCard;
import com.eduardo.boardingcards.TrainBoardingCardFactory;
import com.eduardo.boardingcards.Trip;
import com.eduardo.location.Place;
import com.eduardo.transport.Train;

public class Main {

	public static void main(String[] args) {
		
		// Vamos a fabricar 4 tarjetas de embarque usando el patrón Factory para crear factorías diferentes
		// según el tipo de tarjeta de embarque que deseemos crear
		BoardingCardFactory aeroplaneBoardingCardFactory = new AeroplaneBoardingCardFactory();
		BoardingCardFactory trainBoardingCardFactory = new TrainBoardingCardFactory();
		BoardingCardFactory busBoardingCardFactory = new BusBoardingCardFactory();
		
		List<BoardingCard> unorderedBoardingCards = Arrays.asList(
				aeroplaneBoardingCardFactory.createBoardingCard(),
				trainBoardingCardFactory.createBoardingCard(),
				aeroplaneBoardingCardFactory.createBoardingCard(),
				busBoardingCardFactory.createBoardingCard()
				);
		
		AeroplaneBoardingCard bcard1 = (AeroplaneBoardingCard)unorderedBoardingCards.get(0);
		bcard1
			.setFlightNumber("SK22")
			.setGate("22")
			.setBaggageTicketCounter(null)
			.setIdentifier("004")
			.setSeat("7B")
			.setDeparture(new Place("stockolm-sweeden", "Stockolm", "Sweeden"))
			.setDestination(new Place("ny-usa", "New York", "USA"));
		
		TrainBoardingCard bcard2 = (TrainBoardingCard)unorderedBoardingCards.get(1);
		bcard2
			.setIdentifier("001")
			.setTransport(new Train("78A"))
			.setSeat("45B")
			.setDeparture(new Place("madrid-spain", "Madrid", "Spain"))
			.setDestination(new Place("barcelona-spain", "Barcelona", "Spain"));
		
		AeroplaneBoardingCard bcard3 = (AeroplaneBoardingCard)unorderedBoardingCards.get(2);
		bcard3
			.setFlightNumber("SK455")
			.setGate("45B")
			.setBaggageTicketCounter("344")
			.setIdentifier("003")
			.setSeat("3A")
			.setDeparture(new Place("geronaairport-spain", "Gerona", "Spain"))
			.setDestination(new Place("stockolm-sweeden", "Stockolm", "Sweeden"));
		
		BusBoardingCard bcard4 = (BusBoardingCard)unorderedBoardingCards.get(3);
		bcard4
			.setIdentifier("002")
			.setSeat(null)
			.setDeparture(new Place("barcelona-spain", "Barcelona", "Spain"))
			.setDestination(new Place("geronaairport-spain", "Gerona", "Spain"));
		
		// Establecemos la estrategia de ordenamiento siguiendo el patrón Strategy
		Trip trip = new Trip(unorderedBoardingCards);
		trip.setOrderingTravelStrategy(new StrategyNoStartNoEnd());
		
		// Ordenamos las tarjetas de viaje
		trip.sortTrip(unorderedBoardingCards);
		
		// Mostramos la información del viaje
		System.out.println(trip.showInfoTravel());
	}

}
