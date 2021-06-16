package rockpaperscissorsws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import rockpaperscissorsws.rest.controllers.ControllerComponentScanTarget;

@SpringBootApplication(
	scanBasePackageClasses = ControllerComponentScanTarget.class
)
public class RockPaperScissorsWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RockPaperScissorsWsApplication.class, args);
	}
}