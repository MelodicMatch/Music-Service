package univ_rouen.fr.Music_Service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import univ_rouen.fr.Music_Service.entity.MusicLink;
import univ_rouen.fr.Music_Service.repository.MusicLinkRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MusicLinkServiceImpl implements MusicLinkService {

    private final MusicLinkRepository musicLinkRepository;

    @Autowired
    public MusicLinkServiceImpl(MusicLinkRepository musicLinkRepository) {
        this.musicLinkRepository = musicLinkRepository;
    }

    @Override
    public List<MusicLink> getAllMusicLinks() {
        return musicLinkRepository.findAll();
    }

    @Override
    public Optional<MusicLink> getMusicLinkById(String id) {
        return musicLinkRepository.findById(id);
    }

    @Override
    public MusicLink createMusicLink(MusicLink musicLink) {
        return musicLinkRepository.save(musicLink);
    }

    @Override
    public void deleteMusicLink(String id) {
        musicLinkRepository.deleteById(id);
    }
}
