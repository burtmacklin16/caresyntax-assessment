package rockpaperscissorsws.rest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import rockpaperscissorsws.domain.commands.PlayRoundCommand;
import rockpaperscissorsws.domain.values.RoundResult;
import rockpaperscissorsws.rest.messages.RoundResultMessage;
import rockpaperscissorsws.rest.messages.SelectedPlaysMessage;
import rockpaperscissorsws.service.IGameplayService;

@RestController
@RequiredArgsConstructor
@Slf4j
public final class GameController {
	
	private final IGameplayService gameplayService;
	
	@PostMapping("/plays")
	public ResponseEntity<RoundResultMessage> playRound(final SelectedPlaysMessage playersInput) {
		
		log.debug("Attempting to play a round of RPS with inputs {}", playersInput.toString());

		final RoundResult roundResult = gameplayService.playRound(buildPlayInputCommand(playersInput));
		
		return ResponseEntity.ok(buildRestRoundResponseBody(roundResult));
	}

	/**
	 * Creates a {@link PlayRoundCommand} value object to be send to the gameplay service
	 * 
	 * @param playersInput
	 * 		The REST input message to transform
	 * @return
	 * 		A command object representing the provided REST message input
	 */
	private PlayRoundCommand buildPlayInputCommand(final SelectedPlaysMessage playersInput) {
		return PlayRoundCommand.builder()
							   .houseChoice(playersInput.getHouseChoice())
							   .humanPlayerChoice(playersInput.getHumanPlayerChoice())
							    .build();
	}

	/**
	 * Creates a {@link RoundResultMessage} object with the properly populated fields
	 * based on the {@link RoundResult} input
	 * 
	 * @param roundResult
	 * 		The domain value object to transform
	 * @return
	 * 		A REST message representing the given domain value object
	 */
	private RoundResultMessage buildRestRoundResponseBody(final RoundResult roundResult) {
		return RoundResultMessage.builder()
							     .currentScore(roundResult.getCurrentScore())
							     .houseChoice(roundResult.getHouseChoice())
							     .humanPlayerChoice(roundResult.getHumanPlayerChoice())
							     .resultOfRound(roundResult.getResultOfRound())
							     .build();
	}
}