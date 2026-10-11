package com.sttqa.project.domain;

import com.sttqa.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.Instant;

@Entity
@Table(name = "projects")
@Getter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(length = 2000)
    private String description;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    protected Project() {}

    public Project(User owner, String title, String description) {
        this.owner = owner;
        this.title = title;
        this.description = description;
        this.createdAt = Instant.now();
    }

    public void update(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
