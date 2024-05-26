package univ_rouen.fr.Music_Service.service;

import univ_rouen.fr.Music_Service.entity.SubGenre;

import java.util.List;
import java.util.Optional;

public interface SubGenreService {
    List<SubGenre> getAllSubGenres();
    Optional<SubGenre> getSubGenreById(String id);
    SubGenre createSubGenre(SubGenre subGenre);
    void deleteSubGenre(String id);
}