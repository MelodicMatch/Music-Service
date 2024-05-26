package univ_rouen.fr.Music_Service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import univ_rouen.fr.Music_Service.entity.Music;
import univ_rouen.fr.Music_Service.repository.MusicRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MusicManagementServiceImpl implements MusicManagementService {

    private final MusicRepository musicRepository;

    @Autowired
    public MusicManagementServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public List<Music> getAllMusics() {
        return musicRepository.findAll();
    }

    @Override
    public Optional<Music> getMusicById(String id) {
        return musicRepository.findById(id);
    }

    @Override
    public Music createMusic(Music music) {
        return musicRepository.save(music);
    }

    @Override
    public void deleteMusic(String id) {
        musicRepository.deleteById(id);
    }
}
