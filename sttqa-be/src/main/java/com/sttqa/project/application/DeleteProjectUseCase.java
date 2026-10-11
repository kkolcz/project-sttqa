package com.sttqa.project.application;

public interface DeleteProjectUseCase {
    void delete(String ownerUsername, Long projectId);
}
