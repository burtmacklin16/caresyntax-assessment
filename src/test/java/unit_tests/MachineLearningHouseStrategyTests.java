package unit_tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import rockpaperscissorsws.domain.Difficulty;
import rockpaperscissorsws.service.strategies.MachineLearningHouseStrategy;

@ExtendWith(MockitoExtension.class)
public class MachineLearningHouseStrategyTests {

	private MachineLearningHouseStrategy classUnderTest = new MachineLearningHouseStrategy();
	
	@Test
	public void confirmDifficultyResolution() {
		assertTrue(classUnderTest.resolvesProvidedDifficulty(Difficulty.INSANE));
	}

	@Test
	public void confirmNonNullThrowIsGenerated() {
		assertNotNull(classUnderTest.generateThrow());
	}
}