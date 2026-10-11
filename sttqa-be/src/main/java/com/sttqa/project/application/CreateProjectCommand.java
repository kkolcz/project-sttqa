package com.sttqa.project.application;

import org.flywaydb.core.FlywayExecutor;

public record CreateProjectCommand(String ownerUsername, String title, String description) {
}
