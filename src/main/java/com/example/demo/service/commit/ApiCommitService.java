package com.example.demo.service.commit;

import com.example.demo.exception.GitHubException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.PagedIterable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("ApiCommitsService")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiCommitService implements CommitService<GHCommit> {

    final String REPOSITORY_NAME = "angular/angular";
    final int COMMITS_SIZE = 25;

    @Override
    public List<GHCommit> getCommits() {
        try {
            GitHub gitHub = GitHub.connectAnonymously();
            GHRepository repository = gitHub.getRepository(REPOSITORY_NAME);
            PagedIterable<GHCommit> commits = repository.listCommits().withPageSize(COMMITS_SIZE);

            return commits.asList();

        } catch (IOException e) {
            throw new GitHubException("An exception occurred while collaborating with GitHub. Reason: ".concat(e.getLocalizedMessage()));
        }
    }

}
