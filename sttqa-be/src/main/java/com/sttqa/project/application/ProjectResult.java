package com.sttqa.project.application;

import com.sttqa.project.domain.Project;

import java.time.Instant;

public record ProjectResult(Long id, String title, String description, Instant createdAt) {

    public static ProjectResult from(Project project) {
        return new ProjectResult(
                project.getId(),
                project.getTitle(),
                project.getDescription(),
                project.getCreatedAt());
    }
}