CREATE TABLE IF NOT EXISTS referentiel.roles (
                                                 id BIGSERIAL PRIMARY KEY,
                                                 code VARCHAR(30) NOT NULL UNIQUE,
    libelle VARCHAR(100) NOT NULL
    );

CREATE TABLE IF NOT EXISTS referentiel.users (
                                                 id BIGSERIAL PRIMARY KEY,
                                                 username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role_id BIGINT NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_users_role
    FOREIGN KEY (role_id)
    REFERENCES referentiel.roles(id)
    );

-- Facultatif : index sur la FK
CREATE INDEX IF NOT EXISTS idx_users_role_id
    ON referentiel.users(role_id);