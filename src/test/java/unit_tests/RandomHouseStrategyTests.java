package unit_tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import rockpaperscissorsws.domain.Difficulty;
import rockpaperscissorsws.service.strategies.RandomHouseStrategy;

@ExtendWith(MockitoExtension.class)
public class RandomHouseStrategyTests {

	private RandomHouseStrategy classUnderTest = new RandomHouseStrategy();
	
	@Test
	public void confirmDifficultyResolution() {
		assertTrue(classUnderTest.resolvesProvidedDifficulty(Difficulty.HARD));
	}

	@Test
	public void confirmNonNullThrowIsGenerated() {
		assertNotNull(classUnderTest.generateThrow());
	}
}