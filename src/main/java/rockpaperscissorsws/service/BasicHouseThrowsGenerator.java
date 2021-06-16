/**
 * 
 */
package rockpaperscissorsws.service;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import rockpaperscissorsws.domain.PlaySelection;

@Component
@Slf4j
public class BasicHouseThrowsGenerator implements IHouseThrowsGenerator {

	/**
	* @see rockpaperscissorsws.service.IHouseThrowsGenerator#generateThrow()
	*/
	@Override
	public PlaySelection generateThrow() {
		
		log.info("Returning an easy to beat PlaySelection value");
		
		return PlaySelection.SCISSORS;
	}
}