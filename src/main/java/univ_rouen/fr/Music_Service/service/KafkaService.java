package univ_rouen.fr.Music_Service.service;

public interface KafkaService {
    void sendMessage(String message);
    void consumeMessage(String message);
}
