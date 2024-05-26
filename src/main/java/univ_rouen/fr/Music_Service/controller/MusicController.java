package univ_rouen.fr.Music_Service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import univ_rouen.fr.Music_Service.entity.*;
import univ_rouen.fr.Music_Service.service.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/music")
@AllArgsConstructor
@Tag(name = "Music API", description = "API for managing music entities")
public class MusicController {

    private final GenreService genreService;
    private final SubGenreService subGenreService;
    private final ArtistService artistService;
    private final MusicServiceService musicServiceService;
    private final MusicManagementService musicManagementService;
    private final MusicLinkService musicLinkService;
    private final PlaylistService playlistService;
    private final PlaylistMusicService playlistMusicService;
    private final PlaylistSubscriberService playlistSubscriberService;
    private final KafkaService kafkaService;

    // Endpoints for Genre
    @Operation(summary = "Get all genres", description = "Retrieve a list of all genres")
    @GetMapping("/genres")
    public ResponseEntity<List<Genre>> getAllGenres() {
        return ResponseEntity.ok(genreService.getAllGenres());
    }

    @Operation(summary = "Get genre by ID", description = "Retrieve a genre by its ID")
    @GetMapping("/genres/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable String id) {
        Optional<Genre> genre = genreService.getGenreById(id);
        return genre.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create new genre", description = "Create a new genre")
    @PostMapping("/genres")
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre) {
        return ResponseEntity.ok(genreService.createGenre(genre));
    }

