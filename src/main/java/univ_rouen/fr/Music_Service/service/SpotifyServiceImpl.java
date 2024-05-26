package univ_rouen.fr.Music_Service.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.Map;

@Service
public class SpotifyServiceImpl implements SpotifyService {

    @Value("${spotify.api.client-id}")
    private String clientId;

    @Value("${spotify.api.client-secret}")
    private String clientSecret;

    @Value("${spotify.api.token-url}")
    private String tokenUrl;

    @Value("${spotify.api.api-url}")
    private String apiUrl;

    private String accessToken;

    @Override
    public Map searchTracks(String query) {
        if (accessToken == null) {
            accessToken = getAccessToken();
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl + "/search")
                .queryParam("q", query)
                .queryParam("type", "track");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                Map.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to search tracks on Spotify");
        }
    }

    private String getAccessToken() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth(clientId, clientSecret);

        HttpEntity<String> request = new HttpEntity<>("grant_type=client_credentials", headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(tokenUrl, request, Map.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return (String) response.getBody().get("access_token");
        } else {
            throw new RuntimeException("Failed to get Spotify access token");
        }
    }
}
