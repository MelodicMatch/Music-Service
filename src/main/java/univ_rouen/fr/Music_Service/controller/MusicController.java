package univ_rouen.fr.Music_Service.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import univ_rouen.fr.Music_Service.entity.*;
import univ_rouen.fr.Music_Service.service.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/music")
@AllArgsConstructor
public class MusicController {

    @Autowired
    private GenreService genreService;


    private final SubGenreService subGenreService;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private MusicServiceService musicServiceService;

    @Autowired
    private MusicManagementService musicManagementService;

    @Autowired
    private MusicLinkService musicLinkService;

    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private PlaylistMusicService playlistMusicService;

    @Autowired
    private PlaylistSubscriberService playlistSubscriberService;

    // Endpoints for Genre
    @GetMapping("/genres")
    public ResponseEntity<List<Genre>> getAllGenres() {
        return ResponseEntity.ok(genreService.getAllGenres());
    }

    @GetMapping("/genres/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable String id) {
        Optional<Genre> genre = genreService.getGenreById(id);
        return genre.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/genres")
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre) {
        return ResponseEntity.ok(genreService.createGenre(genre));
    }

    @DeleteMapping("/genres/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable String id) {
        genreService.deleteGenre(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints for SubGenre
    @GetMapping("/subGenres")
    public ResponseEntity<List<SubGenre>> getAllSubGenres() {
        return ResponseEntity.ok(subGenreService.getAllSubGenres());
    }

    @GetMapping("/subGenres/{id}")
    public ResponseEntity<SubGenre> getSubGenreById(@PathVariable String id) {
        Optional<SubGenre> subGenre = subGenreService.getSubGenreById(id);
        return subGenre.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/subGenres")
    public ResponseEntity<SubGenre> createSubGenre(@RequestBody SubGenre subGenre) {
        return ResponseEntity.ok(subGenreService.createSubGenre(subGenre));
    }

    @DeleteMapping("/subGenres/{id}")
    public ResponseEntity<Void> deleteSubGenre(@PathVariable String id) {
        subGenreService.deleteSubGenre(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints for Artist
    @GetMapping("/artists")
    public ResponseEntity<List<Artist>> getAllArtists() {
        return ResponseEntity.ok(artistService.getAllArtists());
    }

    @GetMapping("/artists/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable String id) {
        Optional<Artist> artist = artistService.getArtistById(id);
        return artist.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/artists")
    public ResponseEntity<Artist> createArtist(@RequestBody Artist artist) {
        return ResponseEntity.ok(artistService.createArtist(artist));
    }

    @DeleteMapping("/artists/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable String id) {
        artistService.deleteArtist(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints for MusicService
    @GetMapping("/musicServices")
    public ResponseEntity<List<MusicService>> getAllMusicServices() {
        return ResponseEntity.ok(musicServiceService.getAllMusicServices());
    }

    @GetMapping("/musicServices/{id}")
    public ResponseEntity<MusicService> getMusicServiceById(@PathVariable String id) {
        Optional<MusicService> musicService = musicServiceService.getMusicServiceById(id);
        return musicService.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/musicServices")
    public ResponseEntity<MusicService> createMusicService(@RequestBody MusicService musicService) {
        return ResponseEntity.ok(musicServiceService.createMusicService(musicService));
    }

    @DeleteMapping("/musicServices/{id}")
    public ResponseEntity<Void> deleteMusicService(@PathVariable String id) {
        musicServiceService.deleteMusicService(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints for Music
    @GetMapping("/musics")
    public ResponseEntity<List<Music>> getAllMusics() {
        return ResponseEntity.ok(musicManagementService.getAllMusics());
    }

    @GetMapping("/musics/{id}")
    public ResponseEntity<Music> getMusicById(@PathVariable String id) {
        Optional<Music> music = musicManagementService.getMusicById(id);
        return music.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/musics")
    public ResponseEntity<Music> createMusic(@RequestBody Music music) {
        return ResponseEntity.ok(musicManagementService.createMusic(music));
    }

    @DeleteMapping("/musics/{id}")
    public ResponseEntity<Void> deleteMusic(@PathVariable String id) {
        musicManagementService.deleteMusic(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints for MusicLink
    @GetMapping("/musicLinks")
    public ResponseEntity<List<MusicLink>> getAllMusicLinks() {
        return ResponseEntity.ok(musicLinkService.getAllMusicLinks());
    }

    @GetMapping("/musicLinks/{id}")
    public ResponseEntity<MusicLink> getMusicLinkById(@PathVariable String id) {
        Optional<MusicLink> musicLink = musicLinkService.getMusicLinkById(id);
        return musicLink.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/musicLinks")
    public ResponseEntity<MusicLink> createMusicLink(@RequestBody MusicLink musicLink) {
        return ResponseEntity.ok(musicLinkService.createMusicLink(musicLink));
    }

    @DeleteMapping("/musicLinks/{id}")
    public ResponseEntity<Void> deleteMusicLink(@PathVariable String id) {
        musicLinkService.deleteMusicLink(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints for Playlist
    @GetMapping("/playlists")
    public ResponseEntity<List<Playlist>> getAllPlaylists() {
        return ResponseEntity.ok(playlistService.getAllPlaylists());
    }

    @GetMapping("/playlists/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable String id) {
        Optional<Playlist> playlist = playlistService.getPlaylistById(id);
        return playlist.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/playlists")
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist) {
        return ResponseEntity.ok(playlistService.createPlaylist(playlist));
    }

    @DeleteMapping("/playlists/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable String id) {
        playlistService.deletePlaylist(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints for PlaylistMusic
    @GetMapping("/playlistMusics")
    public ResponseEntity<List<PlaylistMusic>> getAllPlaylistMusics() {
        return ResponseEntity.ok(playlistMusicService.getAllPlaylistMusics());
    }

    @GetMapping("/playlistMusics/{id}")
    public ResponseEntity<PlaylistMusic> getPlaylistMusicById(@PathVariable String id) {
        Optional<PlaylistMusic> playlistMusic = playlistMusicService.getPlaylistMusicById(id);
        return playlistMusic.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/playlistMusics")
    public ResponseEntity<PlaylistMusic> createPlaylistMusic(@RequestBody PlaylistMusic playlistMusic) {
        return ResponseEntity.ok(playlistMusicService.createPlaylistMusic(playlistMusic));
    }

    @DeleteMapping("/playlistMusics/{id}")
    public ResponseEntity<Void> deletePlaylistMusic(@PathVariable String id) {
        playlistMusicService.deletePlaylistMusic(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints for PlaylistSubscriber
    @GetMapping("/playlistSubscribers")
    public ResponseEntity<List<PlaylistSubscriber>> getAllPlaylistSubscribers() {
        return ResponseEntity.ok(playlistSubscriberService.getAllPlaylistSubscribers());
    }

    @GetMapping("/playlistSubscribers/{id}")
    public ResponseEntity<PlaylistSubscriber> getPlaylistSubscriberById(@PathVariable String id) {
        Optional<PlaylistSubscriber> playlistSubscriber = playlistSubscriberService.getPlaylistSubscriberById(id);
        return playlistSubscriber.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/playlistSubscribers")
    public ResponseEntity<PlaylistSubscriber> createPlaylistSubscriber(@RequestBody PlaylistSubscriber playlistSubscriber) {
        return ResponseEntity.ok(playlistSubscriberService.createPlaylistSubscriber(playlistSubscriber));
    }

    @DeleteMapping("/playlistSubscribers/{id}")
    public ResponseEntity<Void> deletePlaylistSubscriber(@PathVariable String id) {
        playlistSubscriberService.deletePlaylistSubscriber(id);
        return ResponseEntity.noContent().build();
    }
}