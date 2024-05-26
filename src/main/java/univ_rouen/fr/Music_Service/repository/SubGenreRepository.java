package univ_rouen.fr.Music_Service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import univ_rouen.fr.Music_Service.entity.SubGenre;

@Repository
public interface SubGenreRepository extends MongoRepository<SubGenre, String> {}
