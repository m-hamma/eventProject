package org.hm.service;

import org.hm.event.InvoiceCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class AccountingService {

    private static final Logger log =
            LoggerFactory.getLogger(AccountingService.class);

    @EventListener
    public void consume(InvoiceCreatedEvent event) {

        log.info("=== Début AccountingService ===");

        log.info(
                "Écriture comptable créée pour la commande {}",
                event.orderId()
        );

        log.info("=== Fin AccountingService ===");
    }
}