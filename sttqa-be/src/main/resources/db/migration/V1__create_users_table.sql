CREATE TABLE users (
                       id         BIGSERIAL PRIMARY KEY,
                       username   VARCHAR(64)  NOT NULL UNIQUE,
                       password   VARCHAR(255) NOT NULL,
                       role       VARCHAR(32)  NOT NULL DEFAULT 'USER',
                       created_at TIMESTAMPTZ  NOT NULL DEFAULT now()
);
