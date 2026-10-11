package com.sttqa.project.application;

import com.sttqa.project.domain.Project;
import com.sttqa.user.application.UserRepository;
import com.sttqa.user.domain.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateProjectService implements CreateProjectUseCase {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public CreateProjectService(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public ProjectResult create(CreateProjectCommand command) {
        User owner = userRepository.findByUsername(command.ownerUsername())
                .orElseThrow(() -> new IllegalStateException("Authenticated user not found: " + command.ownerUsername()));
        Project project = new Project(owner, command.title(), command.description());
        return ProjectResult.from(projectRepository.save(project));
    }
}