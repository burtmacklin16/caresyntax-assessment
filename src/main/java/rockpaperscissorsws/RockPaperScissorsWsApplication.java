package rockpaperscissorsws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import rockpaperscissorsws.rest.controllers.ControllerComponentScanTarget;
import rockpaperscissorsws.service.ServiceComponentScanTarget;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(
	scanBasePackageClasses = {
		ControllerComponentScanTarget.class,
		ServiceComponentScanTarget.class
	}
)
@EnableSwagger2
public class RockPaperScissorsWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RockPaperScissorsWsApplication.class, args);
	}

	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
}