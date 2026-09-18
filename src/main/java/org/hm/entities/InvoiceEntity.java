package org.hm.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(
        name = "invoices",
        schema = "event"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String invoiceNumber;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

}