package rockpaperscissorsws.rest.messages;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rockpaperscissorsws.domain.RoundStatus;
import rockpaperscissorsws.domain.ThrowSelection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "The message that provides the information about an executed round of play.")
public class RoundResultMessage {

	@ApiModelProperty(value = "The enumeration representing the outcome of the round from the human player's standpoint.")
	private RoundStatus resultOfRound;;

	@ApiModelProperty(value = "The selected play value of the human player.")
	private ThrowSelection humanPlayerChoice;

	@ApiModelProperty(value = "The selected play value of the house player.")
	private ThrowSelection houseChoice;
	
	@ApiModelProperty(value = "The current score value for the human player.")
	private int currentScore;
}