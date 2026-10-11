package com.sttqa.project.infrastructure;

import com.sttqa.project.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaProjectRepository extends JpaRepository<Project, Long> {
    Optional<Project> findByIdAndOwnerUsername(Long id, String ownerUsername);
    List<Project> findAllByOwnerUsername(String ownerUsername);
}
