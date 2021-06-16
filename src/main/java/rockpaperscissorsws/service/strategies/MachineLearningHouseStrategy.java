package rockpaperscissorsws.service.strategies;

import org.springframework.stereotype.Component;

import rockpaperscissorsws.domain.Difficulty;
import rockpaperscissorsws.domain.ThrowSelection;

@Component
public class MachineLearningHouseStrategy implements IHouseThrowsStrategy {

	/**
	* @see rockpaperscissorsws.service.strategies.IHouseThrowsStrategy#generateThrow()
	*/
	@Override
	public ThrowSelection generateThrow() {
		return getTrainedNextThrow();
	}

	/**
	* @see rockpaperscissorsws.service.strategies.IHouseThrowsStrategy#resolvesProvidedDifficulty(rockpaperscissorsws.domain.Difficulty)
	*/
	@Override
	public boolean resolvesProvidedDifficulty(final Difficulty houseDifficulty) {
		return houseDifficulty == Difficulty.INSANE;
	}

	/**
	 * Invokes the player repository in order to determine what the user's last throw was
	 * 
	 * @return
	 * 		The last selected throw from the user
	 */
	private ThrowSelection getTrainedNextThrow() {
		// TODO V3.0 feature - Implement machine learning in order to determine next throw. For
		//                     now, return ROCK
		return ThrowSelection.ROCK;
	}
}