package rockpaperscissorsws.rest.messages;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rockpaperscissorsws.domain.ThrowSelection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "The input object representing both the user and house selected play values.")
public class SelectedPlaysMessage {

	@ApiModelProperty(value = "The selected play value of the human player.", required = true)
	private ThrowSelection humanPlayerChoice;

	@ApiModelProperty(value = "The selected play value of the house player.", required = true)
	private ThrowSelection houseChoice;
}