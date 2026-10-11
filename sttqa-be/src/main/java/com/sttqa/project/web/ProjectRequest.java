package com.sttqa.project.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProjectRequest(
        @NotBlank @Size(max = 200) String title,
        @Size(max = 2000) String description) {
}