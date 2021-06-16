package rockpaperscissorsws.service.strategies;

import org.springframework.stereotype.Component;

import rockpaperscissorsws.domain.Difficulty;
import rockpaperscissorsws.domain.ThrowSelection;

@Component
public class ShadowUserHouseStrategy implements IHouseThrowsStrategy {

	/**
	* @see rockpaperscissorsws.service.strategies.IHouseThrowsStrategy#generateThrow()
	*/
	@Override
	public ThrowSelection generateThrow() {
		return getUsersLastThrow();
	}

	/**
	* @see rockpaperscissorsws.service.strategies.IHouseThrowsStrategy#resolvesProvidedDifficulty(rockpaperscissorsws.domain.Difficulty)
	*/
	@Override
	public boolean resolvesProvidedDifficulty(final Difficulty houseDifficulty) {
		return houseDifficulty == Difficulty.MEDIUM;
	}

	/**
	 * Invokes the player repository in order to determine what the user's last throw was
	 * 
	 * @return
	 * 		The last selected throw from the user
	 */
	private ThrowSelection getUsersLastThrow() {
		// TODO V2.0 feature - Implement Player repo to get their last throw. For
		//                     now, return ROCK
		return ThrowSelection.ROCK;
	}
}