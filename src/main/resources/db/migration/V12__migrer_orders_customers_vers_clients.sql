UPDATE event.orders o
SET client_id = c.id
FROM referentiel.clients c
WHERE c.nom = o.customer
  AND o.client_id IS NULL;
