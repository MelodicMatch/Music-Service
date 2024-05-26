package univ_rouen.fr.Music_Service.service;

import univ_rouen.fr.Music_Service.entity.MusicLink;

import java.util.List;
import java.util.Optional;

public interface MusicLinkService {
    List<MusicLink> getAllMusicLinks();
    Optional<MusicLink> getMusicLinkById(String id);
    MusicLink createMusicLink(MusicLink musicLink);
    void deleteMusicLink(String id);
}