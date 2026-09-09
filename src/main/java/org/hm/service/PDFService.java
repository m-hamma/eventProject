package org.hm.service;

import org.hm.event.InvoiceCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
@Service
public class PDFService {

    private static final Logger log =
            LoggerFactory.getLogger(PDFService.class);

    @EventListener
    public void consume(InvoiceCreatedEvent event) {

        log.info("=== Début PDFService ===");

        log.info(
                "PDF généré pour la commande {}",
                event.orderId()
        );

        log.info("=== Fin PDFService ===");
    }
}
