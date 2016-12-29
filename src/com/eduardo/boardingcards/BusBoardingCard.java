package com.eduardo.boardingcards;

public class BusBoardingCard extends BoardingCard {

	@Override
	public String showInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Take the airport bus from ").append(getDeparture().getCity()).append(" to ")
			.append(getDestination().getCity()).append(".");
		sb = getSeat() == null
				? sb.append("No seat assignment")
				: sb.append("Seat ").append(getSeat());
		sb.append("\n");
		return sb.toString();
	}

}
