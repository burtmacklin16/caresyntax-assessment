package rockpaperscissorsws.service;

import rockpaperscissorsws.domain.PlaySelection;

public interface IHouseThrowsGenerator {

	/**
	 * Returns a {@link PlaySelection} enumeration value representing
	 * a house throw value
	 * 
	 * @return
	 * 		A throw representing a value generated from the house
	 */
	PlaySelection generateThrow();
}