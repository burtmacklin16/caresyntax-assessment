package rockpaperscissorsws.service;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import rockpaperscissorsws.domain.commands.PlayRoundCommand;
import rockpaperscissorsws.domain.values.RoundResult;

@Component
@Slf4j
public class GameplayService implements IGameplayService {

	/**
	* @see rockpaperscissorsws.service.IGameplayService#playRound(rockpaperscissorsws.domain.commands.PlayRoundCommand)
	*/
	@Override
	public RoundResult playRound(final PlayRoundCommand playRoundCommand) {
		
		log.info("Attempting to play a round of RPS with inputs {}", playRoundCommand.toString());

		throw new UnsupportedOperationException();
	}
}