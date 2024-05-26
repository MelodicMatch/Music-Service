package univ_rouen.fr.Music_Service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import univ_rouen.fr.Music_Service.entity.PlaylistMusic;
import univ_rouen.fr.Music_Service.repository.PlaylistMusicRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistMusicServiceImpl implements PlaylistMusicService {

    private final PlaylistMusicRepository playlistMusicRepository;

    @Autowired
    public PlaylistMusicServiceImpl(PlaylistMusicRepository playlistMusicRepository) {
        this.playlistMusicRepository = playlistMusicRepository;
    }

    @Override
    public List<PlaylistMusic> getAllPlaylistMusics() {
        return playlistMusicRepository.findAll();
    }

    @Override
    public Optional<PlaylistMusic> getPlaylistMusicById(String id) {
        return playlistMusicRepository.findById(id);
    }

    @Override
    public PlaylistMusic createPlaylistMusic(PlaylistMusic playlistMusic) {
        return playlistMusicRepository.save(playlistMusic);
    }

    @Override
    public void deletePlaylistMusic(String id) {
        playlistMusicRepository.deleteById(id);
    }
}
