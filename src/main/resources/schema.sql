CREATE TABLE IF NOT EXISTS orders
(
    id         BIGSERIAL PRIMARY KEY,
    customer   VARCHAR(255) NOT NULL,
    created_at TIMESTAMP    NOT NULL,
    status     VARCHAR(30)  NOT NULL
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