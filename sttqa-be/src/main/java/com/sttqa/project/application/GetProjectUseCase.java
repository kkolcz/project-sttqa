package com.sttqa.project.application;

public interface GetProjectUseCase {
    ProjectResult get(String ownerUsername, Long projectId);
}