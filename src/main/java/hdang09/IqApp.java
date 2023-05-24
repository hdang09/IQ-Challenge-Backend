package hdang09;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "IQ Challenge API",
                version = "1.0.0",
                description = "An API for IQ Challenge minigame of F-Code Club for the orientation to welcome K18 of FPT University HCM."
        )
)
public class IqApp {

    public static void main(String[] args) {
        SpringApplication.run(IqApp.class, args);
    }

}
