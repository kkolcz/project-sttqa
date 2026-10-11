package com.sttqa.project.infrastructure;

import com.sttqa.project.application.ProjectRepository;
import com.sttqa.project.domain.Project;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProjectRepositoryAdapter implements ProjectRepository {
    private final JpaProjectRepository jpa;
    public ProjectRepositoryAdapter(JpaProjectRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Project save(Project project) {
        return jpa.save(project);
    }

    @Override
    public Optional<Project> findByIdAndOwnerUsername(Long id, String ownerUsername) {
        return jpa.findByIdAndOwnerUsername(id, ownerUsername);
    }

    @Override
    public List<Project> findAllByOwnerUsername(String ownerUsername) {
        return jpa.findAllByOwnerUsername(ownerUsername);
    }

    @Override
    public void delete(Project project) {
        jpa.delete(project);
    }
}
