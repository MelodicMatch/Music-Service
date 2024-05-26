package univ_rouen.fr.Music_Service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import univ_rouen.fr.Music_Service.entity.PlaylistSubscriber;
import univ_rouen.fr.Music_Service.repository.PlaylistSubscriberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistSubscriberServiceImpl implements PlaylistSubscriberService {

    private final PlaylistSubscriberRepository playlistSubscriberRepository;

    @Autowired
    public PlaylistSubscriberServiceImpl(PlaylistSubscriberRepository playlistSubscriberRepository) {
        this.playlistSubscriberRepository = playlistSubscriberRepository;
    }

    @Override
    public List<PlaylistSubscriber> getAllPlaylistSubscribers() {
        return playlistSubscriberRepository.findAll();
    }

    @Override
    public Optional<PlaylistSubscriber> getPlaylistSubscriberById(String id) {
        return playlistSubscriberRepository.findById(id);
    }

    @Override
    public PlaylistSubscriber createPlaylistSubscriber(PlaylistSubscriber playlistSubscriber) {
        return playlistSubscriberRepository.save(playlistSubscriber);
    }

    @Override
    public void deletePlaylistSubscriber(String id) {
        playlistSubscriberRepository.deleteById(id);
    }
}
