#!/bin/bash

echo "=== Initialisation BDD ==="

psql -h localhost -U mohamed.hamma -d eventdb \
-f src/main/resources/schema.sql

psql -h localhost -U mohamed.hamma -d eventdb \
-f src/main/resources/data.sql

echo "=== Migrations ==="

psql -h localhost -U mohamed.hamma -d eventdb \
-f src/main/resources/db/migration/V1__create_clients.sql

psql -h localhost -U mohamed.hamma -d eventdb \
-f src/main/resources/db/migration/V2__order_add_libelle.sql

psql -h localhost -U mohamed.hamma -d eventdb \
-f src/main/resources/db/migration/V3__order_add_client_id.sql

echo "=== Fin ==="