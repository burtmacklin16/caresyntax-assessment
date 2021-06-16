package unit_tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import rockpaperscissorsws.domain.Difficulty;
import rockpaperscissorsws.service.strategies.ShadowUserHouseStrategy;

@ExtendWith(MockitoExtension.class)
public class ShadowUserHouseStrategyTests {

	private ShadowUserHouseStrategy classUnderTest = new ShadowUserHouseStrategy();
	
	@Test
	public void confirmDifficultyResolution() {
		assertTrue(classUnderTest.resolvesProvidedDifficulty(Difficulty.MEDIUM));
	}

	@Test
	public void confirmNonNullThrowIsGenerated() {
		assertNotNull(classUnderTest.generateThrow());
	}
}