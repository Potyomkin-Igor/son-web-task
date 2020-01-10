package com.example.demo.service.commit;

import com.example.demo.config.PropertiesConfig;
import com.example.demo.dto.commit.GHCommitResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Primary
@AllArgsConstructor
@Service("RestCommitsService")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestCommitsService implements CommitService<GHCommitResponse> {
    final String REPOSITORY_LINK = "https://api.github.com/repos/angular/angular/commits?client_id=%s&client_secret=%s&per_page=%d";
    final int COMMITS_SIZE = 25;

    final RestTemplate restTemplate;
    final PropertiesConfig.GitHubProperties gitHubProperties;

    @Override
    public List<GHCommitResponse> getCommits() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String targetUrl = String.format(REPOSITORY_LINK, gitHubProperties.getClientId(), gitHubProperties.getClientSecret(), COMMITS_SIZE);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(targetUrl);

        ResponseEntity<GHCommitResponse[]> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                GHCommitResponse[].class
        );
        return Arrays.asList(response.getBody());
    }
}
