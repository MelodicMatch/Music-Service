package univ_rouen.fr.Music_Service.service;


import univ_rouen.fr.Music_Service.entity.MusicService;

import java.util.List;
import java.util.Optional;

public interface MusicServiceService {
    List<MusicService> getAllMusicServices();
    Optional<MusicService> getMusicServiceById(String id);
    MusicService createMusicService(MusicService musicService);
    void deleteMusicService(String id);
}
