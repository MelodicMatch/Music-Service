package univ_rouen.fr.Music_Service.service;

import univ_rouen.fr.Music_Service.entity.Music;

import java.util.List;
import java.util.Optional;

public interface MusicManagementService {
    List<Music> getAllMusics();
    Optional<Music> getMusicById(String id);
    Music createMusic(Music music);
    void deleteMusic(String id);
}