package com.sttqa.project.application;

import com.sttqa.project.domain.Project;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteProjectService implements DeleteProjectUseCase {

    private final ProjectRepository projectRepository;

    public DeleteProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    @Transactional
    public void delete(String ownerUsername, Long projectId) {
        Project project = projectRepository.findByIdAndOwnerUsername(projectId, ownerUsername)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));
        projectRepository.delete(project);
    }
}