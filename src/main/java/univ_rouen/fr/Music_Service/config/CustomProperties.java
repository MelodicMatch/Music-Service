package univ_rouen.fr.Music_Service.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
public class CustomProperties {

    @Value("${custom.resource-path}")
    private String resourcePath;

}
