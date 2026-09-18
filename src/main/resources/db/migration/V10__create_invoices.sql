CREATE TABLE event.invoices (
                                id BIGSERIAL PRIMARY KEY,
                                invoice_number VARCHAR(50) NOT NULL UNIQUE,
                                created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                order_id BIGINT NOT NULL,

                                CONSTRAINT fk_invoice_order
                                    FOREIGN KEY (order_id)
                                        REFERENCES event.orders(id)
);