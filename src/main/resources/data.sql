INSERT INTO products(code, libelle, prix)
VALUES ('PR1', 'Produit 1', 10.00)
    ON CONFLICT (code) DO NOTHING;

INSERT INTO products(code, libelle, prix)
VALUES ('PR2', 'Produit 2', 20.00)
    ON CONFLICT (code) DO NOTHING;

INSERT INTO products(code, libelle, prix)
VALUES ('PR3', 'Produit 3', 30.00)
    ON CONFLICT (code) DO NOTHING;

INSERT INTO products(code, libelle, prix)
VALUES ('PR4', 'Clavier', 49.90)
    ON CONFLICT (code) DO NOTHING;

INSERT INTO products(code, libelle, prix)
VALUES ('PR5', 'Souris', 19.90)
    ON CONFLICT (code) DO NOTHING;

INSERT INTO products(code, libelle, prix)
VALUES ('PR6', 'Écran 24 pouces', 199.90)
    ON CONFLICT (code) DO NOTHING;

INSERT INTO products(code, libelle, prix)
VALUES ('PR7', 'PC Portable', 899.00)
    ON CONFLICT (code) DO NOTHING;

INSERT INTO products(code, libelle, prix)
VALUES ('PR8', 'Casque Audio', 79.90)
    ON CONFLICT (code) DO NOTHING;

INSERT INTO products(code, libelle, prix)
VALUES ('PR9', 'Webcam', 59.90)
    ON CONFLICT (code) DO NOTHING;

INSERT INTO products(code, libelle, prix)
VALUES ('PR10', 'Station d''accueil', 149.90)
    ON CONFLICT (code) DO NOTHING;