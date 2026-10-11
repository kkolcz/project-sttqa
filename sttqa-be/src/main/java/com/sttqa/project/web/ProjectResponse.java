package com.sttqa.project.web;

import com.sttqa.project.application.ProjectResult;

import java.time.Instant;

public record ProjectResponse(Long id, String title, String description, Instant createdAt) {

    public static ProjectResponse from(ProjectResult result) {
        return new ProjectResponse(result.id(), result.title(), result.description(), result.createdAt());
    }
}