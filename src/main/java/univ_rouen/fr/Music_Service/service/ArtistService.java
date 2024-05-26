package univ_rouen.fr.Music_Service.service;


import univ_rouen.fr.Music_Service.entity.Artist;

import java.util.List;
import java.util.Optional;

public interface ArtistService {
    List<Artist> getAllArtists();
    Optional<Artist> getArtistById(String id);
    Artist createArtist(Artist artist);
    void deleteArtist(String id);
}