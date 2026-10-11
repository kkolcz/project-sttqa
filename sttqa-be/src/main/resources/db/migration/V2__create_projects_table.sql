CREATE TABLE projects (
                          id          BIGSERIAL PRIMARY KEY,
                          owner_id    BIGINT       NOT NULL REFERENCES users (id),
                          title       VARCHAR(200) NOT NULL,
                          description VARCHAR(2000),
                          created_at  TIMESTAMPTZ  NOT NULL DEFAULT now()
);

CREATE INDEX idx_projects_owner_id ON projects (owner_id);
