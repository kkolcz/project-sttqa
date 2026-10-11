package com.sttqa.project.application;

import com.sttqa.project.domain.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    Project save(Project project);
    Optional<Project> findByIdAndOwnerUsername(Long id, String username);
    List<Project> findAllByOwnerUsername(String ownerUsername);
    void delete(Project project);
}
