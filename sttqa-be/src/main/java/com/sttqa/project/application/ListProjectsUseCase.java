package com.sttqa.project.application;

import java.util.List;

public interface ListProjectsUseCase {
    List<ProjectResult> list(String ownerUsername);
}