package rockpaperscissorsws.service.strategies;

import rockpaperscissorsws.domain.Difficulty;
import rockpaperscissorsws.domain.ThrowSelection;

public interface IHouseThrowsStrategy {
	
	/**
	 * Generates a throw based on some underlying logic
	 * 
	 * @return
	 * 		A {@link ThrowSelection} representing the house's throw
	 */
	ThrowSelection generateThrow();
	
	/**
	 * Determines if the current strategy can satisfy the desired
	 * house difficulty rating
	 * 
	 * @param houseDifficulty
	 * 		The level of sophistication used when determining what the
	 * 		house's next throw should be
	 * @return
	 * 		Whether or not this strategy should be used for the provided difficulty level
	 */
	boolean resolvesProvidedDifficulty(Difficulty houseDifficulty);
}