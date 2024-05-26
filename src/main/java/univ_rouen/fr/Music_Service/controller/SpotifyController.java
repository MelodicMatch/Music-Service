package univ_rouen.fr.Music_Service.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import univ_rouen.fr.Music_Service.service.SpotifyService;

import java.util.Map;

@RestController
@RequestMapping("/spotify")
public class SpotifyController {

    @Autowired
    private SpotifyService spotifyService;

    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> searchTracks(@RequestParam String query) {
        Map<String, Object> response = spotifyService.searchTracks(query);
        return ResponseEntity.ok(response);
    }
}
