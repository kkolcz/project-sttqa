package com.sttqa.project.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ListProjectsService implements ListProjectsUseCase {

    private final ProjectRepository projectRepository;

    public ListProjectsService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProjectResult> list(String ownerUsername) {
        return projectRepository.findAllByOwnerUsername(ownerUsername).stream()
                .map(ProjectResult::from)
                .toList();
    }
}