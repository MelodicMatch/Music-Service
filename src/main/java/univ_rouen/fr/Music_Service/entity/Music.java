package univ_rouen.fr.Music_Service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "musics")
public class Music {
    @Id
    private String musicID;
    @DBRef
    private Genre genre;
    @DBRef
    private Artist artist;
    private String title;
}