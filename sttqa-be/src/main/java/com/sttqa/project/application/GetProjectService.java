package com.sttqa.project.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GetProjectService implements GetProjectUseCase {

    private final ProjectRepository projectRepository;

    public GetProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectResult get(String ownerUsername, Long projectId) {
        return projectRepository.findByIdAndOwnerUsername(projectId, ownerUsername)
                .map(ProjectResult::from)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));
    }
}