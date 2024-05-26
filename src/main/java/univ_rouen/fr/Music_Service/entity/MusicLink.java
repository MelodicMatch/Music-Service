package univ_rouen.fr.Music_Service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "musicLinks")
public class MusicLink {
    @Id
    private String id;
    @DBRef
    private Music music;
    @DBRef
    private MusicService musicService;
    private String link;
}