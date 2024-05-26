package univ_rouen.fr.Music_Service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void sendMessage(String id, String name) {
        try {
            GenreMessage genreMessage = new GenreMessage(id, name);
            String message = objectMapper.writeValueAsString(genreMessage);
            kafkaTemplate.send("user-profiles", message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class GenreMessage {
        public String id;
        public String name;

        public GenreMessage(String id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
