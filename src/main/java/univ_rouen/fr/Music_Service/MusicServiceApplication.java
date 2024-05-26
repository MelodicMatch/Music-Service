package univ_rouen.fr.Music_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import univ_rouen.fr.Music_Service.entity.*;
import univ_rouen.fr.Music_Service.service.*;

@SpringBootApplication
public class MusicServiceApplication implements CommandLineRunner {

	@Autowired
	private MusicManagementService musicManagementService;
	@Autowired
	private GenreService genreService;
	@Autowired
	private ArtistService artistService;
	@Autowired
	private MusicLinkService musicLinkService;
	@Autowired
	private PlaylistService playlistService;
	@Autowired
	private PlaylistMusicService playlistMusicService;
	@Autowired
	private PlaylistSubscriberService playlistSubscriberService;
	@Autowired
	private MusicServiceService musicServiceService;

	public static void main(String[] args) {
		SpringApplication.run(MusicServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Création de genres
		Genre rock = new Genre("1", "Rock", false);
		Genre pop = new Genre("2", "Pop", false);
		genreService.createGenre(rock);
		genreService.createGenre(pop);

		// Création d'artistes
		Artist artist1 = new Artist("1", "Artist One", "account1");
		Artist artist2 = new Artist("2", "Artist Two", "account2");
		artistService.createArtist(artist1);
		artistService.createArtist(artist2);

		// Création de musiques
		Music music1 = Music.builder()
				.musicID("1")
				.genre(rock)
				.artist(artist1)
				.title("Rock Song")
				.build();
		Music music2 = Music.builder()
				.musicID("2")
				.genre(pop)
				.artist(artist2)
				.title("Pop Song")
				.build();
		musicManagementService.createMusic(music1);
		musicManagementService.createMusic(music2);

		// Création de services de musique
		MusicService spotify = MusicService.builder()
				.musicServiceID("1")
				.name("Spotify")
				.url("http://spotify.com")
				.build();
		MusicService appleMusic = MusicService.builder()
				.musicServiceID("2")
				.name("Apple Music")
				.url("http://apple.com/music")
				.build();
		musicServiceService.createMusicService(spotify);
		musicServiceService.createMusicService(appleMusic);

		// Création de liens de musique
		MusicLink link1 = new MusicLink("1", music1, spotify, "http://spotify.com/rocksong");
		MusicLink link2 = new MusicLink("2", music2, appleMusic, "http://apple.com/popsong");
		musicLinkService.createMusicLink(link1);
		musicLinkService.createMusicLink(link2);

		// Création de playlists
		Playlist playlist1 = new Playlist("1", "user1", "Rock Playlist", "A collection of rock songs");
		Playlist playlist2 = new Playlist("2", "user2", "Pop Playlist", "A collection of pop songs");
		playlistService.createPlaylist(playlist1);
		playlistService.createPlaylist(playlist2);

		// Ajout de musiques aux playlists
		PlaylistMusic playlistMusic1 = new PlaylistMusic("1", playlist1, music1);
		PlaylistMusic playlistMusic2 = new PlaylistMusic("2", playlist2, music2);
		playlistMusicService.createPlaylistMusic(playlistMusic1);
		playlistMusicService.createPlaylistMusic(playlistMusic2);

		// Abonnement aux playlists
		PlaylistSubscriber subscriber1 = new PlaylistSubscriber("1", playlist1, "user1");
		PlaylistSubscriber subscriber2 = new PlaylistSubscriber("2", playlist2, "user2");
		playlistSubscriberService.createPlaylistSubscriber(subscriber1);
		playlistSubscriberService.createPlaylistSubscriber(subscriber2);

		System.out.println("Music data created successfully.");
	}
}
