/**
 * 
 */
package rockpaperscissorsws.service;

import java.util.Collection;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import rockpaperscissorsws.domain.Difficulty;
import rockpaperscissorsws.domain.ThrowSelection;
import rockpaperscissorsws.service.strategies.IHouseThrowsStrategy;

@Component
@RequiredArgsConstructor
@Slf4j
public class HouseThrowsGenerator implements IHouseThrowsGenerator {
	
	private final Collection<IHouseThrowsStrategy> strategies;

	/**
	* @see rockpaperscissorsws.service.IHouseThrowsGenerator#generateThrow()
	*/
	@Override
	public ThrowSelection generateThrow() {
		return generateThrow(Difficulty.EASY);
	}

	/**
	* @see rockpaperscissorsws.service.IHouseThrowsGenerator#generateThrow(rockpaperscissorsws.domain.Difficulty)
	*/
	@Override
	public ThrowSelection generateThrow(final Difficulty houseDifficulty) {
		
		log.info("Returning a PlaySelection value based on the difficulty {}", houseDifficulty.name());
		
		final IHouseThrowsStrategy throwsStrategy = resolveStrategyForDifficulty(houseDifficulty);
		
		return throwsStrategy.generateThrow();
	}

	/**
	 * 
	 * 
	 * @param houseDifficulty
	 * @return
	 */
	private IHouseThrowsStrategy resolveStrategyForDifficulty(final Difficulty houseDifficulty) {
		
		return strategies.stream()
				.filter(s -> s.resolvesProvidedDifficulty(houseDifficulty))
				.findFirst()
				.orElse(new IHouseThrowsStrategy() {
					
					@Override
					public boolean resolvesProvidedDifficulty(final Difficulty houseDifficulty) {
						return true;
					}
					
					@Override
					public ThrowSelection generateThrow() {
						return ThrowSelection.ROCK;
					}
				});
	}
}