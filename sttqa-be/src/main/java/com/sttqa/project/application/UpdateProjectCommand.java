package com.sttqa.project.application;

public record UpdateProjectCommand(String ownerUsername, Long projectId, String title, String description) {
}