package rockpaperscissorsws;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Sets;

@RestController
public class PlayerController {
	
	@GetMapping("/players")
	public ResponseEntity<Collection<PlayerMessage>> getPlayers() {
		
		
		return ResponseEntity.ok(Sets.newHashSet());
	}
}