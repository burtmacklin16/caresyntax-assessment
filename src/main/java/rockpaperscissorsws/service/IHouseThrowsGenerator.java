package rockpaperscissorsws.service;

import rockpaperscissorsws.domain.Difficulty;
import rockpaperscissorsws.domain.ThrowSelection;

public interface IHouseThrowsGenerator {

	/**
	 * Returns a {@link ThrowSelection} enumeration value representing
	 * a house throw value
	 * 
	 * @return
	 * 		A throw representing a value generated from the house
	 */
	ThrowSelection generateThrow();

	/**
	 * Returns a {@link ThrowSelection} enumeration value representing
	 * a house throw value based on the difficulty selected
	 * 
	 * @param houseDifficulty
	 * 		The level of sophistication used when determining which throw to use
	 * @return
	 * 		A throw representing a value generated from the house
	 */
	ThrowSelection generateThrow(Difficulty houseDifficulty);
}