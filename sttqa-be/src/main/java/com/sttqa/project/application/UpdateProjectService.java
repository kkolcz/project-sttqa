package com.sttqa.project.application;

import com.sttqa.project.domain.Project;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateProjectService implements UpdateProjectUseCase {

    private final ProjectRepository projectRepository;

    public UpdateProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    @Transactional
    public ProjectResult update(UpdateProjectCommand command) {
        Project project = projectRepository.findByIdAndOwnerUsername(command.projectId(), command.ownerUsername())
                .orElseThrow(() -> new ProjectNotFoundException(command.projectId()));
        project.update(command.title(), command.description());
        return ProjectResult.from(project);
    }
}