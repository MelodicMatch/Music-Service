package univ_rouen.fr.Music_Service.service;

import univ_rouen.fr.Music_Service.entity.PlaylistMusic;

import java.util.List;
import java.util.Optional;

public interface PlaylistMusicService {
    List<PlaylistMusic> getAllPlaylistMusics();
    Optional<PlaylistMusic> getPlaylistMusicById(String id);
    PlaylistMusic createPlaylistMusic(PlaylistMusic playlistMusic);
    void deletePlaylistMusic(String id);
}
