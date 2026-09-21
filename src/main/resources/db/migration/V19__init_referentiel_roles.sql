INSERT INTO referentiel.roles (code, libelle)
VALUES
    ('ADMIN',   'Administrateur'),
    ('MANAGER', 'Manager'),
    ('USER',    'Utilisateur'),
    ('AUDITOR', 'Auditeur'),
    ('SUPPORT', 'Support'),
    ('GUEST',   'Invité')
    ON CONFLICT (code) DO NOTHING;