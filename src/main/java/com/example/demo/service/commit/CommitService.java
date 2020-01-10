package com.example.demo.service.commit;

import java.util.List;

public interface CommitService<T> {

    List<T> getCommits();
}
