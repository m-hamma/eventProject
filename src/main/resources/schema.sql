CREATE TABLE IF NOT EXISTS orders
(
    id          BIGSERIAL PRIMARY KEY,
    customer    VARCHAR(255) NOT NULL,
    description VARCHAR(500),
    created_at  TIMESTAMP    NOT NULL,
    updated_at  TIMESTAMP,
    status      VARCHAR(30)  NOT NULL
    );

CREATE TABLE IF NOT EXISTS invoices
(
    id             BIGSERIAL PRIMARY KEY,
    order_id       BIGINT       NOT NULL,
    invoice_number VARCHAR(100) NOT NULL,
    created_at     TIMESTAMP    NOT NULL,

    CONSTRAINT fk_invoice_order
    FOREIGN KEY (order_id)
    REFERENCES orders (id)
    );
CREATE TABLE IF NOT EXISTS order_items
(
    id         BIGSERIAL PRIMARY KEY,
    order_id   BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity   INTEGER NOT NULL,
    unit_price NUMERIC(10,2) NOT NULL,

    CONSTRAINT fk_order_item_order
    FOREIGN KEY (order_id)
    REFERENCES orders(id),

    CONSTRAINT fk_order_item_product
    FOREIGN KEY (product_id)
    REFERENCES products(id)
    );

CREATE TABLE IF NOT EXISTS products
(
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,
    libelle VARCHAR(255) NOT NULL,
    prix NUMERIC(10,2) NOT NULL
    );
ALTER TABLE order_items
    ADD COLUMN IF NOT EXISTS product_id BIGINT;