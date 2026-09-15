package org.hm.controller.rest;

import org.hm.dto.ProductDto;
import org.hm.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/referentiel")
public class ReferentielController {

    private final ProductService productService;

    public ReferentielController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductDto> products() {
        return productService.findAll();
    }
    @GetMapping("/products/{id}")
    public ProductDto product(@PathVariable("id") Long id) {
        return productService.findById(id);
    }
}
