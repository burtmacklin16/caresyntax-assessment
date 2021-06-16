package unit_tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.common.collect.Sets;

import rockpaperscissorsws.domain.Difficulty;
import rockpaperscissorsws.domain.ThrowSelection;
import rockpaperscissorsws.service.HouseThrowsFactory;
import rockpaperscissorsws.service.IHouseThrowsFactory;
import rockpaperscissorsws.service.strategies.IHouseThrowsStrategy;

@ExtendWith(MockitoExtension.class)
public class HouseThrowsFactoryTests {
	
	@Mock
	private IHouseThrowsStrategy mockStrategy;

	private IHouseThrowsFactory classUnderTest;
	
	@Test
	public void confirmThrowGeneratedWithNoStrategiesImplemented() {

		classUnderTest = new HouseThrowsFactory(Sets.newHashSet());
		
		final ThrowSelection result = classUnderTest.generateThrow();
		
		assertNotNull(result);
	}

	@Test
	public void confirmThrowGeneratedWhenStrategyIsProvided() {
		
		Mockito.when(mockStrategy.resolvesProvidedDifficulty(Mockito.nullable(Difficulty.class)))
		       .thenReturn(true);

		Mockito.when(mockStrategy.generateThrow())
		       .thenReturn(ThrowSelection.ROCK);

		classUnderTest = new HouseThrowsFactory(Sets.newHashSet(mockStrategy));

		final ThrowSelection result = classUnderTest.generateThrow(Difficulty.INSANE);
		
		assertNotNull(result);
	}
}