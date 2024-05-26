package univ_rouen.fr.Music_Service.service;


import univ_rouen.fr.Music_Service.entity.Playlist;

import java.util.List;
import java.util.Optional;

public interface PlaylistService {
    List<Playlist> getAllPlaylists();
    Optional<Playlist> getPlaylistById(String id);
    Playlist createPlaylist(Playlist playlist);
    void deletePlaylist(String id);
}