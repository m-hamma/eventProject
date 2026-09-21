-- ==========================================================
-- V1__initial_schema.sql
-- Etat initial avant les migrations V2..V14
-- ==========================================================

CREATE TABLE public.clients
(
    id        BIGSERIAL PRIMARY KEY,
    code      VARCHAR(50)  NOT NULL UNIQUE,
    nom       VARCHAR(255) NOT NULL,
    email     VARCHAR(255),
    telephone VARCHAR(50)
);

CREATE TABLE public.products
(
    id      BIGSERIAL PRIMARY KEY,
    code    VARCHAR(255)   NOT NULL UNIQUE,
    libelle VARCHAR(255)   NOT NULL,
    prix    NUMERIC(38, 2) NOT NULL
);

CREATE TABLE public.orders
(
    id          BIGSERIAL PRIMARY KEY,
    created_at  TIMESTAMP NOT NULL,
    customer    VARCHAR(255) NOT NULL,
    status      VARCHAR(255) NOT NULL,
    description VARCHAR(500),
    updated_at  TIMESTAMP
);

CREATE TABLE public.order_items
(
    id         BIGSERIAL PRIMARY KEY,
    order_id   BIGINT         NOT NULL,
    quantity   INTEGER        NOT NULL,
    unit_price NUMERIC(38, 2) NOT NULL,
    product_id BIGINT         NOT NULL
);

ALTER TABLE public.order_items
    ADD CONSTRAINT fk_order_item_order
        FOREIGN KEY (order_id)
            REFERENCES public.orders (id);

ALTER TABLE public.order_items
    ADD CONSTRAINT fk_order_item_product
        FOREIGN KEY (product_id)
            REFERENCES public.products (id);