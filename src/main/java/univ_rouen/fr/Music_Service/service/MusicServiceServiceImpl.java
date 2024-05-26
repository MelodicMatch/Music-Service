package univ_rouen.fr.Music_Service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import univ_rouen.fr.Music_Service.entity.MusicService;
import univ_rouen.fr.Music_Service.repository.MusicServiceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MusicServiceServiceImpl implements MusicServiceService {

    private final MusicServiceRepository musicServiceRepository;

    @Autowired
    public MusicServiceServiceImpl(MusicServiceRepository musicServiceRepository) {
        this.musicServiceRepository = musicServiceRepository;
    }

    @Override
    public List<MusicService> getAllMusicServices() {
        return musicServiceRepository.findAll();
    }

    @Override
    public Optional<MusicService> getMusicServiceById(String id) {
        return musicServiceRepository.findById(id);
    }

    @Override
    public MusicService createMusicService(MusicService musicService) {
        return musicServiceRepository.save(musicService);
    }

    @Override
    public void deleteMusicService(String id) {
        musicServiceRepository.deleteById(id);
    }
}
