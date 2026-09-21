-- ==========================================================
-- V100__baseline.sql
-- Baseline de l'application Event Project
-- ==========================================================

CREATE SCHEMA IF NOT EXISTS event;
CREATE SCHEMA IF NOT EXISTS referentiel;

-- ==========================================================
-- TABLES REFERENTIEL
-- ==========================================================

CREATE TABLE referentiel.clients (
                                     id BIGSERIAL PRIMARY KEY,
                                     code VARCHAR(50) NOT NULL UNIQUE,
                                     nom VARCHAR(255) NOT NULL,
                                     email VARCHAR(255),
                                     telephone VARCHAR(50)
);

CREATE TABLE referentiel.products (
                                      id BIGSERIAL PRIMARY KEY,
                                      code VARCHAR(255) NOT NULL UNIQUE,
                                      libelle VARCHAR(255) NOT NULL,
                                      prix NUMERIC(38,2) NOT NULL
);

-- ==========================================================
-- TABLES EVENT
-- ==========================================================

CREATE TABLE event.orders (
                              id BIGSERIAL PRIMARY KEY,
                              created_at TIMESTAMP NOT NULL,
                              status VARCHAR(255) NOT NULL,
                              description VARCHAR(500),
                              updated_at TIMESTAMP,
                              libelle VARCHAR(255),
                              client_id BIGINT NOT NULL
);

CREATE TABLE event.order_items (
                                   id BIGSERIAL PRIMARY KEY,
                                   order_id BIGINT NOT NULL,
                                   quantity INTEGER NOT NULL,
                                   unit_price NUMERIC(38,2) NOT NULL,
                                   product_id BIGINT
);

CREATE TABLE event.invoices (
                                id BIGSERIAL PRIMARY KEY,
                                invoice_number VARCHAR(50) NOT NULL UNIQUE,
                                created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                order_id BIGINT NOT NULL
);

-- ==========================================================
-- FOREIGN KEYS
-- ==========================================================

ALTER TABLE event.order_items
    ADD CONSTRAINT fk_order_item_order
        FOREIGN KEY (order_id)
            REFERENCES event.orders(id);

ALTER TABLE event.order_items
    ADD CONSTRAINT fk_order_item_product
        FOREIGN KEY (product_id)
            REFERENCES referentiel.products(id);

ALTER TABLE event.invoices
    ADD CONSTRAINT fk_invoice_order
        FOREIGN KEY (order_id)
            REFERENCES event.orders(id);