
INSERT INTO referentiel.clients (code, nom, email, telephone)
VALUES ('CL001', 'Société ABC', 'abc@client.fr', '0102030401'),
       ('CL002', 'Société XYZ', 'xyz@client.fr', '0102030402'),
       ('CL003', 'Entreprise Delta', 'delta@client.fr', '0102030403'),
       ('CL004', 'Tech Solutions', 'tech@client.fr', '0102030404'),
       ('CL005', 'Informatique Plus', 'info@client.fr', '0102030405'),
       ('CL006', 'Web Factory', 'web@client.fr', '0102030406'),
       ('CL007', 'Digital Services', 'digital@client.fr', '0102030407'),
       ('CL008', 'Alpha Consulting', 'alpha@client.fr', '0102030408'),
       ('CL009', 'Beta Conseil', 'beta@client.fr', '0102030409'),
       ('CL010', 'Gamma Industrie', 'gamma@client.fr', '0102030410'),
       ('CL011', 'Omega Transport', 'omega@client.fr', '0102030411'),
       ('CL012', 'Nova Distribution', 'nova@client.fr', '0102030412'),
       ('CL013', 'Phoenix Group', 'phoenix@client.fr', '0102030413'),
       ('CL014', 'Global Trading', 'global@client.fr', '0102030414'),
       ('CL015', 'Sunrise Company', 'sunrise@client.fr', '0102030415'),
       ('CL016', 'Blue Ocean', 'blueocean@client.fr', '0102030416'),
       ('CL017', 'NextGen IT', 'nextgen@client.fr', '0102030417'),
       ('CL018', 'Smart Business', 'smart@client.fr', '0102030418'),
       ('CL019', 'Vision Partners', 'vision@client.fr', '0102030419'),
       ('CL020', 'Future Solutions', 'future@client.fr', '0102030420')
    ON CONFLICT (code) DO NOTHING;