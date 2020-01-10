package com.example.demo.controller.commit;

import com.example.demo.service.commit.CommitService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.kohsuke.github.GHCommit;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/commits")
public class CommitController {

    @Qualifier("RestCommitsService")
    final CommitService commitService;

    @GetMapping
    public ResponseEntity<List<GHCommit>> getCommits() {
        return ResponseEntity.ok(commitService.getCommits());
    }
}

