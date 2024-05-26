package univ_rouen.fr.Music_Service.service;


import univ_rouen.fr.Music_Service.entity.PlaylistSubscriber;

import java.util.List;
import java.util.Optional;

public interface PlaylistSubscriberService {
    List<PlaylistSubscriber> getAllPlaylistSubscribers();
    Optional<PlaylistSubscriber> getPlaylistSubscriberById(String id);
    PlaylistSubscriber createPlaylistSubscriber(PlaylistSubscriber playlistSubscriber);
    void deletePlaylistSubscriber(String id);
}
