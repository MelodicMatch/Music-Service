package univ_rouen.fr.Music_Service.service;

import univ_rouen.fr.Music_Service.entity.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    List<Genre> getAllGenres();
    Optional<Genre> getGenreById(String id);
    Genre createGenre(Genre genre);
    void deleteGenre(String id);
}