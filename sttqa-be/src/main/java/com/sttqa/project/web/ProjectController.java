package com.sttqa.project.web;

import com.sttqa.project.application.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

    private final CreateProjectUseCase createProjectUseCase;
    private final ListProjectsUseCase listProjectsUseCase;
    private final GetProjectUseCase getProjectUseCase;
    private final UpdateProjectUseCase updateProjectUseCase;
    private final DeleteProjectUseCase deleteProjectUseCase;

    public ProjectController(CreateProjectUseCase createProjectUseCase,
                             ListProjectsUseCase listProjectsUseCase,
                             GetProjectUseCase getProjectUseCase,
                             UpdateProjectUseCase updateProjectUseCase,
                             DeleteProjectUseCase deleteProjectUseCase) {
        this.createProjectUseCase = createProjectUseCase;
        this.listProjectsUseCase = listProjectsUseCase;
        this.getProjectUseCase = getProjectUseCase;
        this.updateProjectUseCase = updateProjectUseCase;
        this.deleteProjectUseCase = deleteProjectUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectResponse create(@Valid @RequestBody ProjectRequest request, Authentication authentication) {
        return ProjectResponse.from(createProjectUseCase.create(
                new CreateProjectCommand(authentication.getName(), request.title(), request.description())));
    }

    @GetMapping
    public List<ProjectResponse> list(Authentication authentication) {
        return listProjectsUseCase.list(authentication.getName()).stream()
                .map(ProjectResponse::from)
                .toList();
    }

    @GetMapping("/{id}")
    public ProjectResponse get(@PathVariable Long id, Authentication authentication) {
        return ProjectResponse.from(getProjectUseCase.get(authentication.getName(), id));
    }

    @PutMapping("/{id}")
    public ProjectResponse update(@PathVariable Long id,
                                  @Valid @RequestBody ProjectRequest request,
                                  Authentication authentication) {
        return ProjectResponse.from(updateProjectUseCase.update(
                new UpdateProjectCommand(authentication.getName(), id, request.title(), request.description())));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id, Authentication authentication) {
        deleteProjectUseCase.delete(authentication.getName(), id);
    }
}