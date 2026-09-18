package org.hm.controller.rest;

import org.hm.dto.ClientDto;
import org.hm.dto.ProductDto;
import org.hm.service.ClientService;
import org.hm.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/referentiel")
public class ReferentielController {

    private final ProductService productService;
    private final ClientService clientService;

    public ReferentielController(
            ProductService productService,
            ClientService clientService) {

        this.productService = productService;
        this.clientService = clientService;
    }

    @GetMapping("/products")
    public List<ProductDto> products() {
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public ProductDto product(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/clients")
    public List<ClientDto> clients() {
        return clientService.findAll();
    }

    @GetMapping("/clients/{id}")
    public ClientDto client(@PathVariable Long id) {
        return clientService.findById(id);
    }
}