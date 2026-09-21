-- V21__test_flyway.sql

CREATE TABLE IF NOT EXISTS referentiel.test_v21 (
                                                    id BIGSERIAL PRIMARY KEY,
                                                    libelle VARCHAR(100)
    );

INSERT INTO referentiel.test_v21(libelle)
VALUES ('TEST FLYWAY');