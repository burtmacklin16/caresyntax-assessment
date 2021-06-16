package rockpaperscissorsws.service.strategies;

import java.util.EnumSet;
import java.util.Random;

import org.springframework.stereotype.Component;

import rockpaperscissorsws.domain.Difficulty;
import rockpaperscissorsws.domain.ThrowSelection;

@Component
public class RandomHouseStrategy implements IHouseThrowsStrategy {

	/**
	* @see rockpaperscissorsws.service.strategies.IHouseThrowsStrategy#generateThrow()
	*/
	@Override
	public ThrowSelection generateThrow() {
		
		final Random random = new Random();
		
		return EnumSet.allOf(ThrowSelection.class)
				      .stream()
				      .skip(random.nextInt(EnumSet.allOf(ThrowSelection.class).size()))
				      .findFirst()
				      .orElse(ThrowSelection.ROCK);
	}

	/**
	* @see rockpaperscissorsws.service.strategies.IHouseThrowsStrategy#resolvesProvidedDifficulty(rockpaperscissorsws.domain.Difficulty)
	*/
	@Override
	public boolean resolvesProvidedDifficulty(final Difficulty houseDifficulty) {
		return houseDifficulty == Difficulty.HARD;
	}
}