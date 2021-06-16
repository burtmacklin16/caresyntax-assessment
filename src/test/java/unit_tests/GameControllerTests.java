package unit_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import rockpaperscissorsws.domain.Difficulty;
import rockpaperscissorsws.domain.RoundStatus;
import rockpaperscissorsws.domain.ThrowSelection;
import rockpaperscissorsws.domain.commands.PlayRoundCommand;
import rockpaperscissorsws.domain.values.RoundResult;
import rockpaperscissorsws.rest.controllers.GameController;
import rockpaperscissorsws.rest.messages.RoundResultMessage;
import rockpaperscissorsws.rest.messages.SelectedPlaysMessage;
import rockpaperscissorsws.service.IGameplayService;
import rockpaperscissorsws.service.IHouseThrowsGenerator;

@ExtendWith(MockitoExtension.class)
public class GameControllerTests {

	@Mock
	private IHouseThrowsGenerator houseThrowsGenerator;
	
	@Mock
	private IGameplayService mockGameplayService;
	
	@InjectMocks
	private GameController classUnderTest;
	
	@Test
	public void confirmHouseThrowIsGenerated() {
		
		Mockito.when(houseThrowsGenerator.generateThrow())
		       .thenReturn(ThrowSelection.ROCK);
		
		final ResponseEntity<ThrowSelection> houseThrowResponse = classUnderTest.getHouseThrow(null);
		
		Mockito.verify(houseThrowsGenerator, Mockito.times(1)).generateThrow();
		
		// verify the response and body
		assertNotNull(houseThrowResponse);
		
		assertEquals(HttpStatus.OK, houseThrowResponse.getStatusCode());
		
		final ThrowSelection responseMessageBody = houseThrowResponse.getBody();

		assertNotNull(responseMessageBody);

		assertEquals(ThrowSelection.ROCK, responseMessageBody);
	}

	@Test
	public void confirmHouseThrowIsGeneratedWhenDifficultyIsSpecified() {
		
		Mockito.when(houseThrowsGenerator.generateThrow(Mockito.nullable(Difficulty.class)))
		       .thenReturn(ThrowSelection.ROCK);
		
		final ResponseEntity<ThrowSelection> houseThrowResponse = classUnderTest.getHouseThrow(Difficulty.HARD);
		
		Mockito.verify(houseThrowsGenerator, Mockito.times(1)).generateThrow(Mockito.nullable(Difficulty.class));
		
		// verify the response and body
		assertNotNull(houseThrowResponse);
		
		assertEquals(HttpStatus.OK, houseThrowResponse.getStatusCode());
		
		final ThrowSelection responseMessageBody = houseThrowResponse.getBody();

		assertNotNull(responseMessageBody);

		assertEquals(ThrowSelection.ROCK, responseMessageBody);
	}

	@Test
	public void confirmOkHttpStatusWithBodyReturned() {
		
		Mockito.when(mockGameplayService.playRound(Mockito.nullable(PlayRoundCommand.class)))
		       .thenReturn(RoundResult.builder()
		    		   			      .currentScore(10)
		    		   			      .houseChoice(ThrowSelection.PAPER)
		    		   			      .humanPlayerChoice(ThrowSelection.ROCK)
		    		   			      .resultOfRound(RoundStatus.WIN)
		    		                  .build());
		
		final ResponseEntity<RoundResultMessage> playResultResponse = classUnderTest.playRound(createWinningRestInputMessage());
		
		final ArgumentCaptor<PlayRoundCommand> commandCaptor = ArgumentCaptor.forClass(PlayRoundCommand.class);
		
		// verify transformation of the PlayRound command
		Mockito.verify(mockGameplayService, Mockito.times(1)).playRound(commandCaptor.capture());
		
		final PlayRoundCommand transformedCommand = commandCaptor.getValue();
		
		assertEquals(ThrowSelection.PAPER, transformedCommand.getHouseChoice());
		assertEquals(ThrowSelection.ROCK, transformedCommand.getHumanPlayerChoice());
		
		// verify the response and body transformation
		assertNotNull(playResultResponse);
		
		assertEquals(HttpStatus.OK, playResultResponse.getStatusCode());
		
		final RoundResultMessage responseMessageBody = playResultResponse.getBody();

		assertNotNull(responseMessageBody);

		assertEquals(ThrowSelection.PAPER, responseMessageBody.getHouseChoice());
		assertEquals(ThrowSelection.ROCK, responseMessageBody.getHumanPlayerChoice());
		assertEquals(10, responseMessageBody.getCurrentScore());
		assertEquals(RoundStatus.WIN, responseMessageBody.getResultOfRound());
	}
	
	/**
	 * Creates an input message with a human winning play combination
	 * 
	 * @return
	 * 		The SelectedPlaysMessage object representing a human winning round
	 */
	private SelectedPlaysMessage createWinningRestInputMessage() {
		
		final SelectedPlaysMessage inputMessage = new SelectedPlaysMessage();
				
		inputMessage.setHouseChoice(ThrowSelection.PAPER);
		inputMessage.setHumanPlayerChoice(ThrowSelection.ROCK);
		
		return inputMessage;
	}
}