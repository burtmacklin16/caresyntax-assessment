package rockpaperscissorsws.rest.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rockpaperscissorsws.domain.PlaySelection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SelectedPlaysMessage {

	private PlaySelection humanPlayerChoice;
	private PlaySelection houseChoice;
}