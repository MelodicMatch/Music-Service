package univ_rouen.fr.Music_Service.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig {

    private static final Logger logger = LoggerFactory.getLogger(MongoConfig.class);

    // Optionnel: Utilisez cette méthode pour loguer l'URI MongoDB si nécessaire
    // Vous pouvez utiliser @Value pour injecter l'URI de l'application.yml si besoin
    public MongoConfig() {
        String mongoUri = "mongodb://localhost:27017/MusicDB"; // Changer selon votre configuration
        logger.info("MongoDB URI: {}", mongoUri);
    }

    // Configuration du bean MongoTemplate
    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(MongoClients.create("mongodb://localhost:27017"), "MusicDB");
    }
}

