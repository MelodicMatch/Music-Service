package univ_rouen.fr.Music_Service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

import univ_rouen.fr.Music_Service.entity.*;
import univ_rouen.fr.Music_Service.service.*;


@Tag(name = "Music API", description = "API pour la gestion des entités musicales")
@RestController
@RequestMapping("/music")
@AllArgsConstructor
@Tag(name = "Music API", description = "API pour la gestion des entités musicales")
@Validated
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
    private final ObjectMapper objectMapper = new ObjectMapper();

    // Endpoints pour Genre
    @Operation(summary = "Obtenir tous les genres", description = "Récupérer une liste de tous les genres")
    @GetMapping("/genres")
    public ResponseEntity<List<Genre>> getAllGenres() {
        return ResponseEntity.ok(genreService.getAllGenres());
    }

    @Operation(summary = "Obtenir un genre par ID", description = "Récupérer un genre par son ID")
    @GetMapping("/genres/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable String id) {
        Optional<Genre> genre = genreService.getGenreById(id);
        return genre.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Créer un nouveau genre", description = "Créer un nouveau genre")
    @PostMapping("/genres")
    public ResponseEntity<Genre> createGenre(@Valid @RequestBody Genre genre) {
        Genre createdGenre = genreService.createGenre(genre);
        kafkaService.sendMessage(createdGenre.getGenreID(), createdGenre.getName());
        return ResponseEntity.ok(createdGenre);
    }

    @Operation(summary = "Supprimer un genre", description = "Supprimer un genre par son ID")
    @DeleteMapping("/genres/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable String id) {
        genreService.deleteGenre(id);
        kafkaService.sendMessage(id, "Genre supprimé");
        return ResponseEntity.noContent().build();
    }

    // Endpoints pour SubGenre
    @Operation(summary = "Obtenir tous les sous-genres", description = "Récupérer une liste de tous les sous-genres")
    @GetMapping("/subGenres")
    public ResponseEntity<List<SubGenre>> getAllSubGenres() {
        return ResponseEntity.ok(subGenreService.getAllSubGenres());
    }

    @Operation(summary = "Obtenir un sous-genre par ID", description = "Récupérer un sous-genre par son ID")
    @GetMapping("/subGenres/{id}")
    public ResponseEntity<SubGenre> getSubGenreById(@PathVariable String id) {
        Optional<SubGenre> subGenre = subGenreService.getSubGenreById(id);
        return subGenre.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Créer un nouveau sous-genre", description = "Créer un nouveau sous-genre")
    @PostMapping("/subGenres")
    public ResponseEntity<SubGenre> createSubGenre(@Valid @RequestBody SubGenre subGenre) {
        SubGenre createdSubGenre = subGenreService.createSubGenre(subGenre);
        kafkaService.sendMessage(createdSubGenre.getId(), createdSubGenre.toString());
        return ResponseEntity.ok(createdSubGenre);
    }

    @Operation(summary = "Supprimer un sous-genre", description = "Supprimer un sous-genre par son ID")
    @DeleteMapping("/subGenres/{id}")
    public ResponseEntity<Void> deleteSubGenre(@PathVariable String id) {
        subGenreService.deleteSubGenre(id);
        kafkaService.sendMessage(id, "Sous-genre supprimé");
        return ResponseEntity.noContent().build();
    }

    // Endpoints pour Artist
    @Operation(summary = "Obtenir tous les artistes", description = "Récupérer une liste de tous les artistes")
    @GetMapping("/artists")
    public ResponseEntity<List<Artist>> getAllArtists() {
        return ResponseEntity.ok(artistService.getAllArtists());
    }

    @Operation(summary = "Obtenir un artiste par ID", description = "Récupérer un artiste par son ID")
    @GetMapping("/artists/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable String id) {
        Optional<Artist> artist = artistService.getArtistById(id);
        return artist.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Créer un nouvel artiste", description = "Créer un nouvel artiste")
    @PostMapping("/artists")
    public ResponseEntity<Artist> createArtist(@Valid @RequestBody Artist artist) {
        Artist createdArtist = artistService.createArtist(artist);
        kafkaService.sendMessage(createdArtist.getArtistID(), createdArtist.getName());
        return ResponseEntity.ok(createdArtist);
    }

    @Operation(summary = "Supprimer un artiste", description = "Supprimer un artiste par son ID")
    @DeleteMapping("/artists/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable String id) {
        artistService.deleteArtist(id);
        kafkaService.sendMessage(id, "Artiste supprimé");
        return ResponseEntity.noContent().build();
    }

    // Endpoints pour MusicService
    @Operation(summary = "Obtenir tous les services musicaux", description = "Récupérer une liste de tous les services musicaux")
    @GetMapping("/musicServices")
    public ResponseEntity<List<MusicService>> getAllMusicServices() {
        return ResponseEntity.ok(musicServiceService.getAllMusicServices());
    }

    @Operation(summary = "Obtenir un service musical par ID", description = "Récupérer un service musical par son ID")
    @GetMapping("/musicServices/{id}")
    public ResponseEntity<MusicService> getMusicServiceById(@PathVariable String id) {
        Optional<MusicService> musicService = musicServiceService.getMusicServiceById(id);
        return musicService.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Créer un nouveau service musical", description = "Créer un nouveau service musical")
    @PostMapping("/musicServices")
    public ResponseEntity<MusicService> createMusicService(@Valid @RequestBody MusicService musicService) {
        MusicService createdMusicService = musicServiceService.createMusicService(musicService);
        kafkaService.sendMessage(createdMusicService.getMusicServiceID(), createdMusicService.getName());
        return ResponseEntity.ok(createdMusicService);
    }

    @Operation(summary = "Supprimer un service musical", description = "Supprimer un service musical par son ID")
    @DeleteMapping("/musicServices/{id}")
    public ResponseEntity<Void> deleteMusicService(@PathVariable String id) {
        musicServiceService.deleteMusicService(id);
        kafkaService.sendMessage(id, "Service musical supprimé");
        return ResponseEntity.noContent().build();
    }

    // Endpoints pour Music
    @Operation(summary = "Obtenir toutes les musiques", description = "Récupérer une liste de toutes les musiques")
    @GetMapping("/musics")
    public ResponseEntity<List<Music>> getAllMusics() {
        return ResponseEntity.ok(musicManagementService.getAllMusics());
    }

    @Operation(summary = "Obtenir une musique par ID", description = "Récupérer une musique par son ID")
    @GetMapping("/musics/{id}")
    public ResponseEntity<Music> getMusicById(@PathVariable String id) {
        Optional<Music> music = musicManagementService.getMusicById(id);
        return music.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Créer une nouvelle musique", description = "Créer une nouvelle musique")
    @PostMapping("/musics")
    public ResponseEntity<Music> createMusic(@Valid @RequestBody Music music) {
        Music createdMusic = musicManagementService.createMusic(music);
        kafkaService.sendMessage(createdMusic.getMusicID(), createdMusic.getTitle());
        return ResponseEntity.ok(createdMusic);
    }

    @Operation(summary = "Supprimer une musique", description = "Supprimer une musique par son ID")
    @DeleteMapping("/musics/{id}")
    public ResponseEntity<Void> deleteMusic(@PathVariable String id) {
        musicManagementService.deleteMusic(id);
        kafkaService.sendMessage(id, "Musique supprimée");
        return ResponseEntity.noContent().build();
    }

    // Endpoints pour MusicLink
    @Operation(summary = "Obtenir tous les liens musicaux", description = "Récupérer une liste de tous les liens musicaux")
    @GetMapping("/musicLinks")
    public ResponseEntity<List<MusicLink>> getAllMusicLinks() {
        return ResponseEntity.ok(musicLinkService.getAllMusicLinks());
    }

    @Operation(summary = "Obtenir un lien musical par ID", description = "Récupérer un lien musical par son ID")
    @GetMapping("/musicLinks/{id}")
    public ResponseEntity<MusicLink> getMusicLinkById(@PathVariable String id) {
        Optional<MusicLink> musicLink = musicLinkService.getMusicLinkById(id);
        return musicLink.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Créer un nouveau lien musical", description = "Créer un nouveau lien musical")
    @PostMapping("/musicLinks")
    public ResponseEntity<MusicLink> createMusicLink(@Valid @RequestBody MusicLink musicLink) {
        MusicLink createdMusicLink = musicLinkService.createMusicLink(musicLink);
        kafkaService.sendMessage(createdMusicLink.getId(), "Nouveau lien musical créé");
        return ResponseEntity.ok(createdMusicLink);
    }

    @Operation(summary = "Supprimer un lien musical", description = "Supprimer un lien musical par son ID")
    @DeleteMapping("/musicLinks/{id}")
    public ResponseEntity<Void> deleteMusicLink(@PathVariable String id) {
        musicLinkService.deleteMusicLink(id);
        kafkaService.sendMessage(id, "Lien musical supprimé");
        return ResponseEntity.noContent().build();
    }

    // Endpoints pour Playlist
    @Operation(summary = "Obtenir toutes les playlists", description = "Récupérer une liste de toutes les playlists")
    @GetMapping("/playlists")
    public ResponseEntity<List<Playlist>> getAllPlaylists() {
        return ResponseEntity.ok(playlistService.getAllPlaylists());
    }

    @Operation(summary = "Obtenir une playlist par ID", description = "Récupérer une playlist par son ID")
    @GetMapping("/playlists/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable String id) {
        Optional<Playlist> playlist = playlistService.getPlaylistById(id);
        return playlist.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Créer une nouvelle playlist", description = "Créer une nouvelle playlist")
    @PostMapping("/playlists")
    public ResponseEntity<Playlist> createPlaylist(@Valid @RequestBody Playlist playlist) {
        Playlist createdPlaylist = playlistService.createPlaylist(playlist);
        kafkaService.sendMessage(createdPlaylist.getPlaylistID(), createdPlaylist.getName());
        return ResponseEntity.ok(createdPlaylist);
    }

    @Operation(summary = "Supprimer une playlist", description = "Supprimer une playlist par son ID")
    @DeleteMapping("/playlists/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable String id) {
        playlistService.deletePlaylist(id);
        kafkaService.sendMessage(id, "Playlist supprimée");
        return ResponseEntity.noContent().build();
    }

    // Endpoints pour PlaylistMusic
    @Operation(summary = "Obtenir toutes les musiques de playlist", description = "Récupérer une liste de toutes les musiques de playlist")
    @GetMapping("/playlistMusics")
    public ResponseEntity<List<PlaylistMusic>> getAllPlaylistMusics() {
        return ResponseEntity.ok(playlistMusicService.getAllPlaylistMusics());
    }

    @Operation(summary = "Obtenir une musique de playlist par ID", description = "Récupérer une musique de playlist par son ID")
    @GetMapping("/playlistMusics/{id}")
    public ResponseEntity<PlaylistMusic> getPlaylistMusicById(@PathVariable String id) {
        Optional<PlaylistMusic> playlistMusic = playlistMusicService.getPlaylistMusicById(id);
        return playlistMusic.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Créer une nouvelle musique de playlist", description = "Créer une nouvelle musique de playlist")
    @PostMapping("/playlistMusics")
    public ResponseEntity<PlaylistMusic> createPlaylistMusic(@Valid @RequestBody PlaylistMusic playlistMusic) {
        PlaylistMusic createdPlaylistMusic = playlistMusicService.createPlaylistMusic(playlistMusic);
        kafkaService.sendMessage(createdPlaylistMusic.getId(), "Nouvelle musique de playlist créée");
        return ResponseEntity.ok(createdPlaylistMusic);
    }

    @Operation(summary = "Supprimer une musique de playlist", description = "Supprimer une musique de playlist par son ID")
    @DeleteMapping("/playlistMusics/{id}")
    public ResponseEntity<Void> deletePlaylistMusic(@PathVariable String id) {
        playlistMusicService.deletePlaylistMusic(id);
        kafkaService.sendMessage(id, "Musique de playlist supprimée");
        return ResponseEntity.noContent().build();
    }

    // Endpoints pour PlaylistSubscriber
    @Operation(summary = "Obtenir tous les abonnés de playlist", description = "Récupérer une liste de tous les abonnés de playlist")
    @GetMapping("/playlistSubscribers")
    public ResponseEntity<List<PlaylistSubscriber>> getAllPlaylistSubscribers() {
        return ResponseEntity.ok(playlistSubscriberService.getAllPlaylistSubscribers());
    }

    @Operation(summary = "Obtenir un abonné de playlist par ID", description = "Récupérer un abonné de playlist par son ID")
    @GetMapping("/playlistSubscribers/{id}")
    public ResponseEntity<PlaylistSubscriber> getPlaylistSubscriberById(@PathVariable String id) {
        Optional<PlaylistSubscriber> playlistSubscriber = playlistSubscriberService.getPlaylistSubscriberById(id);
        return playlistSubscriber.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Créer un nouvel abonné de playlist", description = "Créer un nouvel abonné de playlist")
    @PostMapping("/playlistSubscribers")
    public ResponseEntity<PlaylistSubscriber> createPlaylistSubscriber(@Valid @RequestBody PlaylistSubscriber playlistSubscriber) {
        PlaylistSubscriber createdPlaylistSubscriber = playlistSubscriberService.createPlaylistSubscriber(playlistSubscriber);
        kafkaService.sendMessage(createdPlaylistSubscriber.getId(), "Nouvel abonné de playlist créé");
        return ResponseEntity.ok(createdPlaylistSubscriber);
    }

    @Operation(summary = "Supprimer un abonné de playlist", description = "Supprimer un abonné de playlist par son ID")
    @DeleteMapping("/playlistSubscribers/{id}")
    public ResponseEntity<Void> deletePlaylistSubscriber(@PathVariable String id) {
        playlistSubscriberService.deletePlaylistSubscriber(id);
        kafkaService.sendMessage(id, "Abonné de playlist supprimé");
        return ResponseEntity.noContent().build();
    }
}

