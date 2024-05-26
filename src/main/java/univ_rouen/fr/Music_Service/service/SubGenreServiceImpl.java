package univ_rouen.fr.Music_Service.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import univ_rouen.fr.Music_Service.entity.SubGenre;
import univ_rouen.fr.Music_Service.repository.SubGenreRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SubGenreServiceImpl implements SubGenreService {

    private final SubGenreRepository subGenreRepository;



    @Override
    public List<SubGenre> getAllSubGenres() {
        return subGenreRepository.findAll();
    }

    @Override
    public Optional<SubGenre> getSubGenreById(String id) {
        return subGenreRepository.findById(id);
    }

    @Override
    public SubGenre createSubGenre(SubGenre subGenre) {
        return subGenreRepository.save(subGenre);
    }

    @Override
    public void deleteSubGenre(String id) {
        subGenreRepository.deleteById(id);
    }
}
