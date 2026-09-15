INSERT INTO products(code, libelle, prix)
VALUES ('PR1', 'Produit 1', 15.00)
    ON CONFLICT (code) DO NOTHING;

INSERT INTO products(code, libelle, prix)
VALUES ('PR2', 'Produit 2', 20.00)
    ON CONFLICT (code) DO NOTHING;

INSERT INTO products(code, libelle, prix)
VALUES ('PR3', 'Produit 3', 30.00)
    ON CONFLICT (code) DO NOTHING;