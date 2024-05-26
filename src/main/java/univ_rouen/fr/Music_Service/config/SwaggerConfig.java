package univ_rouen.fr.Music_Service.config;



import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi apiProfiles() {
        return GroupedOpenApi.builder()
                .group("Music API")
                .packagesToScan("univ_rouen.fr.Music_Service.controller")
                .pathsToMatch("/profiles/**")
                .build();
    }
}
