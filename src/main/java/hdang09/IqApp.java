package hdang09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IqApp {

    public static void main(String[] args) {
        SpringApplication.run(IqApp.class, args);
    }

//    @Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2).select()
//                .apis(RequestHandlerSelectors.basePackage("hdang09")).build();
//    }
    
//    @Bean
//	public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/").allowedOrigins("https://iq-api.up.railway.app");
//            }
//        };
//    }
}
