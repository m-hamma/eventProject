-- Future migration

ALTER TABLE orders
    ADD COLUMN IF NOT EXISTS client_id BIGINT;

-- remplacement progressif de customer par client_id

-- ALTER TABLE orders
-- ADD CONSTRAINT fk_order_client
-- FOREIGN KEY (client_id)
-- REFERENCES clients(id);