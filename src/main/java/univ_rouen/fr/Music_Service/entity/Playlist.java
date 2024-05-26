package univ_rouen.fr.Music_Service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "playlists")
public class Playlist {
    @Id
    private String playlistID;
    private String userID;
    private String name;
    private String desc;
}