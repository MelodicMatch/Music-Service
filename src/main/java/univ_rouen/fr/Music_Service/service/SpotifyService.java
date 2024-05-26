package univ_rouen.fr.Music_Service.service;

import java.util.Map;

public interface SpotifyService {
    Map<String, Object> searchTracks(String query);
}
