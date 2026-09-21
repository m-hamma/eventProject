INSERT INTO referentiel.users (
    username,
    password,
    role_id,
    enabled
)
SELECT
    'admin',
    '{noop}admin',
    id,
    TRUE
FROM referentiel.roles
WHERE code = 'ADMIN'
    ON CONFLICT (username) DO NOTHING;

INSERT INTO referentiel.users (
    username,
    password,
    role_id,
    enabled
)
SELECT
    'manager',
    '{noop}manager',
    id,
    TRUE
FROM referentiel.roles
WHERE code = 'MANAGER'
    ON CONFLICT (username) DO NOTHING;

INSERT INTO referentiel.users (
    username,
    password,
    role_id,
    enabled
)
SELECT
    'user1',
    '{noop}user1',
    id,
    TRUE
FROM referentiel.roles
WHERE code = 'USER'
    ON CONFLICT (username) DO NOTHING;

INSERT INTO referentiel.users (
    username,
    password,
    role_id,
    enabled
)
SELECT
    'user2',
    '{noop}user2',
    id,
    TRUE
FROM referentiel.roles
WHERE code = 'USER'
    ON CONFLICT (username) DO NOTHING;

INSERT INTO referentiel.users (
    username,
    password,
    role_id,
    enabled
)
SELECT
    'user3',
    '{noop}user3',
    id,
    TRUE
FROM referentiel.roles
WHERE code = 'USER'
    ON CONFLICT (username) DO NOTHING;

INSERT INTO referentiel.users (
    username,
    password,
    role_id,
    enabled
)
SELECT
    'user4',
    '{noop}user4',
    id,
    TRUE
FROM referentiel.roles
WHERE code = 'USER'
    ON CONFLICT (username) DO NOTHING;

INSERT INTO referentiel.users (
    username,
    password,
    role_id,
    enabled
)
SELECT
    'user5',
    '{noop}user5',
    id,
    TRUE
FROM referentiel.roles
WHERE code = 'USER'
    ON CONFLICT (username) DO NOTHING;

INSERT INTO referentiel.users (
    username,
    password,
    role_id,
    enabled
)
SELECT
    'auditor',
    '{noop}auditor',
    id,
    TRUE
FROM referentiel.roles
WHERE code = 'AUDITOR'
    ON CONFLICT (username) DO NOTHING;

INSERT INTO referentiel.users (
    username,
    password,
    role_id,
    enabled
)
SELECT
    'support',
    '{noop}support',
    id,
    TRUE
FROM referentiel.roles
WHERE code = 'SUPPORT'
    ON CONFLICT (username) DO NOTHING;

INSERT INTO referentiel.users (
    username,
    password,
    role_id,
    enabled
)
SELECT
    'guest',
    '{noop}guest',
    id,
    FALSE
FROM referentiel.roles
WHERE code = 'GUEST'
    ON CONFLICT (username) DO NOTHING;