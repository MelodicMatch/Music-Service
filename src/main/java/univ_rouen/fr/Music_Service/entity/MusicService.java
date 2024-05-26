package univ_rouen.fr.Music_Service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "musicServices")
public class MusicService {
    @Id
    private String musicServiceID;
    private String name;
    private String url;
}