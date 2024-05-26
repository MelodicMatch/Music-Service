package univ_rouen.fr.Music_Service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaServiceImpl implements KafkaService {

    private static final String TOPIC = "user-music";
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
        log.info("Sent message kafka: {}", message);
    }

    @Override
    @KafkaListener(topics = TOPIC, groupId = "music-group")
    public void consumeMessage(String message) {
        log.info("Consumed message kafka: {}", message);
    }
}