    @Operation(summary = "Delete genre", description = "Delete a genre by its ID")
    @DeleteMapping("/genres/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable String id) {
        genreService.deleteGenre(id);
        kafkaService.sendMessage("Genre deleted: " + id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints for SubGenre
    @Operation(summary = "Get all subGenres", description = "Retrieve a list of all subGenres")
    @GetMapping("/subGenres")
    public ResponseEntity<List<SubGenre>> getAllSubGenres() {
        return ResponseEntity.ok(subGenreService.getAllSubGenres());
    }

    @Operation(summary = "Get subGenre by ID", description = "Retrieve a subGenre by its ID")
    @GetMapping("/subGenres/{id}")
    public ResponseEntity<SubGenre> getSubGenreById(@PathVariable String id) {
        Optional<SubGenre> subGenre = subGenreService.getSubGenreById(id);
        return subGenre.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create new subGenre", description = "Create a new subGenre")
    @PostMapping("/subGenres")
    public ResponseEntity<SubGenre> createSubGenre(@RequestBody SubGenre subGenre) {
        return ResponseEntity.ok(subGenreService.createSubGenre(subGenre));
    }

    @Operation(summary = "Delete subGenre", description = "Delete a subGenre by its ID")
    @DeleteMapping("/subGenres/{id}")
    public ResponseEntity<Void> deleteSubGenre(@PathVariable String id) {
        subGenreService.deleteSubGenre(id);
        kafkaService.sendMessage("SubGenre deleted: " + id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints for Artist
    @Operation(summary = "Get all artists", description = "Retrieve a list of all artists")
    @GetMapping("/artists")
    public ResponseEntity<List<Artist>> getAllArtists() {
        return ResponseEntity.ok(artistService.getAllArtists());
    }

    @Operation(summary = "Get artist by ID", description = "Retrieve an artist by its ID")
    @GetMapping("/artists/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable String id) {
        Optional<Artist> artist = artistService.getArtistById(id);
        return artist.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create new artist", description = "Create a new artist")
    @PostMapping("/artists")
    public ResponseEntity<Artist> createArtist(@RequestBody Artist artist) {
        return ResponseEntity.ok(artistService.createArtist(artist));
    }

    @Operation(summary = "Delete artist", description = "Delete an artist by its ID")
    @DeleteMapping("/artists/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable String id) {
        artistService.deleteArtist(id);
        kafkaService.sendMessage("Artist deleted: " + id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints for MusicService
    @Operation(summary = "Get all music services", description = "Retrieve a list of all music services")
    @GetMapping("/musicServices")
    public ResponseEntity<List<MusicService>> getAllMusicServices() {
        return ResponseEntity.ok(musicServiceService.getAllMusicServices());
    }

    @Operation(summary = "Get music service by ID", description = "Retrieve a music service by its ID")
    @GetMapping("/musicServices/{id}")
    public ResponseEntity<MusicService> getMusicServiceById(@PathVariable String id) {
        Optional<MusicService> musicService = musicServiceService.getMusicServiceById(id);
        return musicService.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create new music service", description = "Create a new music service")
    @PostMapping("/musicServices")
    public ResponseEntity<MusicService> createMusicService(@RequestBody MusicService musicService) {
        return ResponseEntity.ok(musicServiceService.createMusicService(musicService));
    }

    @Operation(summary = "Delete music service", description = "Delete a music service by its ID")
    @DeleteMapping("/musicServices/{id}")
    public ResponseEntity<Void> deleteMusicService(@PathVariable String id) {
        musicServiceService.deleteMusicService(id);
        kafkaService.sendMessage("MusicService deleted: " + id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints for Music
    @Operation(summary = "Get all musics", description = "Retrieve a list of all musics")
    @GetMapping("/musics")
    public ResponseEntity<List<Music>> getAllMusics() {
        return ResponseEntity.ok(musicManagementService.getAllMusics());
    }

    @Operation(summary = "Get music by ID", description = "Retrieve a music by its ID")
    @GetMapping("/musics/{id}")
    public ResponseEntity<Music> getMusicById(@PathVariable String id) {
        Optional<Music> music = musicManagementService.getMusicById(id);
        return music.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create new music", description = "Create a new music")
    @PostMapping("/musics")
    public ResponseEntity<Music> createMusic(@RequestBody Music music) {
        return ResponseEntity.ok(musicManagementService.createMusic(music));
    }

    @Operation(summary = "Delete music", description = "Delete a music by its ID")
    @DeleteMapping("/musics/{id}")
    public ResponseEntity<Void> deleteMusic(@PathVariable String id) {
        musicManagementService.deleteMusic(id);
        kafkaService.sendMessage("Music deleted: " + id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints for MusicLink
    @Operation(summary = "Get all music links", description = "Retrieve a list of all music links")
    @GetMapping("/musicLinks")
    public ResponseEntity<List<MusicLink>> getAllMusicLinks() {
        return ResponseEntity.ok(musicLinkService.getAllMusicLinks());
    }

    @Operation(summary = "Get music link by ID", description = "Retrieve a music link by its ID")
    @GetMapping("/musicLinks/{id}")
    public ResponseEntity<MusicLink> getMusicLinkById(@PathVariable String id) {
        Optional<MusicLink> musicLink = musicLinkService.getMusicLinkById(id);
        return musicLink.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create new music link", description = "Create a new music link")
    @PostMapping("/musicLinks")
    public ResponseEntity<MusicLink> createMusicLink(@RequestBody MusicLink musicLink) {
        return ResponseEntity.ok(musicLinkService.createMusicLink(musicLink));
    }

    @Operation(summary = "Delete music link", description = "Delete a music link by its ID")
    @DeleteMapping("/musicLinks/{id}")
    public ResponseEntity<Void> deleteMusicLink(@PathVariable String id) {
        musicLinkService.deleteMusicLink(id);
        kafkaService.sendMessage("MusicLink deleted: " + id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints for Playlist
    @Operation(summary = "Get all playlists", description = "Retrieve a list of all playlists")
    @GetMapping("/playlists")
    public ResponseEntity<List<Playlist>> getAllPlaylists() {
        return ResponseEntity.ok(playlistService.getAllPlaylists());
    }

    @Operation(summary = "Get playlist by ID", description = "Retrieve a playlist by its ID")
    @GetMapping("/playlists/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable String id) {
        Optional<Playlist> playlist = playlistService.getPlaylistById(id);
        return playlist.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create new playlist", description = "Create a new playlist")
    @PostMapping("/playlists")
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist) {
        return ResponseEntity.ok(playlistService.createPlaylist(playlist));
    }

    @Operation(summary = "Delete playlist", description = "Delete a playlist by its ID")
    @DeleteMapping("/playlists/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable String id) {
        playlistService.deletePlaylist(id);
        kafkaService.sendMessage("Playlist deleted: " + id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints for PlaylistMusic
    @Operation(summary = "Get all playlist musics", description = "Retrieve a list of all playlist musics")
    @GetMapping("/playlistMusics")
    public ResponseEntity<List<PlaylistMusic>> getAllPlaylistMusics() {
        return ResponseEntity.ok(playlistMusicService.getAllPlaylistMusics());
    }

    @Operation(summary = "Get playlist music by ID", description = "Retrieve a playlist music by its ID")
    @GetMapping("/playlistMusics/{id}")
    public ResponseEntity<PlaylistMusic> getPlaylistMusicById(@PathVariable String id) {
        Optional<PlaylistMusic> playlistMusic = playlistMusicService.getPlaylistMusicById(id);
        return playlistMusic.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create new playlist music", description = "Create a new playlist music")
    @PostMapping("/playlistMusics")
    public ResponseEntity<PlaylistMusic> createPlaylistMusic(@RequestBody PlaylistMusic playlistMusic) {
        return ResponseEntity.ok(playlistMusicService.createPlaylistMusic(playlistMusic));
    }

    @Operation(summary = "Delete playlist music", description = "Delete a playlist music by its ID")
    @DeleteMapping("/playlistMusics/{id}")
    public ResponseEntity<Void> deletePlaylistMusic(@PathVariable String id) {
        playlistMusicService.deletePlaylistMusic(id);
        kafkaService.sendMessage("PlaylistMusic deleted: " + id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints for PlaylistSubscriber
    @Operation(summary = "Get all playlist subscribers", description = "Retrieve a list of all playlist subscribers")
    @GetMapping("/playlistSubscribers")
    public ResponseEntity<List<PlaylistSubscriber>> getAllPlaylistSubscribers() {
        return ResponseEntity.ok(playlistSubscriberService.getAllPlaylistSubscribers());
    }

    @Operation(summary = "Get playlist subscriber by ID", description = "Retrieve a playlist subscriber by its ID")
    @GetMapping("/playlistSubscribers/{id}")
    public ResponseEntity<PlaylistSubscriber> getPlaylistSubscriberById(@PathVariable String id) {
        Optional<PlaylistSubscriber> playlistSubscriber = playlistSubscriberService.getPlaylistSubscriberById(id);
        return playlistSubscriber.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create new playlist subscriber", description = "Create a new playlist subscriber")
    @PostMapping("/playlistSubscribers")
    public ResponseEntity<PlaylistSubscriber> createPlaylistSubscriber(@RequestBody PlaylistSubscriber playlistSubscriber) {
        return ResponseEntity.ok(playlistSubscriberService.createPlaylistSubscriber(playlistSubscriber));
    }

    @Operation(summary = "Delete playlist subscriber", description = "Delete a playlist subscriber by its ID")
    @DeleteMapping("/playlistSubscribers/{id}")
    public ResponseEntity<Void> deletePlaylistSubscriber(@PathVariable String id) {
        playlistSubscriberService.deletePlaylistSubscriber(id);
        kafkaService.sendMessage("PlaylistSubscriber deleted: " + id);
        return ResponseEntity.noContent().build();
    }
}
