package univ_rouen.fr.Music_Service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "playlistMusics")
public class PlaylistMusic {
    @Id
    private String id;
    @DBRef
    private Playlist playlist;
    @DBRef
    private Music music;
}