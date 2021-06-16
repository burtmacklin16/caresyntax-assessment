package rockpaperscissorsws.service.strategies;

import org.springframework.stereotype.Component;

import rockpaperscissorsws.domain.Difficulty;
import rockpaperscissorsws.domain.ThrowSelection;

@Component
public class EasyToBeatHouseStrategy implements IHouseThrowsStrategy {

	/**
	* @see rockpaperscissorsws.service.strategies.IHouseThrowsStrategy#generateThrow()
	*/
	@Override
	public ThrowSelection generateThrow() {
		return ThrowSelection.ROCK;
	}

	/**
	* @see rockpaperscissorsws.service.strategies.IHouseThrowsStrategy#resolvesProvidedDifficulty(rockpaperscissorsws.domain.Difficulty)
	*/
	@Override
	public boolean resolvesProvidedDifficulty(final Difficulty houseDifficulty) {
		return houseDifficulty == Difficulty.EASY;
	}
}